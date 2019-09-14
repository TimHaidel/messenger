package by.itacademy.jd2.th.messenger.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IMessage;
import by.itacademy.jd2.th.messenger.dao.api.filter.MessageFilter;
import by.itacademy.jd2.th.messenger.service.IMessageService;
import by.itacademy.jd2.th.messenger.web.converter.MessageFromDTOConverter;
import by.itacademy.jd2.th.messenger.web.converter.MessageToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.MessageDTO;
import by.itacademy.jd2.th.messenger.web.dto.grid.GridStateDTO;
import by.itacademy.jd2.th.messenger.web.security.AuthHelper;

@Controller
@RequestMapping(value = "/message")
public class MessageController extends AbstractController {

	IMessageService messageService;
	MessageToDTOConverter toDtoConverter;
	MessageFromDTOConverter fromDtoConverter;
	private MessageToDTOConverter messageToDtoConverter;

	@Autowired
	public MessageController(IMessageService messageService, MessageToDTOConverter toDtoConverter,
			MessageFromDTOConverter fromDtoConverter, MessageToDTOConverter messageToDtoConverter) {
		super();
		this.messageService = messageService;
		this.toDtoConverter = toDtoConverter;
		this.fromDtoConverter = fromDtoConverter;
		this.messageToDtoConverter = messageToDtoConverter;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {

		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final MessageFilter filter = new MessageFilter();
		prepareFilter(gridState, filter);

		final List<IMessage> entities = messageService.find(filter);
		List<MessageDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(messageService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		return new ModelAndView("message.list", models);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IMessage newEntity = messageService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(newEntity));

		return new ModelAndView("message.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/attach", method = RequestMethod.POST)
	public String attach(@Valid @ModelAttribute("formModel") final MessageDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "message.edit";
		} else {
			final IMessage entity = fromDtoConverter.apply(formModel);
			messageService.save(entity);
			return "redirect:/message";
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("formModel") final MessageDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "message.edit";
		} else {
			final IMessage entity = fromDtoConverter.apply(formModel);
			messageService.save(entity);
			return "redirect:/message";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		messageService.delete(id);
		return "redirect:/message";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final IMessage dbModel = messageService.getFullInfo(id);
		final MessageDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);

		return new ModelAndView("message.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final MessageDTO dto = toDtoConverter.apply(messageService.getFullInfo(id));

		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);

		return new ModelAndView("message.edit", hashMap);
	}

	@RequestMapping(value = "/getpined", method = RequestMethod.GET)
	public ResponseEntity<List<MessageDTO>> getPinedMessages() {

		MessageFilter filter = new MessageFilter();
		filter.setUserAccountId(AuthHelper.getLoggedUserId());

		final List<IMessage> entities = messageService.getPinnedMessage(AuthHelper.getLoggedUserId());
		List<MessageDTO> dtos = entities.stream().map(messageToDtoConverter).collect(Collectors.toList());

		for (MessageDTO messageDTO : dtos) {
			messageDTO.setCurrentUser(messageDTO.getUserId().equals(AuthHelper.getLoggedUserId()));
		}

		return new ResponseEntity<List<MessageDTO>>(dtos, HttpStatus.OK);
	}

	@RequestMapping(value = "/pin", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void pinMessage(@RequestParam(name = "messageId", required = true) final Integer messageId) {

		messageService.pinMessage(messageId, AuthHelper.getLoggedUserId());
	}

	@RequestMapping(value = "/unpin", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void unPinMessage(@RequestParam(name = "messageId", required = true) final Integer messageId) {

		messageService.unpinMessage(messageId);
	}

}
