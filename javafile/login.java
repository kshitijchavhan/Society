package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.LoginDao;
import com.entity.User;

@Controller
public class Login {
	@Autowired(required = true)
	User user;

	@RequestMapping("login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("accounttype") String accounttype) {
		username = username.trim();
		password = password.trim();
		this.user.setUsername(username);
		this.user.setPassword(password);
		this.user.setAccounttype(accounttype);
		boolean b = LoginDao.isvalid(user);
		if (accounttype.equals("admin") && b)
			return "admin";
		else if (b)
			return "member";
		else
         return "index";
	}

	@RequestMapping("register")
	public String registrMember(@RequestParam("username") String username, @RequestParam("fullname") String full_name,
			@RequestParam("mobile_number") Long mobile_number, @RequestParam("emailid") String emailid,
			@RequestParam("password") String password) {
		User user = new User(emailid, emailid, username, password, mobile_number);

		boolean status = LoginDao.save(user);
		return "index";
	}

}
