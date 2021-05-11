package com.callor.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodVO {
	

	private String fd_fcode;	
	private String fd_fname	;
	private String fd_year; 
	private String fd_ccode;
	private String cp_cname;
	private String fd_code;
	private String i_name; 
	private String fd_serve;
	private String fd_gram;	
	private String fd_kcal;	
	private String fd_protein;
	private String fd_fat;	
	private String fd_crbhy; 
	private String fd_sugars;
	private String mf_seq;	     
	private String mf_date;		
	private String mf_pcode;	
	private String mf_take;	

}
