package jp.co.axiz.web;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;

@SpringBootApplication
public class TaskFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con =
		SpringApplication.run(TaskFrameworkApplication.class, args);

		LoginDao lgDao = con.getBean(LoginDao.class);
		List<Login> list = lgDao.findAll();
		for(Login l : list) {

		}
	}
}
