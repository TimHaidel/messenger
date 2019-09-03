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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
import by.itacademy.jd2.th.messenger.service.impl.UserAccountServiceImpl;
import by.itacademy.jd2.th.messenger.web.converter.ContactToDTOConverter;
import by.itacademy.jd2.th.messenger.web.converter.MessageToDTOConverter;
import by.itacademy.jd2.th.messenger.web.converter.UserGroupToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.ContactDTO;
import by.itacademy.jd2.th.messenger.web.dto.MessageDTO;
import by.itacademy.jd2.th.messenger.web.dto.UserGroupDTO;
import by.itacademy.jd2.th.messenger.web.dto.ajax.MessageAjaxDTO;
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
	private UserGroupToDTOConverter userGroupToDtoConverter;
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

		Integer loggedUserId = AuthHelper.getLoggedUserId();
		final ContactFilter filter = new ContactFilter();
		filter.setInitiatorId(loggedUserId);
		prepareFilter(gridState, filter);

		final List<IContact> contacts = contactService.find(filter);
		List<ContactDTO> contactDtos = contacts.stream().map(contactToDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(contactService.getCount(filter));

		UserGroupFilter userGroupFilter = new UserGroupFilter();
		userGroupFilter.setUserId(loggedUserId);
		List<IUserGroup> groups = userGroupService.find(userGroupFilter);
		List<UserGroupDTO> groupDtos = groups.stream().map(userGroupToDtoConverter).collect(Collectors.toList());

		final Map<String, Object> models = new HashMap<>();
		models.put("contactItems", contactDtos);
		models.put("groupItems", groupDtos);
		// models.put("loggedUserId", loggedUserId);

		return new ModelAndView("chat", models);
	}

	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public ResponseEntity<List<MessageDTO>> getGroupMessages(
			@RequestParam(name = "groupId", required = true) final Integer groupId) {

		MessageFilter filter = new MessageFilter();
		filter.setUserGroupId(groupId);

		final List<IMessage> entities = messageService.find(filter);
		List<MessageDTO> dtos = entities.stream().map(messageToDtoConverter).collect(Collectors.toList());

		Integer loggedUserId = AuthHelper.getLoggedUserId();

		for (MessageDTO messageDTO : dtos) {
			messageDTO.setCurrentUser(messageDTO.getUser().getId().equals(loggedUserId));
		}

		return new ResponseEntity<List<MessageDTO>>(dtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/group", method = RequestMethod.GET)
	@ResponseBody
	public String getGroup(@RequestParam(name = "contactId", required = true) final Integer contactId) {

		IContact contact = contactService.getFullInfo(contactId);

		IUserAccount acceptor = contact.getAcceptor();
		IUserAccount initiator = contact.getInitiator();

		IUserGroup createdGroup = null;
		Integer groupId = userGroupService.findGroupId(acceptor.getId(), initiator.getId());
		if (groupId == null) {
			IUserGroup userGroup = userGroupService.createEntity();
			userGroup.setName("Group with " + acceptor.getFirstname() + " : " + initiator.getFirstname());
			userGroup.setUsersCount(2);
			createdGroup = userGroupService.save(userGroup);
			groupId = createdGroup.getId();

			IUserToGroup userToGroupInitiator = userToGroupService.createEntity();
			userToGroupInitiator.setUser(initiator);
			userToGroupInitiator.setGroup(userGroup);
			userToGroupInitiator.setGroupRole(1);
			IUserToGroup userToGroupAcceptor = userToGroupService.createEntity();
			userToGroupAcceptor.setUser(acceptor);
			userToGroupAcceptor.setGroup(userGroup);
			userToGroupAcceptor.setGroupRole(0);
			userToGroupService.save(userToGroupInitiator, userToGroupAcceptor);

		}

		return Integer.toString(groupId);
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void saveMessage(@RequestBody final MessageAjaxDTO messageDto) {
		IMessage message = messageService.createEntity();
		message.setMessage(messageDto.getMessage());

		IUserAccount user = userAccountService.createEntity();
		user.setId(AuthHelper.getLoggedUserId());
		message.setUser(user);

		IUserGroup userGroup = userGroupService.createEntity();
		userGroup.setId(messageDto.getUserGroupId());
		message.setUserGroup(userGroup);

		messageService.save(message);

	}

}
