package jp.co.axiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.Update;
import jp.co.axiz.web.form.UpdateForm;

@Controller
public class UpdateController {

	@Autowired
	private UserInfoDao updDao;
	private Update afterUser;

	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@ModelAttribute("updateForm") UpdateForm form,Model model) {
		return "update";
	}

	@RequestMapping(value="/updateInput", method=RequestMethod.POST)
	public String updateInput(@ModelAttribute("updateForm") UpdateForm form,Model model) {
		model.addAttribute("updId",form.getUpdId());

		String updId = form.getUpdId();

		if(updId == null || updId.isEmpty()) {
			model.addAttribute("errmsg","必須項目を入力してください");
			return "update";
		}

		List<Update> updList = updDao.findAll();

		for(Update update : updList) {
			 if(!(updId.equals(update.getId()))) {
				model.addAttribute("errmsg","入力されたデータは存在しません");
				return "update";
			}

			afterUser.setId(update.getId());
			afterUser.setName(update.getName());
			afterUser.setTelephone(update.getTelephone());
			afterUser.setPassword(update.getPassword());

			model.addAttribute("afterUser",afterUser);
		}
		return "updateInput";
	}

	@RequestMapping(value="/updateConfirm",method=RequestMethod.POST)
	public String updateConfirm(@ModelAttribute("updateForm") UpdateForm form,Model model) {
/*
		if( 1項目も変更されてなかったら ) {
			model.addAttribute("errmsg","1項目以上変更してください");
			return "updateInput";

		} else {*/
			return "updateConfirm";
		}
	//}

		@RequestMapping(value="/update",method=RequestMethod.POST)
		public String success(@ModelAttribute("updateForm") UpdateForm form,Model model) {

			/*if( pass不一致 ) {
				model.addAttribute("errmsg","前画面で入力されたパスワードと一致しません");
				return "updateConfirm";

			} else {

				// 元のupdateメソッドはstmtとか?とか使うやつ
				updDao.update(afterUser);

				model.addAttribute("updId", afterUser.getId());*/

				return "updateResut";
			}
		}
		//}
