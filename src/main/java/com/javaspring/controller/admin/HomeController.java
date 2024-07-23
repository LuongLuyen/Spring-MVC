package com.javaspring.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javaspring.dto.UserDTO;
import com.javaspring.service.IUserService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/quan-tri", method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute("model") UserDTO model) {
		ModelAndView mav = new ModelAndView("admin/home");
		model.setListResult(userService.findAll());
		mav.addObject("model", model);
		return mav;
	}
}
