package by.itacademy.jd2.th.messenger.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IContact;
import by.itacademy.jd2.th.messenger.dao.api.filter.ContactFilter;
import by.itacademy.jd2.th.messenger.service.IContactService;
import by.itacademy.jd2.th.messenger.web.converter.ContactToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.ContactDTO;
import by.itacademy.jd2.th.messenger.web.dto.grid.GridStateDTO;
import by.itacademy.jd2.th.messenger.web.security.AuthHelper;

@Controller
@RequestMapping(value = "/chat")
public class ChatController extends AbstractController {

	private IContactService contactService;
	private ContactToDTOConverter toDtoConverter;

	@Autowired
	public ChatController(IContactService contactService, ContactToDTOConverter toDtoConverter) {
		super();
		this.contactService = contactService;
		this.toDtoConverter = toDtoConverter;
	}

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
		List<ContactDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(contactService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);

		return new ModelAndView("chat", models);
	}

}
