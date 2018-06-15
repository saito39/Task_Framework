package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.service.LoginService;

@Controller
public class AuthController {

	@Autowired
	private LoginService lgService;

	@RequestMapping("/login")
	public String login(Model model) {
	return "menu";
	}

}
