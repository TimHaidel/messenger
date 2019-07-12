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

import by.itacademy.jd2.th.messenger.dao.api.entity.table.ISmile;
import by.itacademy.jd2.th.messenger.dao.api.filter.SmileFilter;
import by.itacademy.jd2.th.messenger.service.ISmileService;
import by.itacademy.jd2.th.messenger.web.converter.SmileToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.SmileDTO;

@Controller
@RequestMapping(value = "/smile")
public class SmileController {

	private ISmileService smileService;

	private SmileToDTOConverter toDtoConverter;

	@Autowired
	private SmileController(ISmileService smileService, SmileToDTOConverter toDtoConverter) {
		super();
		this.smileService = smileService;
		this.toDtoConverter = toDtoConverter;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final SmileFilter filter = new SmileFilter();

		final List<ISmile> entities = smileService.find(filter);
		List<SmileDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		return new ModelAndView("smile.list", models);
	}

}
