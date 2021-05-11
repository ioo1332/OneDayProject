package com.callor.app;

import java.util.ArrayList;
import java.util.List;

import com.callor.app.model.DeckVO;
import com.callor.app.service.PlayGameService;
import com.callor.app.service.PlayerService;

// 블랙잭 게임을 시작할 메인 클래스
public class BlackJack {

	public static void main(String[] args) {
//		List<DeckVO> deckList = new ArrayList<DeckVO>();
//		PlayerService pS = new PlayerService(deckList);
		
		// PlayGameService 객체를 생성해서 playGame() method 실행
		PlayGameService pGs = new PlayGameService();
		pGs.playGame();

	} // end main

}
