package com.callor.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.app.model.DeckVO;

// 게임을 할 플레이어를 생성, 점수계산과 카드뽑기를 할 클래스
public class PlayerService {
	// 각 플레이어(딜러포함)가 받은 카드를 저장할 List 선언
	List<DeckVO> myDeckList;

	// deck에서 한장씩 플레이어에게 전달할 카드들, 공용카드덱 선언
	List<DeckVO> pubDeckList;
	String playerName;

	// 플레이어 이름이 없는 상태로 생성자를 만들고 이것을 "딜러"로 사용
	public PlayerService(List<DeckVO> deckList) {
		this(deckList, "딜러");
	}

	// 플레이어로 사용할 경우 String 형태의 매개변수를 추가
	public PlayerService(List<DeckVO> deckList, String playName) {
		// 위에서 선언한 변수들을 생성해줌
		this.myDeckList = new ArrayList<DeckVO>();
		this.pubDeckList = deckList;
		this.playerName = playName;
	}

	// 자신이 받은 카드의 점수의 합을 계산하는 method
	public int sumValue() {
		int sumValue = 0;
		// 받은 카드의 리스트를 vo에 대입할때마다
		for (DeckVO vo : myDeckList) {
			// vo의 getValue() method의 합을 sumValue 변수에 누적
			sumValue += vo.getValue();
		}
		// 누적된 값을 sumValue()를 호출한 곳으로 되돌려줌
		return sumValue;
	}

	// 각 플레이어들이 카드를 더 뽑을때 수행할 method
	public void hit() {
		// 받은카드를 카드 리스트에 추가(내 카드리스트에 pubDeckList의 0번째 카드를 더함)
		myDeckList.add(pubDeckList.get(0));

		// 받을 카드에서 0번째 한장 제외
		pubDeckList.remove(0);

		System.out.println("=".repeat(50));
		System.out.println(playerName);
		System.out.println("-".repeat(50));

		// 현재 보유중인 카드 리스트를 보여주기
		// myDeckList의 값을 반복해서 vo에 담아서 출력
		for (DeckVO vo : myDeckList) {
			System.out.println(vo);
		}
		System.out.println("-".repeat(50));
		// 카드를 뽑을때마다 현재 누적된 점수를 출력
		System.out.println("현재점수 : " + this.sumValue());

	} // end hit

	
	
	
//	// 게임 실행
//	public void playGame() {
//		Scanner scan = new Scanner(System.in);
//		// DeckServiceV1 객체를 생성해서 makeDeck() method 호출
//		DeckServiceV1 dS = new DeckServiceV1();
//		dS.makeDeck();
//		// PlayerService
//		List<DeckVO> deckList = dS.getDeck();
//
//		PlayerService 딜러 = new PlayerService(deckList);
//
//		PlayerService 플레이어 = new PlayerService(deckList, "플레이어");
//
//		System.out.println("=".repeat(50));
//		System.out.println("게임을 시작합니다");
//
//		딜러.hit();
//		플레이어.hit();
//		딜러.hit();
//		플레이어.hit();
//
//		while (딜러.sumValue() < 17) {
//			딜러.hit();
//			continue;
//		}
//		System.out.println("=".repeat(50));
//		System.out.println("딜러의 턴이 끝났습니다");
//		System.out.println("-".repeat(50));
//		System.out.println("딜러의 점수 : " + 딜러.sumValue());
//		System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
//		if (딜러.sumValue() == 21) {
//			System.out.println("BlackJack!!딜러 Win!!");
//			return;
//		} else if (딜러.sumValue() > 21) {
//			System.out.println("딜러 LOSS!!");
//			return;
//		}
//
//		while (true) {
//			System.out.println("-".repeat(50));
//			System.out.println("플레이어가 한장을 더 뽑으시겠습니까? ( YES:1 NO:2 )");
//			System.out.print(">> ");
//			Integer selectNum = scan.nextInt();
//			if (selectNum == 1) {
//				플레이어.hit();
//				System.out.println();
//				System.out.println("딜러의 점수 : " + 딜러.sumValue());
//				System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
//				if (플레이어.sumValue() == 21) {
//					System.out.println("BlackJack!! 플레이어 Win!!");
//					break;
//				} else if (플레이어.sumValue() < 21) {
//					continue;
//				} else if (딜러.sumValue() > 플레이어.sumValue()) {
//					System.out.println("딜러 Win!!");
//					break;
//				} else if (플레이어.sumValue() > 21) {
//					System.out.println("딜러 Win!!");
//					break;
//				}
//			}
//
//			if (selectNum == 2) {
//				System.out.println();
//				System.out.println("딜러의 점수 : " + 딜러.sumValue());
//				System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
//				if (딜러.sumValue() == 플레이어.sumValue()) {
//					System.out.println("딜러와 플레이어의 점수가 같습니다");
//					System.out.println("무승부!!!");
//					break;
//				} else if (딜러.sumValue() > 플레이어.sumValue()) {
//					System.out.println("딜러 Win!!");
//					break;
//				} else {
//					System.out.println("플레이어 Win!!");
//					break;
//				}
//			}
//
//		} // end while
//	} // end playGame

}
