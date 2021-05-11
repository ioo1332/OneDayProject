package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.FoodDTO;
import com.callor.food.model.FoodVO;
import com.callor.food.service.FoodService;
import com.callor.food.service.impl.FoodServiceImplV1;

@WebServlet("/food/*")
public class FoodController extends HttpServlet {
	private FoodDTO foodDTO;
	private FoodVO foodVO;
	private FoodService fservice;
	
	public FoodController() {
		// TODO Auto-generated constructor stub
		fservice=new FoodServiceImplV1();
				
		
	}
	private static final long serialVersionUID = 7528534125211741994L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String subPath = req.getPathInfo();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/input")) {
			String mf_date=req.getParameter("mf_date");
			String mf_pcode=req.getParameter("mf_pcode");
			String mf_take=req.getParameter("mf_take");
			
			FoodVO foodVO=new FoodVO();
			foodVO.setMf_date(mf_date);
			foodVO.setMf_pcode(mf_pcode);
			foodVO.setMf_take(mf_take);
			fservice.insert(foodVO);
			
			out.printf("mf_date",mf_date);
			out.printf("mf_pcode",mf_pcode);
			out.printf("mf_take",mf_take);
			out.close();
		}else if (subPath.equals("/select")) {
			List<FoodDTO>foodList=fservice.selectAll();
		}else if (subPath.endsWith("/pcode")) {
			String mf_pcode=req.getParameter("mf_code");
			FoodDTO foodDTO=fservice.findByfcode(mf_pcode);
			ServletContext app=this.getServletContext();
			app.setAttribute("food", foodDTO);
			RequestDispatcher disp=app.getRequestDispatcher("/WEB-INF/views/home.jsp");
			disp.forward(req, resp);			
		}else {
			out.println("반갑습니다");
			out.close();
		}
		

	}

}
