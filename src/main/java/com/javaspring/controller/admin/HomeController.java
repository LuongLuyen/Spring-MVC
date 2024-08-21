package com.javaspring.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javaspring.dto.UserDTO;
import com.javaspring.service.IUserService;
import com.javaspring.utils.Token;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute("model") UserDTO modelUser,HttpServletRequest request,Model model) {
		ModelAndView mav = new ModelAndView("admin/home");
		modelUser.setListResult(userService.findAll());
		mav.addObject("model", modelUser.getListResult());
		Boolean checkLogin = Token.isLoggedIn(request);
		if (checkLogin) {
			model.addAttribute("checkLogin", "Đã đăng nhập");
		} else {
			model.addAttribute("checkLogin", "Chưa đăng nhập");
		}
		return mav;
	}
}
