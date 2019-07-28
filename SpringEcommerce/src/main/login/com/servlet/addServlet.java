package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.cartDao;
import com.config.addConfig;
import com.product.dao.productDao;


@Controller
@SessionAttributes
public class addServlet  {

	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@RequestMapping(value="addServlet",method = RequestMethod.POST)
	public ModelAndView addServe(
			@RequestParam("productid") int id, 
			@RequestParam("productname") String name,
			@RequestParam("productprice") Double price,
			@RequestParam("productquantity") int quantity ,
			HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
					ApplicationContext context = new AnnotationConfigApplicationContext(addConfig.class);
					
					cartDao cd = context.getBean(cartDao.class);
					
					ModelAndView mv = new ModelAndView();
					
					String username = (String) request.getSession().getAttribute("username");
					cd.addCart(username, id,name,price,quantity);
					mv.setViewName("Product");
					return mv;
			}

}
