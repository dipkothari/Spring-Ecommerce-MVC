package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.cartpDao;
import com.cart.dao.removeCart;
import com.cart.model.cartModel;

@Controller
public class delete{
	

	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	public ModelAndView del(@RequestParam("productid") int id ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String username = (String) request.getSession().getAttribute("username");
		removeCart cd = new removeCart();
		cd.remCart(username,id);
		cartpDao cd1 = new cartpDao();
		List<cartModel> cm = cd1.getProduct(username);
	
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("cart", cm);
		
		mv.setViewName("cart.jsp");
		
		return mv;

	}
}
