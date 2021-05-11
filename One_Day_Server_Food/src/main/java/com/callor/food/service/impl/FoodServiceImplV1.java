package com.callor.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.callor.food.model.FoodDTO;
import com.callor.food.model.FoodVO;
import com.callor.food.service.DBContract;
import com.callor.food.service.FoodService;

public class FoodServiceImplV1 implements FoodService{
	protected Connection dbConn;
	
	public FoodServiceImplV1() {
		// TODO Auto-generated constructor stub
		this.dbConn=DBContract.getDBConnection();
	}

	@Override
	public void insert(FoodVO foodVO) {
		// TODO Auto-generated method stub
		String sql=" INSERT INTO tbl_myfoods ";
		sql+="( mf_seq, mf_date, mf_pcode,mf_take )";
		sql+="VALUES ( seq_myfoods.NEXTVAL, ?, ?, ? )";
		
		System.out.println(sql);
		
		PreparedStatement pStr=null;
		try {
			pStr=dbConn.prepareStatement(sql);
			pStr.setString(1,foodVO.getMf_date());
			pStr.setString(2,foodVO.getMf_pcode());
			pStr.setString(3,foodVO.getMf_take());
			pStr.executeUpdate();
			pStr.close();
			System.out.println("INSERT OK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("INSERT 연동 오류");
		}
	}

	@Override
	public List<FoodDTO> selectAll() {
		// TODO Auto-generated method stub
		String sql=" SELECT *FROM view_식품정보 ";
		return null;
	}

	@Override
	public FoodDTO findByfcode(String fd_fcode) {
		// TODO 식품코드로 정보 조회
		String sql=" SELECT *FROM view_식품정보 ";
		sql=" WHERE FD_FCODE EQUAL '&'||?||'&' ";
		PreparedStatement pStr=null;
		
		try {
			pStr=dbConn.prepareStatement(sql);
			pStr.setString(1, fd_fcode.trim());
			ResultSet result=pStr.executeQuery();
			if(result.next()) {
				FoodDTO foodDTO = new FoodDTO();
				foodDTO.setFd_fcode(result.getString("식품코드"));
				foodDTO.setFd_fname(result.getString("식품명"));
				foodDTO.setFd_serve(result.getString("1회제공량"));
				foodDTO.setFd_gram(result.getString("총내용량"));
				foodDTO.setFd_kcal(result.getString("칼로리"));
				foodDTO.setFd_protein(result.getString("단백질"));
				foodDTO.setFd_fat(result.getString("지방"));
				foodDTO.setFd_crbhy(result.getString("탄수화물"));
				foodDTO.setFd_sugars(result.getString("당류"));
				foodDTO.setMf_date(result.getString("날짜"));
				foodDTO.setMf_pcode(result.getString("식품코드"));
				foodDTO.setMf_take(result.getString("섭취량"));
				return foodDTO;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(FoodVO foodVO) {
		// TODO Auto-generated method stub
		
	}
	

}
