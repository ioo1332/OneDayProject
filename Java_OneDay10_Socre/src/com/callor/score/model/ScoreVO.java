package com.callor.score.model;

public class ScoreVO {

	private String sname;
	private Integer kor;
	private Integer eng;
	private Integer math;
	private Integer sci;
	private Integer	his;
	private Integer sum;
	private Float floatAvg;
	
	
	
	
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getKor() {
		return kor;
	}
	public void setKor(Integer kor) {
		this.kor = kor;
	}
	public Integer getEng() {
		return eng;
	}
	public void setEng(Integer eng) {
		this.eng = eng;
	}
	public Integer getMath() {
		return math;
	}
	public void setMath(Integer math) {
		this.math = math;
	}
	public Integer getSci() {
		return sci;
	}
	public void setSci(Integer sci) {
		this.sci = sci;
	}
	public Integer getHis() {
		return his;
	}
	public void setHis(Integer his) {
		this.his = his;
	}
	public Integer sum() {
		return sum=kor+eng+math+sci+his;
	}
	public void sum(Integer sum) {
		this.sum = sum;
	}
	public Float floatAvg() {
		return (float) (sum/5);
	}
	public void setFloatAvg(Float floatAvg) {
		this.floatAvg = floatAvg;
	}
	
	
}
