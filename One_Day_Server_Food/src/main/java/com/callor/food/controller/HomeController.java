package com.callor.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.FoodDTO;
import com.callor.food.service.FoodService;


@WebServlet("/")
public class HomeController extends HttpServlet{
	private FoodService foodService;
	private FoodDTO foodDTO;
	

	public HomeController() {
	// TODO Auto-generated constructor stub
		foodDTO=new FoodDTO();
		
		
}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
		
	}


}
