package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.axiz.web.service.LoginService;

@Controller
public class AuthController {

	@Autowired
	private LoginService lgService;

/*	@RequestMapping("/menu")
	public String list(Model model) {
		List<Login> list = loginService.findAll();
		model.addAttribute("loginlist", list);

		return "list";*/
	}

//}
