package jp.co.axiz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.service.UpdateService;

@Controller
public class UpdateController {

	private UpdateService updService;

	@RequestMapping("/updateInput")
	public String upd(Model model) {
		//List<Update> list = updService.findAll();
		//model.addAttribute("upd", "aaa");

		return "updateInput";
	}
}


/*	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String update(@ModelAttribute("update") Form,form,Model model) {
		model.addAttribute(form.getId());

		return "updateInput";
	}
*/



