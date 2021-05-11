package com.callor.app.service;

import java.util.List;
import java.util.Scanner;

import com.callor.app.model.DeckVO;
// 게임을 실행하고 승패를 판단하는 클래스
public class PlayGameService {

	// 실제 게임 실행
	public void playGame() {
		Scanner scan = new Scanner(System.in);
		// DeckServiceV1 객체를 생성해서 덱을 만드는 makeDeck() method 호출
		DeckServiceV1 dS = new DeckServiceV1();
		dS.makeDeck();
		// getDeck() method를 호출해서 리스트를 생성함 
		List<DeckVO> deckList = dS.getDeck();
		// deckList 타입만 사용하는 딜러 생성
		PlayerService 딜러 = new PlayerService(deckList);
		// deckList와 문자열을 사용하는 플레이어 생성
		PlayerService 플레이어 = new PlayerService(deckList, "플레이어");

		System.out.println("=".repeat(50));
		System.out.println("게임을 시작합니다");

		// 딜러와 플레이어가 번갈아서 hit를 해서 카드를 각각 2장씩 가지고,
		딜러.hit();
		플레이어.hit();
		딜러.hit();
		플레이어.hit();
		// 딜러가 가진 카드의 점수가 16점 이하면 무조건 딜러는 계속해서 카드를 더 뽑음
		while (딜러.sumValue() < 17) {
			딜러.hit();
			continue;
		}
		// 딜러의 턴이 끝나면 딜러의 점수와 플레이어의 점수를 보여주고
		// 딜러가 21이 되거나, 21을 넘는지를 먼저 판별해서 승패를 결정
		System.out.println("=".repeat(50));
		System.out.println("딜러의 턴이 끝났습니다");
		System.out.println("-".repeat(50));
		System.out.println("딜러의 점수 : " + 딜러.sumValue());
		System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
		if (딜러.sumValue() == 21) {
			System.out.println("BlackJack!!딜러 Win!!");
			return;
		} else if (딜러.sumValue() > 21) {
			System.out.println("딜러 LOSS!!");
			return;
		}
		// 거기에 해당이 되지 않는다면 이제 플레이어가 카드를 더 뽑을지 판단
		while (true) {
			System.out.println("-".repeat(50));
			System.out.println("플레이어가 한장을 더 뽑으시겠습니까? ( YES:1 NO:2 )");
			System.out.print(">> ");
			Integer selectNum = scan.nextInt();
			// 플레이어가 카드를 더 뽑는다면 각각 상황별 점수를 판단하여 승패를 결정
			// 21점이 되지 않는다면 플레이어는 카드를 계속해서 더 뽑을 수 있음
			if (selectNum == 1) {
				플레이어.hit();
				System.out.println();
				System.out.println("딜러의 점수 : " + 딜러.sumValue());
				System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
				if (플레이어.sumValue() == 21) {
					System.out.println("BlackJack!! 플레이어 Win!!");
					break;
				} else if (플레이어.sumValue() < 21) {
					continue;
				} else if (딜러.sumValue() > 플레이어.sumValue()) {
					System.out.println("딜러 Win!!");
					break;
				} else if (플레이어.sumValue() > 21) {
					System.out.println("딜러 Win!!");
					break;
				}
			}
			// 플레이어가 카드를 그만뽑겠다고 판단했을때 위와 같이 상황별로 판단
			if (selectNum == 2) {
				System.out.println();
				System.out.println("딜러의 점수 : " + 딜러.sumValue());
				System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
				if (딜러.sumValue() == 플레이어.sumValue()) {
					System.out.println("딜러와 플레이어의 점수가 같습니다");
					System.out.println("무승부!!!");
					break;
				} else if (딜러.sumValue() > 플레이어.sumValue()) {
					System.out.println("딜러 Win!!");
					break;
				} else {
					System.out.println("플레이어 Win!!");
					break;
				}
			}

		} // end while
	} // end playGame

}
