package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.product.dao.productDao;
import com.product.model.productModel;

@Controller
class Product  {
	
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	@RequestMapping(value="/Product")
	public ModelAndView product(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		request.getSession().getAttribute("username");
		productDao pd = new productDao();
		
		List<productModel> pm = pd.getProduct();
		mv.addObject("product", pm);
		mv.setViewName("product.jsp");
		return mv;
	}

	

}
