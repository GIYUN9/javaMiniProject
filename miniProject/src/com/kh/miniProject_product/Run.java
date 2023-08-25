package com.kh.miniProject_product;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		ProductMenu pm = new ProductMenu();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("======= Main =======");
			System.out.println("1. 고객 메뉴");
			System.out.println("2. 관리자 메뉴");
			System.out.println("9. 프로그램 종료");
			System.out.println("번호를 선택해주세요 : ");
			int mainNum = sc.nextInt();
			
			switch(mainNum) {
				case 1:
					// 1. 고객 메뉴
					break;
				case 2:
					// 2. 관리자 로그인
					break;
				case 9:
					// 9. 프로그램 종료
					System.out.println("[프로그램을 종료합니다.]");
					return;
				default:
					System.out.println("잘못된 번호입니다. 다시입력해주세요.");
					break;
			}
		}
		
	}
}
