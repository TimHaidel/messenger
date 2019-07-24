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

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;
import by.itacademy.jd2.th.messenger.service.ISmileGroupService;
import by.itacademy.jd2.th.messenger.service.ISmileService;
import by.itacademy.jd2.th.messenger.web.converter.SmileFromDTOConverter;
import by.itacademy.jd2.th.messenger.web.converter.SmileToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.SmileDTO;
import by.itacademy.jd2.th.messenger.web.dto.grid.GridStateDTO;

@Controller
@RequestMapping(value = "/smile")
public class SmileController extends AbstractController {

	private ISmileService smileService;
	private SmileToDTOConverter toDtoConverter;
	private SmileFromDTOConverter fromDtoConverter;
	private ISmileGroupService smileGroupService;

	@Autowired
	public SmileController(ISmileService smileService, SmileToDTOConverter toDtoConverter,
			SmileFromDTOConverter fromDtoConverter, ISmileGroupService smileGroupService) {
		super();
		this.smileService = smileService;
		this.toDtoConverter = toDtoConverter;
		this.fromDtoConverter = fromDtoConverter;
		this.smileGroupService = smileGroupService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {

		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final SmileFilter filter = new SmileFilter();
		prepareFilter(gridState, filter);

		final List<ISmile> entities = smileService.find(filter);
		List<SmileDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(smileService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		return new ModelAndView("smile.list", models);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final ISmile newEntity = smileService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(newEntity));
		loadFormSmiles(hashMap);
		return new ModelAndView("smile.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("formModel") final SmileDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "smile.edit";
		} else {
			final ISmile entity = fromDtoConverter.apply(formModel);
			smileService.save(entity);
			return "redirect:/smile";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		smileService.delete(id);
		return "redirect:/smile";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final ISmile dbModel = smileService.get(id);
		final SmileDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);
		loadFormSmiles(hashMap);
		return new ModelAndView("smile.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final SmileDTO dto = toDtoConverter.apply(smileService.get(id));

		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		loadFormSmiles(hashMap);
		return new ModelAndView("smile.edit", hashMap);
	}

	private void loadFormSmiles(final Map<String, Object> hashMap) {
		final List<ISmileGroup> smileGroups = smileGroupService.getAll();

		/*
		 * final Map<Integer, String> smileGroupsMap = new HashMap<>(); for (final
		 * ISmileGroup iSmileGroup : smileGroups) { smileGroups.put(iSmileGroup.getId(),
		 * iSmileGroup.getName()); }
		 */

		final Map<Integer, String> smileGroupsMap = smileGroups.stream()
				.collect(Collectors.toMap(ISmileGroup::getId, ISmileGroup::getName));
		hashMap.put("smileGroupsChoices", smileGroupsMap);

	}
}
