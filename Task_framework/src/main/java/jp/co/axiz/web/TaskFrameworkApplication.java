package jp.co.axiz.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskFrameworkApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext con =
		SpringApplication.run(TaskFrameworkApplication.class, args);
/*
		LoginDao lgDao = con.getBean(LoginDao.class);
		List<Login> list = lgDao.findAll();
		for(Login l : list) {

		}*/
	}
}
