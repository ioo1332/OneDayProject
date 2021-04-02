package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {

	protected Scanner scan;
	protected List<ScoreVO> intList;
	ScoreVO scVO = new ScoreVO();

	public ScoreServiceV1() {
		// TODO Auto-generated constructor stub
		scan = new Scanner(System.in);
		intList = new ArrayList<ScoreVO>();
		ScoreVO scVO = new ScoreVO();
	
	}

	public void makeMenu() {
		
		
		while (true) {
			System.out.println("===================");
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("===================");
			System.out.println("1.학생별 성적 입력");
			System.out.println("2.학생 성적 리스트 출력");
			System.out.println("QUIET.업무종료");
			System.out.println("===================");
			System.out.println("업무선택>>");

			String strMenu = scan.nextLine();
			if (strMenu.equals("QUIET")) {
				break;
			}
			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("메뉴선택 오류");
				System.out.println("메뉴는 1~2,QUIET만 입력가능");
				continue;
			}
			if (intMenu == 0) {
				break;
			} else if (intMenu == 1) {
				this.inputname();
			} else if (intMenu == 2) {
				this.printScoreList();

			}
		} // end while
		System.out.println("업무 종료 퇴근함");
	}

	public void inputname() {
		ScoreVO scVO = new ScoreVO();
		while (true) {
			
			System.out.println("===============");
			System.out.println("학생 이름을 입력하세요 (성적 범위 0 ~ 100 입력을 중단하려면 QUIET)");
			System.out.println("===============");
			System.out.println("이름>>");
			String sname = scan.nextLine();

			System.out.println(sname + " 의 국어점수를 입력하세요");
			System.out.print(">> ");
			Integer kor = scan.nextInt();

			System.out.println(sname + " 의 수학점수를 입력하세요");
			System.out.print(">> ");
			Integer math = scan.nextInt();

			System.out.println(sname + " 의 영어점수를 입력하세요");
			System.out.print(">> ");
			Integer eng = scan.nextInt();

			System.out.println(sname + " 의 과학점수를 입력하세요");
			System.out.print(">> ");
			Integer sci = scan.nextInt();

			System.out.println(sname + " 의 역사점수를 입력하세요");
			System.out.print(">> ");
			Integer his = scan.nextInt();
			
			scVO.setSname(sname);
			scVO.setKor(kor);
			scVO.setMath(math);
			scVO.setEng(eng);
			scVO.setMath(math);
			scVO.setSci(sci);
			scVO.setHis(his);

			intList.add(scVO);
			this.printScore(scVO);
			
		}
	}

	/*
	 * scVO.setSname(sname); this.inputscore(scVO); intList.add(scVO);
	 * 
	 * String strMenu = scan.nextLine(); if (strMenu.equals("QUIET")) {
	 * System.out.println("업무 종료 퇴근함"); break;
	 * 
	 * }
	 * 
	 * }// end while
	 * 
	 * public void inputscore(ScoreVO vo) { while (true) {
	 * System.out.println("================="); System.out.println(vo.getSname() +
	 * "학생의 성적을 입력하세요" + "(성적범위:0~100,입력중단(QUIET)");
	 * System.out.println("================="); System.out.print("국어 점수\t"); Integer
	 * kor = scan.nextInt(); System.out.print("수학 점수\t"); Integer math =
	 * scan.nextInt(); System.out.print("영어 점수\t"); Integer eng = scan.nextInt();
	 * System.out.print("과학 점수\t"); Integer sci = scan.nextInt();
	 * System.out.print("국사 점수\t"); Integer his = scan.nextInt();
	 * 
	 * 
	 * 
	 * String strMenu = scan.nextLine(); if (strMenu.equals("QUIET")) {
	 * System.out.println("업무 종료 퇴근함"); break; } } }
	 */

	public void printScore(ScoreVO vo) {
		
		for (int i = 0; i < intList.size(); i++) {
			ScoreVO scVO = intList.get(i);

			System.out.println("=============");
			System.out.print(vo.getSname());
			System.out.println("\t 학생의 성적이 추가되었습니다");
			System.out.println("=============");
			System.out.println("국어 점수 : " + scVO.getKor());
			System.out.println("수학 점수 : " + scVO.getMath());
			System.out.println("영어 점수 : " + scVO.getEng());
			System.out.println("과학 점수 : " + scVO.getSci());
			System.out.println("국사 점수 : " + scVO.getHis());
		}
		this.makeMenu();

	}

	public void printScoreList() {
	
		
		
		System.out.println("=============");
		System.out.println("이름\t국어\t영어\t수학\t과학\t국사\t총점\t평균\t");
		System.out.println("=============");
		for (int i = 0; i < intList.size(); i++) {
			ScoreVO scVO = intList.get(i);
			System.out.print(scVO.getSname() + "\t");
			System.out.print(scVO.getKor() + "\t");
			System.out.print(scVO.getMath() + "\t");
			System.out.print(scVO.getEng() + "\t");
			System.out.print(scVO.getSci() + "\t");
			System.out.print(scVO.getHis() + "\t");
			System.out.print(scVO.sum() + "\t");
			System.out.print(scVO.floatAvg() + "\n");
		}
		this.makeMenu();
	}
	//,%d\t%d\t%d\\t%d\t%d\t%d\t
	public void allList() {
		int totalKor=0;
		int totalEng=0;
		int totalMath=0;
		int totalSci=0;
		int totalHis=0;
		int alltotal=0;
		
		System.out.println("=====================");
		System.out.println("이름\t국어\t영어\t수학\t과학\t국사\t총점\t평균\t");
		System.out.println("=====================");
		for (int i = 0; i < intList.size(); i++) {
			ScoreVO scVO = intList.get(i);
			totalKor+= scVO.getKor();
			totalEng+= scVO.getEng();
			totalMath+= scVO.getMath();
			totalSci+= scVO.getSci();
			totalHis+= scVO.getHis();
			alltotal=totalKor;
			alltotal+=totalEng;
			alltotal+=totalMath;
			alltotal+=totalSci;
			alltotal+=totalHis;
		}
		System.out.print("총점");
		System.out.print(totalKor+"\t");
		
	}
}
