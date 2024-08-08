package com.example.SpringBasicDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBasicDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBasicDemoApplication.class, args);

		ComponentSMS componentSMS = context.getBean(ComponentSMS.class);
		componentSMS.prinf();

		ControllerSMS controllerSMS = context.getBean(ControllerSMS.class);
		controllerSMS.prinf();

		RepositorySMS repositorySMS = context.getBean(RepositorySMS.class);
		repositorySMS.prinf();
	}

}
