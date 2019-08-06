package by.itacademy.jd2.th.messenger.web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class DefaultController extends AbstractController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(Locale locale) {
		ModelAndView modelAndView = new ModelAndView("home");

		String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();

		modelAndView.addObject("welcomeMessage",
				messageSource.getMessage("page.home.welcomeMessage", new Object[] { login }, locale));

		return modelAndView;
	}

}