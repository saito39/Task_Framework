package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.form.UpdateForm;

@Controller
public class UpdateController {

	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Model model) {
		return "update";
	}

	@RequestMapping(value="/updateInput", method=RequestMethod.POST)
	public String updateInput(Model model,@ModelAttribute("updateForm") UpdateForm updateForm) {
		model.addAttribute("updId",updateForm.getUpdId());

		//String updId = updateForm.getUpdId();
		//UpdateDao updDao = new UpdateDao();
		//UserInfo userInfo = new userInfoDao.

		/*@Autowired
		private UpdateDao updDao;*/

		//List<Update> updList = UpdateDao.findAll();

		/*for(Update update : updList) {
			if(updId == null || updId.isEmpty()) {
				model.addAttribute("errmsg","必須項目を入力してください");
				return "update";

			} else if(!(updId.equals(update.getId()))) {
				model.addAttribute("errmsg","入力されたデータは存在しません");
				return "update";

			} else {

				UserInfo afterUser = new UserInfo();
				afterUser.setId(update.getId());
				afterUser.setName(update.getName());
				afterUser.setTelephone(update.getTelephone());
				afterUser.setPassword(update.getPassword());

				//model.addAttribute("beforeUser",userInfo.);
				model.addAttribute("afterUser",afterUser);*/
				return "updateInput";
			}
		//}
	//}
	@RequestMapping(value="/updateConfirm",method=RequestMethod.POST)
	public String updateConfirm(Model model,@ModelAttribute("updateForm") UpdateForm updateForm) {

		/*if( 1項目も変更されてなかったら ) {
			model.addAttribute("errmsg","1項目以上変更してください");
			return "updateInput";
		} else {*/
	return "updateConfirm";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String success(Model model,@ModelAttribute("updateForm") UpdateForm updateForm) {

		/*if( pass不一致 ) {
			model.addAttribute("errmsg","全画面で入力されたパスワードと一致しません");
			return "updateInput";
		} else {*/
			return "updateResut";
		}
	}
//}
