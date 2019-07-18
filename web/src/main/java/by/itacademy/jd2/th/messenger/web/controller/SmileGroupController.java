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

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileGroupFilter;
import by.itacademy.jd2.th.messenger.service.ISmileGroupService;
import by.itacademy.jd2.th.messenger.web.converter.SmileGroupFromDTOConverter;
import by.itacademy.jd2.th.messenger.web.converter.SmileGroupToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.SmileGroupDTO;
import by.itacademy.jd2.th.messenger.web.dto.grid.GridStateDTO;

@Controller
@RequestMapping(value = "/smile-group")
public class SmileGroupController extends AbstractController {

	private ISmileGroupService smileGroupService;

	private SmileGroupToDTOConverter toDtoConverter;

	private SmileGroupFromDTOConverter fromDtoConverter;

	@Autowired
	public SmileGroupController(ISmileGroupService smileGroupService, SmileGroupToDTOConverter toDtoConverter,
			SmileGroupFromDTOConverter fromDtoConverter) {
		super();
		this.smileGroupService = smileGroupService;
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

		final SmileGroupFilter filter = new SmileGroupFilter();
		prepareFilter(gridState, filter);

		final List<ISmileGroup> entities = smileGroupService.find(filter);
		List<SmileGroupDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(smileGroupService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		return new ModelAndView("smile-group.list", models);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final ISmileGroup newEntity = smileGroupService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(newEntity));

		return new ModelAndView("smile-group.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("formModel") final SmileGroupDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "smile-group.edit";
		} else {
			final ISmileGroup entity = fromDtoConverter.apply(formModel);
			smileGroupService.save(entity);
			return "redirect:/smile-group";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		smileGroupService.delete(id);
		return "redirect:/smile-group";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final ISmileGroup dbModel = smileGroupService.get(id);
		final SmileGroupDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);

		return new ModelAndView("smile-group.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final SmileGroupDTO dto = toDtoConverter.apply(smileGroupService.get(id));

		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);

		return new ModelAndView("smile-group.edit", hashMap);
	}
}
