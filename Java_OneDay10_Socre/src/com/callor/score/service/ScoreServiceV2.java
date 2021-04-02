package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV2 {
	protected Scanner scan;
	protected List<ScoreVO> intList;
	ScoreVO scVO = new ScoreVO();

	public void makeMenu() {
		
		scan = new Scanner(System.in);
		intList = new ArrayList<ScoreVO>();
	}
}
