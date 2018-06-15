package jp.co.axiz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Session;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.form.UpdateForm;
import jp.co.axiz.web.service.UserInfoService;
import jp.co.axiz.web.service.Impl.UserInfoServiceImpl;

@Controller
public class UpdateController {

	@Autowired
	private Session session;

	@Autowired
	private UserInfoServiceImpl uiServiceImpl;

	@Autowired
	private UserInfoService uiService;

	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@ModelAttribute("updateForm") UpdateForm form,Model model) {
		return "update";
	}

	@RequestMapping(value="/updateInput", method=RequestMethod.POST)
	public String updateInput(@ModelAttribute("updateForm") UpdateForm form,Model model) {

		//model.addAttribute("updId",form.getUpdId());
		//String updId = form.getUpdId();

		if(form.getUserId() == null /*|| form.getUserId().equals("")*/) {
			model.addAttribute("errmsg","必須項目を入力してください");
			return "update";
		}

		//List<Update> updList = updDao.findAll();
		UserInfo user = uiService.findById(form.getUserId());

		/*for(Update update : updList) {
			 if(!(updId.equals(update.getId()))) {
				model.addAttribute("errmsg","入力されたデータは存在しません");
				return "update";
			}*/

		if(user==null) {
			model.addAttribute("errmsg","入力されたデータは存在しません");
			return "update";
		}

		session.setPrevUser(user);

		form.setNewName(user.getUserName());
		form.setNewTel(user.getTelephone());
		form.setNewPassword(user.getPassword());

		//model.addAttribute("afterUser",afterUser);
		return "updateInput";
	}

	@RequestMapping(value="/updateConfirm",method=RequestMethod.POST)
	public String updateConfirm(@ModelAttribute("updateForm") UpdateForm form,Model model) {


		/*
		if( 1項目も変更されてなかったら ) {
			model.addAttribute("errmsg","1項目以上変更してください");
			return "updateInput";

		} else {*/

		if (form.hasError()) {
			model.addAttribute("errmsg", "1項目以上変更してください");
			return "updateInput";
		}

		UserInfo beforeUser = session.getPrevUser();

		UserInfo afterUser = new UserInfo();
		afterUser.setUserId(beforeUser.getUserId());
		afterUser.setUserName(form.getNewName());
		afterUser.setTelephone(form.getNewTel());
		afterUser.setPassword(form.getNewPassword());

		if(afterUser.equals(beforeUser)) {
			model.addAttribute("errmsg", "1項目以上変更してください");
			return "updateInput";
		}

		session.setAfterUser(afterUser);

		form.setPrevName(beforeUser.getUserName());
		form.setPrevTel(beforeUser.getTelephone());
		form.setPrevPassword(beforeUser.getPassword());

		if(beforeUser.getPassword().equals(afterUser.getPassword())) {
			form.setConfirmNewPassword(afterUser.getPassword());
		}

		return "updateConfirm";
	}

	@RequestMapping(value = "/updateInputBack")
	public String updateInputBack(@ModelAttribute("updateForm") UpdateForm form, Model model) {

		UserInfo afterUser = session.getAfterUser();

		form.setUserId(afterUser.getUserId());
		form.setNewName(afterUser.getUserName());
		form.setNewTel(afterUser.getTelephone());
		form.setNewPassword(afterUser.getPassword());

		return "updateInput";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String success(@ModelAttribute("updateForm") UpdateForm form,BindingResult bindingResult, Model model) {

		/*if( pass不一致 ) {
				model.addAttribute("errmsg","前画面で入力されたパスワードと一致しません");
				return "updateConfirm";

			} else {

				// 元のupdateメソッドはstmtとか?とか使うやつ
				updDao.update(afterUser);

				model.addAttribute("updId", afterUser.getId());*/


		UserInfo afterUser = session.getAfterUser();

		if(!afterUser.getPassword().equals(form.getConfirmNewPassword())) {
			model.addAttribute("errmsg", "前画面で入力されたパスワードと一致しません");

			form.setConfirmNewPassword("");

			UserInfo beforeUser = session.getPrevUser();
			form.setPrevName(beforeUser.getUserName());
			form.setPrevTel(beforeUser.getTelephone());
			form.setPrevPassword(beforeUser.getPassword());

			return "updateConfirm";
		}

		uiServiceImpl.update(afterUser);

		session.setAfterUser(null);
		session.setPrevUser(null);

		model.addAttribute("user", session.getLoginUser());

		return "updateResult";
	}
}

