package com.kh.miniProject_product;

import java.util.Scanner;

public class ProductMenu {
	ProductController pc = new ProductController();
	Scanner sc = new Scanner(System.in);
	private static final String ADMIN_ID = "admin01"; 
	private static final String ADMIN_PSW = "admin01"; 
	String adLoginId;
	String adLoginPsw;
	
	public void CustomerMenu() {
		while(true) {
			System.out.println("=======고객 메뉴=======");
			System.out.println("1. 전체 상품 목록 조회");
			System.out.println("2. 상품 조회");
			System.out.println("3. 상품 구매");
			System.out.println("4. 뒤로가기(메인 메뉴)");
			System.out.print("번호를 입력해주세요 : ");
			int pmNum = sc.nextInt();
			
			switch(pmNum) {
				case 1:
					System.out.println(pc.printPro());
					break;
				case 2:
					System.out.println("조회하실 상품명을 입력해주세요 : ");
					String searchName = sc.next();
					
					boolean isExist = false;
					for (Product product : pc.products) {
						if (product.getName().equals(searchName)) {
							System.out.println(product.printProduct());
							isExist = true;
							break;
						}
					}
					
					if (!isExist) {
						System.out.println("조회하신 상품이 없습니다.");
					}
					break;
				case 3:
					System.out.println(pc.printPro());
					
					System.out.println("구매하실 상품의 인덱스를 입력해주세요 : ");
					int buyIndex = sc.nextInt();
					
					Product product = pc.products.get(buyIndex);
					
					System.out.println("구매하실 수량을 입력해주세요 : ");
					int buyAmount = sc.nextInt();
					
					if (product.getAmount() >= buyAmount) {
						product.setAmount(product.getAmount() - buyAmount);
						System.out.println("구매되었습니다.");
					} else {
						System.out.println("재고가 부족합니다.");
					}
					break;
				case 4:
					System.out.println("[뒤로가기] 메인 메뉴로 이동합니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void adminLoginMenu() {
		while(true) {
			System.out.println("====== 관리자 로그인 ======");
			System.out.print("아이디 : ");
			adLoginId = sc.next();
			sc.nextLine();
			System.out.print("비밀번호 : ");
			adLoginPsw = sc.next();
			sc.nextLine();
			
			if(adLoginId.equals(ADMIN_ID)) {
				if(adLoginPsw.equals(ADMIN_PSW)) {
					System.out.println("[로그인 성공]");
					adminMenu();
					return;
				}else {
					System.out.println("아이디 또는 비빌번호가 잘못되었습니다.");
				}
			}else {
				System.out.println("존재하지 않는 아이디 또는 비빌번호가 잘못되었습니다.");
			}
		}
	}
	
	public void adminMenu() {
		boolean isTrue = true;
		while(isTrue) {
			int adMNum;
			System.out.println("====== 관리자 메뉴 ======");
			System.out.println("1. 상품 추가");
			System.out.println("2. 상품 삭제");
			System.out.println("3. 상품 수정");
			System.out.println("4. 로그아웃(메인으로)");
			System.out.print("번호를 입력해주세요 : ");
			adMNum = sc.nextInt();
			
			switch(adMNum) {
				case 1:
					System.out.println("====== 상품 추가 ======");
					System.out.print("상품명 : ");
					String name = sc.next();
					System.out.print("가격 : ");
					int price = sc.nextInt();
					System.out.print("수량 : ");
					int amount = sc.nextInt();
					System.out.print("설명 : ");
					sc.nextLine(); //?
					String des = sc.nextLine();
					pc.add(name, price, amount, des);
					break;
				case 2:
					System.out.print("상품을 삭제하시겠습니까?(y/n) : ");
					if(sc.next().charAt(0) == 'y') {
						System.out.println(pc.printPro());
						System.out.print("삭제할 상품의 인덱스 번호를 입력해주세요 : ");
						pc.remove(sc.nextInt());
						System.out.println("삭제되었습니다.");
					} else{
						System.out.println("===취소===");
					}
					break;
				case 3:
					System.out.println("===== 수정 =====");
					System.out.println("1. 상품명");
					System.out.println("2. 가격");
					System.out.println("3. 수량");
					System.out.println("4. 설명");
					System.out.println("9. 수정하기 종료");
					System.out.print("수정 하실 항목을 선택해주세요 : ");
					int modNum = sc.nextInt();
					
					switch(modNum) {
						case 1:{
							System.out.print("상품명 재입력 : ");
							String modName = sc.next();
							pc.modifyName(modName);
							}break;
						case 2:{
							System.out.print("가격 재입력 : ");
							int modPrice = sc.nextInt();
							pc.modifyPrice(modPrice);
							}break;
						case 3:{
							System.out.print("수량 재입력 : ");
							int modAm = sc.nextInt();
							pc.modifyAmount(modAm);
							}break;
						case 4:{
							System.out.print("설명 재입력 : ");
							sc.nextLine();
							String modDes = sc.nextLine();
							pc.modifyDescription(modDes);
							}break;
						case 9:
							System.out.println("수정하기 종료");
						}break;
				case 4:
					System.out.println("[로그아웃]");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
			}
		}
	}
}
