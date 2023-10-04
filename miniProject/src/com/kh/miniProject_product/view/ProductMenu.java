package com.kh.miniProject_product.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniProject_product.controller.ProductController;
import com.kh.miniProject_product.model.vo.Customer;
import com.kh.miniProject_product.model.vo.Product;
import com.kh.miniProject_product.model.vo.Trading;

public class ProductMenu {
	ProductController pc = new ProductController();
	Scanner sc = new Scanner(System.in);
	String adLoginId;
	String adLoginPsw;
	
	public void mainMenu() {
		while(true) {
			System.out.println("======= Main =======");
			System.out.println("1. 고객 메뉴");
			System.out.println("2. 관리자 메뉴");
			System.out.println("9. 프로그램 종료");
			System.out.println("10. 고객 회원가입");
			System.out.print("번호를 입력해주세요 : ");
			int mainNum = sc.nextInt();
			sc.nextLine();
			
			switch(mainNum) {
				case 1:
					customerLoginMenu();
					break;
				case 2:
					adminLoginMenu();
					break;
				case 9:
					System.out.println("[프로그램을 종료합니다]");
					return;
				case 10:
					System.out.println("===== 회원가입 =====");
					System.out.print("아이디(공백없이 영어와 숫자만 사용) : ");
					String newId = sc.nextLine();
					
					System.out.print("비밀번호(공백없이 영어와 숫자만 사용) : ");
					String newPwd = sc.nextLine();
					
					System.out.print("닉네임 : ");
					String newNick = sc.nextLine();
					
					pc.insertCustomer(newId, newPwd, newNick);
					break;
				default:
					System.out.println("잘못된 번호입니다. 다시입력해주세요.");
					break;
			}
		}
	}
	
	public void CustomerMenu() {
		while(true) {
			System.out.println("=======고객 메뉴=======");
			System.out.println("1. 전체 상품 목록 조회");
			System.out.println("2. 상품 조회");
			System.out.println("3. 상품 구매");
			System.out.println("4. 거래 내역 조회");
			System.out.println("5. 회원정보 조회");
			System.out.println("6. 뒤로가기(메인 메뉴)");
			System.out.print("번호를 입력해주세요 : ");
			int cmNum = sc.nextInt();
			sc.nextLine();
			
			switch(cmNum) {
				case 1:
					pc.selectList();
					break;
				case 2:
					System.out.println("조회하실 상품명을 입력해주세요 : ");
					String searchName = sc.nextLine();
					pc.selectByProName(searchName);
					break;
				case 3:
					pc.selectList();
					System.out.print("회원번호는 고객메뉴의 [5.회원정보 조회]에서 확인가능합니다\n고객님의 회원번호를 입력해주세요 : ");
					int cus_no = sc.nextInt();
					sc.nextLine();
					
					System.out.print("구매하실 상품의 상품번호를 입력해주세요 : ");
					int pro_no = sc.nextInt();
					sc.nextLine();
					
					System.out.print("구매하실 상품의 수량을 입력해주세요 : ");
					int tra_amount = sc.nextInt();
					sc.nextLine();
					
					pc.updateBuyTrading(cus_no, pro_no, tra_amount);
					break;
				case 4:
					System.out.print("내역조회를 위해 고객(본인)번호를 입력해주세요 : ");
					int cus_noSelect = sc.nextInt();
					sc.nextLine();
					pc.selectTrading(cus_noSelect);
					break;
				case 5:
					System.out.println("회원정보 조회를 위해 다시 로그인 해주세요.");
					System.out.print("아이디 : ");
					String id = sc.nextLine();
					
					System.out.print("비밀번호 : ");
					String pwd = sc.nextLine();
					pc.selectCustomerInfo(id, pwd);
					break;
				case 6:
					System.out.println("[뒤로가기] 메인 메뉴로 이동합니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void customerLoginMenu() {
		while(true) {
			System.out.println("====== 고객 로그인 ======");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			int result = pc.customerLoginMenu(id, pwd);
			
			if(result > 0) {
				CustomerMenu();
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}
	}
	
	public void adminLoginMenu() {
		while(true) {
			System.out.println("====== 관리자 로그인 ======");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			int result = pc.adminLoginMenu(id, pwd);
			
			if(result > 0) {
				adminMenu();
				break;
			} else {
				System.out.println("다시 입력해주세요.");
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
			System.out.println("4. 회원 정보 조회");
			System.out.println("5. 고객 거래 이력 전체 조회");
			System.out.println("6. 로그아웃(메인으로)");
			System.out.print("번호를 입력해주세요 : ");
			adMNum = sc.nextInt();
			sc.nextLine();
			
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
					sc.nextLine(); 
					String des = sc.nextLine();
					pc.insertProduct(name, price, amount, des);
					break;
				case 2:
					System.out.println("===== 상품 삭제 =====");
					System.out.print("삭제하실 상품의 상품 번호를 입력하세요 : ");
					int pro_no_del = sc.nextInt();
					sc.nextLine();
					pc.delectProduct(pro_no_del);
					break;
				case 3:
					System.out.println("=====상품 정보 수정 =====");
					
					System.out.print("변경할 상품의 상품번호 : ");
					int pro_no = sc.nextInt();
					sc.nextLine();
					
					System.out.print("변경할 이름 : ");
					String pro_name = sc.nextLine();
					
					System.out.print("변경할 가격 : ");
					int pro_price = sc.nextInt();
					sc.nextLine();
					
					System.out.print("변경할 수량 : ");
					int pro_amount = sc.nextInt();
					sc.nextLine();
					
					System.out.print("변경할 설명 : ");
					String pro_description = sc.nextLine();
					
					pc.updateProduct(pro_no ,pro_name, pro_price, pro_amount, pro_description);
					break;
				case 4:
					pc.selectCustomerList();
					break;
				case 5:
					pc.selectTradingList();
					break;
				case 6:
					System.out.println("[로그아웃]");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
			}
		}
	}
	
	//----------응답화면---------
	
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}
	
	public void displayProductList(ArrayList<Product> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다\n");
		System.out.println("상품번호\t상품명\t가격\t수량\t상품설명");
		
		for(Product p : list) {
			System.out.println(p);
		}
	}
	
	public void displayCustomerList(ArrayList<Customer> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다\n");
		System.out.println("회원번호\t아이디\t비밀번호\t닉네임\t가입일자");
		
		for(Customer c : list) {
			System.out.println(c);
		}
	}
	
	public void displayTradingList(ArrayList<Trading> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다\n");
		System.out.println("거래번호\t고객번호\t상품번호\t수량\t형식\t처리일자");
		
		for(Trading t : list) {
			System.out.println(t);
		}
	}
	
	public void displayProduct(Product p) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(p);
	}
}
