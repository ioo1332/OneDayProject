package com.callor.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.callor.app.model.DeckVO;

public class DeckServiceV1 {
	
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
	
	public List<DeckVO> getDeck(){
		for(DeckVO vo : deckList) {
			Collections.shuffle(this.deckList);
		}
		return this.deckList;
	}
	
	public DeckServiceV1() {
		// TODO Auto-generated constructor stub
		deckList = new ArrayList<DeckVO>();
	}
	
	public void makeDeck() {
		
		String[] denoms = strDenomi.split("");
		String[] suits = strSuit.split(":");
		
		// 4번 반복
		for(String suit : suits) {
			for(String denom : denoms) {
				
				Integer intValue = 0;
				try {
					intValue = Integer.valueOf(denom);
					if (intValue == 0) intValue = 10;
				} catch (NumberFormatException e) {
					// denom 문자열이 A,K,Q,J인 경우 Exception 발생, 이걸 이용
					if (denom.equals("A")) intValue = 1;
					else intValue = 10;
				}
				DeckVO deckVO = new DeckVO();
				deckVO.setSuit(suit);
				deckVO.setDenomination(denom);
				deckVO.setValue(intValue);
				deckList.add(deckVO);
				
//				System.out.println(deckVO.toString());
			}
		}
		
	}
	
	

}





