package by.itacademy.jd2.th.messenger.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.itacademy.jd2.th.messenger.service.IUserAccountService;

public class ServiceSpringContextExample {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("service-context.xml");
		System.out.println(context.getBean(IUserAccountService.class));

		// TODO show multiple candidates with Qualifier

	}
}