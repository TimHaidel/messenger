package by.itacademy.jd2.th.messenger.web.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itacademy.jd2.th.messenger.dao.api.entity.enums.Roles;
import by.itacademy.jd2.th.messenger.dao.api.entity.table.IUserAccount;
import by.itacademy.jd2.th.messenger.dao.orm.impl.entity.UserAccount;
import by.itacademy.jd2.th.messenger.service.IUserAccountService;

@Controller
public class LoginController {
	@Autowired
	IUserAccountService userAccountService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) final String error,
			@RequestParam(value = "logout", required = false) final String logout) {

		final ModelAndView model = new ModelAndView();
		model.setViewName("login");

		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		return model;

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registration(@RequestParam(value = "error", required = false) final String error,
			@ModelAttribute UserAccount user) {
		user.setRole(Roles.user);
		boolean isUserExist = true;
		IUserAccount userFromDb = null;
		final ModelAndView model = new ModelAndView();
		model.setViewName("login");
		try {
			userAccountService.getByEmail(user.getEmail());
		} catch (NoResultException e) {
			System.out.println("Such user doesn't exist");
			userAccountService.save(user);
			isUserExist = false;
		}

		if (isUserExist) {
			return model.addObject("error", "Such user already exists!");
		}

//		if (error != null) {
//			model.addObject("error", "Invalid username and password!");
//		}

		return model;

	}
}