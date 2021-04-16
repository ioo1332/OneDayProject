package com.callor.word.service.model;

public class WordVO {
	
	private String eng;
	private String kor;
	private Integer count;
	
	private Integer nWinCount;
	private Integer nLossCount;
	
	public Integer getnLossCount() {
		return nLossCount;
	}
	public Integer getnWinCount() {
		return nWinCount;
	}
	public void setnWinCount(Integer nWinCount) {
		this.nWinCount = nWinCount;
	}
	public void setnLossCount(Integer nLossCount) {
		this.nLossCount = nLossCount;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public Integer getCount() {
		return count;
	}
	public void setcount(Integer count) {
		this.count=count;
	}
	@Override
	public String toString() {
		return "WordVO [영어=" + eng + ", 한글=" + kor + "]";
	}
	
	
	

	
	
}
