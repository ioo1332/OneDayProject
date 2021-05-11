package com.callor.food.service;

import java.util.List;

import com.callor.food.model.FoodDTO;
import com.callor.food.model.FoodVO;

public interface FoodService {
	
	public void insert(FoodVO foodVO);
	public List<FoodDTO> selectAll();
	public FoodDTO findByfcode(String fd_code);
	public void update(FoodVO foodVO);
	
	
	
	
	

}
