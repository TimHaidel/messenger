package by.itacademy.jd2.th.messenger.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class DefaultController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "home";
	}

}