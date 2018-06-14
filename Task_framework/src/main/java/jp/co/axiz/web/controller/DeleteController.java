package jp.co.axiz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.entity.Delete;
import jp.co.axiz.web.service.DeleteService;

@Controller
public class DeleteController {

	@Autowired
	private DeleteService delService;

	@RequestMapping("/deleteConfirm")
	public String list(Model model) {
		List<Delete> list = delService.findAll();
		model.addAttribute("delLlist", list);

		return "list";
	}

}
