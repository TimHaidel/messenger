package by.itacademy.jd2.th.messenger.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IAttachment;
import by.itacademy.jd2.th.messenger.dao.api.filter.AttachmentFilter;
import by.itacademy.jd2.th.messenger.service.IAttachmentService;
import by.itacademy.jd2.th.messenger.web.converter.AttachmentFromDTOConverter;
import by.itacademy.jd2.th.messenger.web.converter.AttachmentToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.AttachmentDTO;
import by.itacademy.jd2.th.messenger.web.dto.grid.GridStateDTO;

@Controller
@RequestMapping(value = "/attachment")
public class AttachmentController extends AbstractController {

	private IAttachmentService attachmentService;
	private AttachmentToDTOConverter toDtoConverter;
	private AttachmentFromDTOConverter fromDtoConverter;

	@Autowired
	public AttachmentController(IAttachmentService attachmentService, AttachmentToDTOConverter toDtoConverter,
			AttachmentFromDTOConverter fromDtoConverter) {
		super();
		this.attachmentService = attachmentService;
		this.toDtoConverter = toDtoConverter;
		this.fromDtoConverter = fromDtoConverter;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {

		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final AttachmentFilter filter = new AttachmentFilter();
		prepareFilter(gridState, filter);

		final List<IAttachment> entities = attachmentService.find(filter);
		List<AttachmentDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(attachmentService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		return new ModelAndView("attachment.list", models);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IAttachment newEntity = attachmentService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(newEntity));

		return new ModelAndView("attachment.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("formModel") final AttachmentDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "attachment.edit";
		} else {
			final IAttachment entity = fromDtoConverter.apply(formModel);
			attachmentService.save(entity);
			return "redirect:/attachment";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		attachmentService.delete(id);
		return "redirect:/attachment";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final IAttachment dbModel = attachmentService.get(id);
		final AttachmentDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);

		return new ModelAndView("attachemnt.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final AttachmentDTO dto = toDtoConverter.apply(attachmentService.get(id));

		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);

		return new ModelAndView("attachment.edit", hashMap);
	}

}
