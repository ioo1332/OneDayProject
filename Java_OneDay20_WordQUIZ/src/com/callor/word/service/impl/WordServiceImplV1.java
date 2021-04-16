package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.service.WordService;
import com.callor.word.service.model.WordVO;
import com.ioo.standard.MenuService;
import com.ioo.standard.impl.MenuServiceImplV1;

public class WordServiceImplV1 implements WordService {
	protected Scanner scan;
	protected List<WordVO> wordList;
	protected final int 영어 = 0;
	protected final int 한글 = 1;
	protected MenuService menuService;
	protected Random rnd;
	protected WordVO wdVO = new WordVO();
	protected Integer uScore = 0;

	public WordServiceImplV1() {
		// TODO Auto-generated constructor stub
		scan = new Scanner(System.in);
		wordList = new ArrayList<WordVO>();
		Random rnd = new Random();
		this.loadWord();

	}

	@Override
	public void loadWord() {
		// TODO Auto-generated method stub
		String wordFile = "src/com/callor/word/word.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(wordFile);
			buffer = new BufferedReader(fileReader);

			while (true) {
				String reader = buffer.readLine();
				if (reader == null)
					break;
				String word[] = reader.split(":");
				WordVO wordVO = new WordVO();
				wordVO.setEng(word[영어]);
				wordVO.setKor(word[한글]);
				wordList.add(wordVO);
			}
			buffer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("파일을 여는동안 문제 발생");
		} catch (IOException e) {
			System.out.println("파일에서 데이터 읽는중 문제 발생");
		}

	}

	@Override
	public void selectMenu() {
		// TODO Auto-generated method stub
		List<String> menuList = new ArrayList<String>();

		menuList.add("새 로 하 기");
		menuList.add("이 어 하 기");
		menuList.add("저 장 하 기");

		menuService = new MenuServiceImplV1("뤼팡의 영 단어 퀴즈", menuList);
		while (true) {
			Integer menu = menuService.selectMenu();
			if (menu == null) {
				System.out.println("게 임 종 료");
				break;
			}
			if (menu == 1) {
				this.viewWord();
			} else if (menu == 2) {
				this.loadGame();
			} else if (menu == 3) {
				this.saveGame();
			}
		}

	}

	@Override
	public void printWord() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewWord() {
		// TODO Auto-generated method stub

		Random rnd = new Random();
		WordVO word = this.getWord();
		String strEng = word.getEng();
		String[] strWord = strEng.split("");

		for (int i = 0; i < 100; i++) {
			int index1 = rnd.nextInt(strWord.length);
			int index2 = rnd.nextInt(strWord.length);
			String temp = strWord[index1];
			strWord[index1] = strWord[index2];
			strWord[index2] = temp;
		}
		while (true) {
			String strInput = null;
			System.out.println("=".repeat(50));
			System.out.println(word.toString());// 정답
			System.out.println("제시된 영 단어를 바르게 배열하세요(QUIT:게임종료)");
			System.out.println(Arrays.toString(strWord));
			System.out.println("=".repeat(50));
			System.out.print(">>");
			strInput = scan.nextLine();
			if (strInput.equals("QUIT")) {
				break;
			}
			if (strInput.equalsIgnoreCase(word.getEng())) {
				System.out.println(word.toString());// 정답
				System.out.print("정답! 점수획득ㅊㅊ\t");
				uScore++;
				System.out.println("플레이어 점수" + uScore);
				this.selectMenu();
			} else {
				System.out.println("오답! 재도전하려면 재도전 외치기 힌트는 힌트");
				System.out.println("그만하려면 QIUT");
				System.out.println(">>");
				strInput = scan.nextLine();
				if (strInput.equals("힌트")) {
					uScore--;
					System.out.println(word.getKor());
				}
				if (strInput.equals("QUIT")) {
					System.out.println("ㅂㅂ");
					break;
				} else {
					strInput.equals("재도전");
					if (strInput.equalsIgnoreCase(word.getEng())) {
						System.out.println(Arrays.toString(strWord));
						uScore--;
						return;
					}
				}
			}
			wdVO.getCount();
			wdVO.getnWinCount();
			wdVO.getnLossCount();
			
		}
		System.out.println("게임종료");
	}

	protected WordVO getWord() {
		Random rnd = new Random();
		rnd.nextInt(100);
		int nSize = wordList.size();
		int num = rnd.nextInt(nSize);
		WordVO wordVO = wordList.get(num);

		return wordVO;

	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("게임저장");
			System.out.println("파일이름 입력하세요");
			System.out.println(">>");
			String strFileName = scan.nextLine();
			if (strFileName.equals("")) {
				System.out.println("파일이름입력해주세요");
				continue;
			}
			FileWriter fileWriter = null;
			PrintWriter out = null;

			strFileName = "src/com/callor/app/" + strFileName + ".txt";

			try {
				fileWriter = new FileWriter(strFileName);
				out = new PrintWriter(fileWriter);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("파일생성불가");
				continue;
			}

		}

	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub
		
		
	}

}
