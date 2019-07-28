package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.login.dao.loginDao;


@Controller
@SessionAttributes("username")

public class Login{

	@RequestMapping(value="/Login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam ("uname") String name, @RequestParam("pass") String pass) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		
		loginDao dao = new loginDao();
		ModelAndView mv =new ModelAndView();
			
			
			
				if(dao.check(name, pass)) {
					
					mv.addObject("username", name);
					mv.setViewName("redirect:/Product");
					return mv;
				}
				else {
					mv.setViewName("login.jsp");
					return mv;
				}
			
		
	}
		
		
		
	}


	

