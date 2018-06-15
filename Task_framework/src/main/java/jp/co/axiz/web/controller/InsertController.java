package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Session;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.form.InsertForm;
import jp.co.axiz.web.service.Impl.UserInfoServiceImpl;

@Controller
public class InsertController {

	@Autowired
	private Session session;

	@Autowired
	private UserInfoServiceImpl uiServiceImpl;

	@RequestMapping("/insert")
	public String insert(@ModelAttribute("insertForm") InsertForm form, Model model) {
		return "insert";
	}

	@RequestMapping(value = "/insertConfirm", method = RequestMethod.POST)
	public String insertConfirm(@ModelAttribute("insertForm") InsertForm form,Model model) {

		if (form.getUserId() == null) {
			model.addAttribute("errmsg", "");
			return "insert";
		}

		UserInfo user = new UserInfo();
		user.setUserName(form.getName());
		user.setTelephone(form.getTel());
		user.setPassword(form.getPassword());

		session.setNewUser(user);

		return "insertConfirm";
	}

	@RequestMapping(value = "/insertBack" , method = RequestMethod.GET)
	public String insertBack(@ModelAttribute("insertForm") InsertForm form, Model model) {

		UserInfo user = session.getNewUser();

		form.setName(user.getUserName());
		form.setTel(user.getTelephone());
		form.setPassword(user.getPassword());

		return "insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertExecute(@ModelAttribute("insertForm") InsertForm form, Model model) {

		UserInfo user = session.getNewUser();

		if(!user.getPassword().equals(form.getConfirmPassword())) {
			model.addAttribute("errmsg", "前画面で入力したパスワードと一致しません");

			form.setConfirmPassword("");

			return "insertConfirm";
		}

		int id = uiServiceImpl.insert(user);

		session.setNewUser(null);

		form.setUserId(id);

		model.addAttribute("user", session.getLoginUser());

		return "insertResult";
	}
}
