package com.callor.app;

import java.util.List;
import java.util.Scanner;

import com.callor.app.model.DeckVO;
import com.callor.app.service.DeckServiceV1;
import com.callor.app.service.PlayerService;

public class GameStart {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		DeckServiceV1 dS = new DeckServiceV1();
		dS.makeDeck();
		List<DeckVO> deckList = dS.getDeck();

		PlayerService 딜러 = new PlayerService(deckList);

		PlayerService 플레이어 = new PlayerService(deckList, "플레이어");

		
		System.out.println("=".repeat(50));
		System.out.println("게임을 시작합니다");

		딜러.hit();
		플레이어.hit();

		딜러.hit();
		플레이어.hit();
		
		System.out.println("-".repeat(50));
		System.out.println("딜러와 플레이어가 두번 뽑았습니다");
		if (딜러.sumValue() < 17) {
			System.out.println("딜러의 점수가 16이하입니다! 한번 더 뽑습니다!!");
			딜러.hit();
		}

		System.out.println("=".repeat(50));
		System.out.println("딜러의 턴이 끝났습니다");
		System.out.println("-".repeat(50));
		System.out.println("딜러의 점수 : " + 딜러.sumValue());
		System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
		if (딜러.sumValue() > 21) {
			System.out.println("딜러 LOSS!!");
			return;
		}
		
		while(true) {
			System.out.println("플레이어가 한장을 더 뽑으시겠습니까? ( YES:1 NO:2 )");
			System.out.print(">> ");
			Integer selectNum = scan.nextInt();
			if (selectNum == 1) {
				플레이어.hit();
				System.out.println();
				System.out.println("딜러의 점수 : " + 딜러.sumValue());
				System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
				
				if (딜러.sumValue() > 플레이어.sumValue()) {
					System.out.println("딜러 Win!!");
					break;
				} else if (플레이어.sumValue() > 21) {
					System.out.println("딜러 Win!!");
					break;
				} else if (플레이어.sumValue() < 21) {
					continue;
				}
			}
			
			if (selectNum == 2) {
				System.out.println();
				System.out.println("딜러의 점수 : " + 딜러.sumValue());
				System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
				if (딜러.sumValue() == 플레이어.sumValue()) {
					System.out.println("딜러와 플레이어의 점수가 같습니다");
					System.out.println("무승부!!!");
				} else if (딜러.sumValue() > 플레이어.sumValue()) {
					System.out.println("딜러 Win!!");
				} else {
					System.out.println("플레이어 Win!!");
				}
			}
			
		} // end while

	} // end main

}
