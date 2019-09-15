package by.itacademy.jd2.th.messenger.web.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itacademy.jd2.th.messenger.web.security.AuthHelper;

@Controller
@RequestMapping(value = "/")
public class DefaultController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(Locale locale) {

		if (AuthHelper.isAdmin() || AuthHelper.hasRole("user")) {
			return "redirect:/chat";
		} else {
			return "redirect:/login";
		}
	}

}