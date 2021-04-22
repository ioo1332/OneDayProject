package com.callor.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.app.model.DeckVO;
import com.callor.app.service.DeckServiceV1;
import com.callor.app.service.PlayerService;

public class BlackjackImpl implements GameInterface {
	protected Scanner scan;
	protected DeckServiceV1 ds;
	protected List<DeckVO> deckList;
	protected String playerName;
	protected List<DeckVO> myDeckList;
	protected List<DeckVO> pubDeckList;

	public BlackjackImpl() {
		// TODO Auto-generated constructor stub
		scan = new Scanner(System.in);
		ds = new DeckServiceV1();
		deckList = new ArrayList<DeckVO>();
		myDeckList = new ArrayList<DeckVO>();
		pubDeckList = new ArrayList<DeckVO>();
		//List<DeckVO> deckList = dS.getDeck();
		
	}
	public int sumValue() {
		// 받은 카드의 리스트를 vo에 대입할때마다
		int sumValue = 0;
		for(DeckVO vo : myDeckList) {
			 // vo의 getValue() method의 합을 sumValue 변수에 누적 
			sumValue += vo.getValue();
		}
		return sumValue;
	}
	public void PlayerService(List<DeckVO> deckList, String playName) {
		this.myDeckList = new ArrayList<DeckVO>();
		this.pubDeckList = deckList;
		this.playerName = playName;
	}
	public void hit() {
		// playerName이 "딜러" 이고 점수계산의 합이 16점이 넘으면,
		System.out.println("=".repeat(50));
		System.out.println("각각 카드를 돌립니다");
		if (this.playerName.equals("딜러") && this.sumValue() > 16) {
			System.out.println("딜러점수 : " + this.sumValue());
			System.out.println("딜러 Hit 금지!!");
		} else {
			// 아니면 받은카드를 카드 리스트에 추가(내 카드리스트에 pubDeckList의 0번째 카드를 더함)
			myDeckList.add(pubDeckList.get(0));
			
			// 받을 카드에서 0번째 한장 제외
			pubDeckList.remove(0);
		}
		
		System.out.println("=".repeat(50));
		System.out.println(playerName);
		System.out.println("-".repeat(50));
		
		// 현재 보유중인 카드 리스트를 보여주기
		for(DeckVO vo : myDeckList) {
			System.out.println(vo);
		}
		System.out.println("-".repeat(50));
		System.out.println("현재점수 : " + this.sumValue());
		
	}
	@Override
	public void selectMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("=".repeat(50));
			System.out.println("1. 게임시작");
			System.out.println("QUIT. 게임종료");
			System.out.println("-".repeat(50));
			System.out.print("입력 >>");
			String strInput = scan.nextLine();
			if (strInput.equals("QUIT")) {
				System.out.println("게임을 종료하셨습니다");
				break;
			} else if (strInput.equals("1")) {
				this.startGame();
				continue;
			}
		}

	}

	@Override
	public void startGame() {
		PlayerService 딜러 = new PlayerService(deckList);
		PlayerService 플레이어 = new PlayerService(deckList, "플레이어");
		// TODO Auto-generated method stub
		
		ds.makeDeck();
		
		//deckList = new ArrayList<DeckVO>(); // List<DeckVO> deckList = dS.getDeck();
		딜러 = new PlayerService(deckList);
		플레이어 = new PlayerService(deckList, "플레이어");
		System.out.println("=".repeat(50));
		System.out.println("각각 카드를 돌립니다");
		딜러.hit();
		플레이어.hit();
		딜러.hit();
		플레이어.hit();
		System.out.println("-".repeat(50));
		System.out.println("딜러와 플레이어가 두번씩 뽑았습니다");
		if (딜러.sumValue() < 17) {
			System.out.println("딜러의 점수가 16이하입니다! 한번 더 뽑습니다!!");
			딜러.hit();
		}
		if (딜러.sumValue() > 21) {
			System.out.println("딜러 LOSS!!");
			return;
		}
		System.out.println("=".repeat(50));
		System.out.println("딜러의 턴이 끝났습니다");
		System.out.println("-".repeat(50));
		System.out.println("딜러의 점수 : " + 딜러.sumValue());
		System.out.println("플레이어의 점수 : " + 플레이어.sumValue());
		
	}

	@Override
	public void resultGame() {
		PlayerService 딜러 = new PlayerService(deckList);
		PlayerService 플레이어 = new PlayerService(deckList, "플레이어");
		// TODO Auto-generated method stub
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
		
	}

}
