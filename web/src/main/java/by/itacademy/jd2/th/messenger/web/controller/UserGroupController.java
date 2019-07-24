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

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserGroupFilter;
import by.itacademy.jd2.th.messenger.service.IUserGroupService;
import by.itacademy.jd2.th.messenger.web.converter.UserGroupFromDTO;
import by.itacademy.jd2.th.messenger.web.converter.UserGroupToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.UserGroupDTO;
import by.itacademy.jd2.th.messenger.web.dto.grid.GridStateDTO;

@Controller
@RequestMapping(value = "/user-group")
public class UserGroupController extends AbstractController {

	IUserGroupService userGroupService;
	UserGroupToDTOConverter toDtoConverter;
	UserGroupFromDTO fromDtoConverter;

	@Autowired
	public UserGroupController(IUserGroupService userGroupService, UserGroupToDTOConverter toDtoConverter,
			UserGroupFromDTO fromDtoConverter) {
		super();
		this.userGroupService = userGroupService;
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

		final UserGroupFilter filter = new UserGroupFilter();
		prepareFilter(gridState, filter);

		final List<IUserGroup> entities = userGroupService.find(filter);
		List<UserGroupDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(userGroupService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		return new ModelAndView("user-group.list", models);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IUserGroup newEntity = userGroupService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(newEntity));

		return new ModelAndView("user-group.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("formModel") final UserGroupDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "user-group.edit";
		} else {
			final IUserGroup entity = fromDtoConverter.apply(formModel);
			userGroupService.save(entity);
			return "redirect:/user-group";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		userGroupService.delete(id);
		return "redirect:/user-group";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final IUserGroup dbModel = userGroupService.get(id);
		final UserGroupDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);

		return new ModelAndView("user-group.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final UserGroupDTO dto = toDtoConverter.apply(userGroupService.get(id));

		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);

		return new ModelAndView("user-group.edit", hashMap);
	}

}
