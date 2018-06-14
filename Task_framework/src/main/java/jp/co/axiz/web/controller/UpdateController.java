package jp.co.axiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.web.entity.Update;
import jp.co.axiz.web.form.UpdateForm;
import jp.co.axiz.web.service.UpdateService;

@Controller
public class UpdateController {

	@RequestMapping(value="/updateConfirm", method=RequestMethod.POST)
	public String update(Model model,@ModelAttribute("updateForm") UpdateForm updateForm) {
		model.addAttribute("updId",updateForm.getUpdId());

		//return "updateConfirm";
	//}

	List<Update> updList = UpdateService.findAll();
	for(Update update : updList) {
		if(update.getId().equals(updateForm.getUpdId()));
		return "updateConfirm";
	} else {
		return "updateInput";
	}
}
