package com.callor.app;

import java.util.ArrayList;
import java.util.List;

import com.callor.app.model.DeckVO;
import com.callor.app.service.PlayerService;

public class BlackJack {

	public static void main(String[] args) {
		List<DeckVO> deckList = new ArrayList<DeckVO>();
		PlayerService pS = new PlayerService(deckList);
		pS.playGame();

	} // end main

}
