package jp.co.axiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.form.SelectForm;
import jp.co.axiz.web.service.Impl.UserInfoServiceImpl;

@Controller
public class SelectController {

	@Autowired
	private UserInfoServiceImpl uiServiceImpl;

	@RequestMapping("/select")
	public String login(@ModelAttribute("selectForm") SelectForm form, Model model) {
		return "select";
	}

	@RequestMapping(value = "/list")
	public String list(@Validated @ModelAttribute("selectForm") SelectForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("errmsg", "");
			return "select";

	/*	if (form.getUserId() == null) {
			model.addAttribute("errmsg", "");
			return "select";*/
		}

		UserInfo condition = new UserInfo();
		condition.setUserId(form.getUserId());
		condition.setUserName(form.getName());
		condition.setTelephone(form.getTel());

		List<UserInfo> resultList = uiServiceImpl.find(condition);

		if(resultList.isEmpty()) {
			model.addAttribute("errmsg", "入力されたデータはありませんでした");
			return "select";
		}else {
			model.addAttribute("userlist", resultList);
			return "selectResult";
		}
	}
}
