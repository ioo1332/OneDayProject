package com.callor.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.callor.app.model.DeckVO;
// 사용할 카드덱을 생성하는 클래스
public class DeckServiceV1 {
	// 덱리스트, 무늬, 숫자
	protected List<DeckVO> deckList;
	String strSuit = "다이아몬드(◆):하트(♡):스페이드(♠):클로버(♣)";
	String strDenomi = "A234567890KQJ";
	
//	public DeckVO getDeck() {
//		Random rnd = new Random();
//		int nSize = deckList.size();
//		int deckIndex = rnd.nextInt(nSize);
//		
//		DeckVO retDeckVO = deckList.get(deckIndex);
//		deckList.remove(deckIndex);
//		return retDeckVO;
//	}
	// DeckVO 타입의 List getDeck
	public List<DeckVO> getDeck(){
		for(DeckVO vo : deckList) {
			// deckList의 내용을 랜덤형태로 보여줌
			Collections.shuffle(this.deckList);
		}
		return this.deckList;
	}
	
	public DeckServiceV1() {
		// DeckVO 타입의 ArrayList(객체들이 추가되어 자동으로 용량이 추가됨) 생성
		deckList = new ArrayList<DeckVO>();
	}
	
	// makeDeck() method에서 카드 생성
	public void makeDeck() {
		// A234567890KQJ 문자열을 문자별로 쪼갠후 denoms 배열에 담음
		// 다이아몬드(◆):하트(♡):스페이드(♠):클로버(♣) 문자열을 : 을 기준으로 suit에 담음
		String[] denoms = strDenomi.split("");
		String[] suits = strSuit.split(":");
		
		// 무늬 suits를 suit 변수에 한번 담을때마다 문자열 A234567890KQJ 반복
		for(String suit : suits) {
			for(String denom : denoms) {
				// 예외처리문을 사용해서 2~9 까지의 값은 그대로 점수 생성
				// 숫자가 0이면 10점
				Integer intValue = 0;
				try {
					intValue = Integer.valueOf(denom);
					if (intValue == 0) intValue = 10;
				} catch (NumberFormatException e) {
					// denom 문자열이 A,K,Q,J인 경우 Exception 발생, 이걸 이용
					// A면 값이 1, 나머지 경우의 수 K,Q,J는 10으로 지정
					if (denom.equals("A")) intValue = 1;
					else intValue = 10;
				}
				// 생성이 끝나면 그 값을 각자 deckVO에 셋팅해주고 리스트에 추가
				DeckVO deckVO = new DeckVO();
				deckVO.setSuit(suit);
				deckVO.setDenomination(denom);
				deckVO.setValue(intValue);
				deckList.add(deckVO);
			}
		}
	} // end makeDeck
	
	

}





