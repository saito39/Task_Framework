package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.entity.Session;
import jp.co.axiz.web.form.LoginForm;
import jp.co.axiz.web.service.LoginService;

@Controller
public class AuthController {

	@Autowired
	private LoginService lgService;

	@Autowired
	private Session session;

	@RequestMapping("/login")
	public String loginFalse(@ModelAttribute("loginForm") LoginForm form, Model model) {
	return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginExecute(@ModelAttribute("loginForm") LoginForm form, Model model) {

		if (form.getLoginId() == null) {
			model.addAttribute("errmsg", "IDまたはPASSが間違っています");
			return "login";
		}

		Login login = lgService.authentication(form.getLoginId(), form.getPassword());

		if (login == null) {
			model.addAttribute("errmsg", "IDまたはPASSが間違っています");
			return "login";
		} else {
			session.setLoginUser(login);
			model.addAttribute("user", session.getLoginUser());
			return "menu";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model) {
		session.invalidate();
		return "logout";
	}
}
