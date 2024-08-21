package com.javaspring.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaspring.dto.UserDTO;
import com.javaspring.service.IUserService;
import com.javaspring.utils.Session;
import com.javaspring.utils.Token;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model, HttpServletRequest request) {
		Boolean checkLogin = Token.isLoggedIn(request);
		if (checkLogin) {
			model.addAttribute("checkLogin", "Đã đăng nhập");
			return "web/home";
		} else {
			return "error/notlogin";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage( HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/login");
		return mav;
	}
	@RequestMapping(value = "/notlogin", method = RequestMethod.GET)
	public ModelAndView notLogin( HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("error/notlogin");
		return mav;
	}
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public ModelAndView role( HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("error/role");
		return mav;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout( HttpServletRequest request) {
		Session.invalidateSession(request);
		return "redirect:/login";
	}
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		try {
			UserDTO userDB = new UserDTO();
			userDB = userService.login(username,password);
			if (userDB.getUserName().equals(username) && userDB.getPassword().equals(password)) {
				String genericToken = userDB.getId() + Token.getToken() + password;
				// Model add views data
				model.addAttribute("username", username);
				model.addAttribute("password", password);
				// set session
				Session.setAttribute(request, "token", genericToken);
				// get session
//			    String token = (String) Session.getAttribute(request, "token");
//			    request.setAttribute("token", token);
				// huy session
//			    Session.invalidateSession(request);
				Boolean checkLogin = Token.isLoggedIn(request);
				if (checkLogin) {
					model.addAttribute("checkLogin", "Đã đăng nhập");
				} else {
					return "redirect:/login";
				}
				return "web/home";// home.jsp
			} else {
				return "web/login";
			}
		}catch (Exception e){
			return "error/error";//error.jsp
		}
		
	}
}
