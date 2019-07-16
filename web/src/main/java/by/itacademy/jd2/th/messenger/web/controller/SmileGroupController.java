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
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmileGroup;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileGroupFilter;
import by.itacademy.jd2.th.messenger.service.ISmileGroupService;
import by.itacademy.jd2.th.messenger.web.converter.SmileGroupToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.SmileGroupDTO;

@Controller
@RequestMapping(value = "/smile-group")
public class SmileGroupController {

	private ISmileGroupService smileGroupService;

	private SmileGroupToDTOConverter toDtoConverter;

	@Autowired
	private SmileGroupController(ISmileGroupService smileGroupService, SmileGroupToDTOConverter toDtoConverter) {
		super();
		this.smileGroupService = smileGroupService;
		this.toDtoConverter = toDtoConverter;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final SmileGroupFilter filter = new SmileGroupFilter();

		final List<ISmileGroup> entities = smileGroupService.find(filter);
		List<SmileGroupDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		return new ModelAndView("smile-group.list", models);
	}

}
