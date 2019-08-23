package by.itacademy.jd2.th.messenger.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserToGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;
import by.itacademy.jd2.th.messenger.service.IContactService;
import by.itacademy.jd2.th.messenger.service.IMessageService;
import by.itacademy.jd2.th.messenger.service.IUserAccountService;
import by.itacademy.jd2.th.messenger.service.IUserGroupService;
import by.itacademy.jd2.th.messenger.service.IUserToGroupService;
import by.itacademy.jd2.th.messenger.web.converter.ContactToDTOConverter;
import by.itacademy.jd2.th.messenger.web.converter.MessageToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.ContactDTO;
import by.itacademy.jd2.th.messenger.web.dto.MessageDTO;
import by.itacademy.jd2.th.messenger.web.dto.grid.GridStateDTO;
import by.itacademy.jd2.th.messenger.web.security.AuthHelper;

@Controller
@RequestMapping(value = "/chat")
public class ChatController extends AbstractController {
	@Autowired
	private IContactService contactService;
	@Autowired
	private ContactToDTOConverter contactToDtoConverter;
	@Autowired
	private IMessageService messageService;
	@Autowired
	private MessageToDTOConverter messageToDtoConverter;
	@Autowired
	private IUserGroupService userGroupService;
	@Autowired
	private IUserToGroupService userToGroupService;
	@Autowired
	private IUserAccountService userAccountService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {

		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final ContactFilter filter = new ContactFilter();
		filter.setInitiatorId(AuthHelper.getLoggedUserId());
		prepareFilter(gridState, filter);

		final List<IContact> entities = contactService.find(filter);
		List<ContactDTO> dtos = entities.stream().map(contactToDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(contactService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);

		return new ModelAndView("chat", models);
	}

	@RequestMapping(value = "/messages", method = RequestMethod.POST)
	public ResponseEntity<List<MessageDTO>> getGroupMessages(
			@RequestParam(name = "acceptorId", required = true) final Integer acceptorId) {

		Integer initiatorId = AuthHelper.getLoggedUserId();
		IUserAccount initiator = userAccountService.get(initiatorId);
		IUserAccount acceptor = userAccountService.get(acceptorId);

		UserGroupFilter groupFilter = new UserGroupFilter();
		groupFilter.setInitiatorId(initiatorId);
		groupFilter.setAcceptorId(acceptorId);
		// find groupId
		Integer groupId = userGroupService.findGroupId(groupFilter);
		if (groupId == null) {
			IUserGroup userGroup = userGroupService.createEntity();
			userGroup.setName("Group with " + initiatorId + " : " + acceptorId);
			userGroup.setUsersCount(2);
			userGroupService.save(userGroup);

			IUserToGroup userToGroupInitiator = userToGroupService.createEntity();
			userToGroupInitiator.setUser(initiator);
			userToGroupInitiator.setGroup(userGroup);
			userToGroupInitiator.setGroupRole(1);
			IUserToGroup userToGroupAcceptor = userToGroupService.createEntity();
			userToGroupAcceptor.setUser(acceptor);
			userToGroupAcceptor.setGroup(userGroup);
			userToGroupAcceptor.setGroupRole(0);
			userToGroupService.save(userToGroupInitiator, userToGroupAcceptor);

			groupId = userGroupService.findGroupId(groupFilter);
		}

		MessageFilter filter = new MessageFilter();
		filter.setUserGroupId(groupId);

		final List<IMessage> entities = messageService.find(filter);
		List<MessageDTO> dtos = entities.stream().map(messageToDtoConverter).collect(Collectors.toList());

		return new ResponseEntity<List<MessageDTO>>(dtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<MessageDTO> saveMessage(@RequestParam(name = "text", required = true) final String text) {
		System.out.println(text);
		IMessage message = messageService.createEntity();
		message.setMessage(text);
		messageService.save(message);

		MessageDTO dto = messageToDtoConverter.apply(message);

		return new ResponseEntity<MessageDTO>(dto, HttpStatus.OK);
	}

}
