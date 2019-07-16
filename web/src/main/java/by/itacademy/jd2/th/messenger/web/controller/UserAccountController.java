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

import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.api.filter.UserAccountFilter;
import by.itacademy.jd2.th.messenger.service.IUserAccountService;
import by.itacademy.jd2.th.messenger.web.converter.UserAccountToDTOConverter;
import by.itacademy.jd2.th.messenger.web.dto.UserAccountDTO;

@Controller
@RequestMapping(value = "/user-account")
public class UserAccountController {

	private IUserAccountService userAccountService;
	private UserAccountToDTOConverter toDtoConverter;

	@Autowired
	public UserAccountController(IUserAccountService userAccountService, UserAccountToDTOConverter toDtoConverter) {
		super();
		this.userAccountService = userAccountService;
		this.toDtoConverter = toDtoConverter;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req) {

		final UserAccountFilter filter = new UserAccountFilter();

		final List<IUserAccount> entities = userAccountService.find(filter);
		List<UserAccountDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		return new ModelAndView("user-account.list", models);
	}

}
