package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cart.dao.cartpDao;
import com.cart.dao.checkoutDao;
import com.cart.model.cartModel;

@Controller
public class checkout extends HttpServlet {

	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	@RequestMapping(value = "checkout",method = RequestMethod.POST)
	public ModelAndView checkingout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String username = (String) request.getSession().getAttribute("username");
		checkoutDao cd = new checkoutDao();
		ModelAndView mv =new ModelAndView();
		String msg = cd.checkout(username);
		if(msg.equals("Sorry")) {
			mv.addObject("insufficient", "Sorry item you selected is in less quantity");
			mv.setViewName("cart.jsp");
			
		}
		else {
		cartpDao cr = new cartpDao();
		List<cartModel> cm = cr.getProduct(username);
		mv.addObject("cart", cm);
		mv.setViewName("cart.jsp");
		return mv;
		}	
		return mv;
	}
}
