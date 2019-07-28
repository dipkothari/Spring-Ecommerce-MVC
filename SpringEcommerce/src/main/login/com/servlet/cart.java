package com.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.cartDao;
import com.cart.dao.cartpDao;
import com.cart.model.cartModel;
import com.config.addConfig;

@Controller
public class cart extends HttpServlet {
	
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@RequestMapping(value="cart",method = RequestMethod.POST)
		public ModelAndView cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		
		String username= (String)request.getSession().getAttribute("username");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(addConfig.class);
		
		cartpDao cd = context.getBean(cartpDao.class);
		
		ModelAndView mv = new ModelAndView();
		List<cartModel> cm = cd.getProduct(username);
	
		
		
		mv.addObject("cart", cm);
		
		mv.setViewName("cart.jsp");
		
		return mv;
	}


}
