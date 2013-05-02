package com.lanux.action.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lanux.action.common.BaseController;
import com.lanux.bll.user.UserBLL;
import com.lanux.pojo.user.User;

@Controller
@RequestMapping({ "/home" })
public class HomeControler extends BaseController {

	@Autowired
	private UserBLL userBLL;

	@RequestMapping(value = { "/add" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public String create(@Validated User user, BindingResult result) {
		if (result.hasErrors()) {
			return "account/createForm";
		}
		return "redirect:/account/" + user.getName();
	}

	@RequestMapping(value = { "/index" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("index");
	}

	@RequestMapping(value = { "/user/{id}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public User get(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = this.userBLL.get(id);
		if (user == null) {
			throw new NullPointerException("user==null");
		}
		return user;
	}

	@RequestMapping(value = { "/create" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public ModelAndView create(@ModelAttribute("user") User user) {
		return new ModelAndView("user/create_success");
	}

	@RequestMapping(value = { "/json" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public List<User> delete(HttpServletRequest request, HttpServletResponse response) {
		return this.userBLL.getAll();
	}
}
