package com.callor.app.model;
// 입력된 데이터나 조건을 담을 클래스
public class DeckVO {
	// 덱 생성에 필요한 무늬, 숫자, 점수 선언
	private String suit;
	private String denomination;
	private Integer value = 0;
	
	
	public DeckVO() {
		// TODO Auto-generated constructor stub
	}
	
	// this명령어로 현재 클래스의 멤버변수 지정해서 생성
	public DeckVO(String suit, String denomination, Integer value) {
		super();
		this.suit = suit;
		this.denomination = denomination;
		this.value = value;
	}


	// getter, setter 생성
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	// 생성된 카드 출력에 필요한 toString 작성
	@Override
	public String toString() {
		return " [무늬=" + suit + ", 숫자=" + denomination + ", 점수=" + value + "]";
	}
	
	

}
