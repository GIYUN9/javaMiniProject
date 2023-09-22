package com.kh.miniProject_product.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniProject_product.controller.ProductController;
import com.kh.miniProject_product.model.vo.Customer;
import com.kh.miniProject_product.model.vo.Product;

public class ProductMenu {
	ProductController pc = new ProductController();
	Scanner sc = new Scanner(System.in);
	private static final String ADMIN_ID = "2"; 
	private static final String ADMIN_PSW = "2"; 
	String adLoginId;
	String adLoginPsw;
	
	public void mainMenu() {
		while(true) {
			System.out.println("======= Main =======");
			System.out.println("1. 고객 메뉴");
			System.out.println("2. 관리자 메뉴");
			System.out.println("9. 프로그램 종료");
			System.out.print("번호를 입력해주세요 : ");
			int mainNum = sc.nextInt();
			sc.nextLine();
			
			switch(mainNum) {
				case 1:
					CustomerMenu();
					break;
				case 2:
					adminLoginMenu();
					break;
				case 9:
					System.out.println("[프로그램을 종료합니다]");
					return;
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
			System.out.println("4. 뒤로가기(메인 메뉴)");
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
					System.out.println(pc.printPro());
					
					System.out.println("구매하실 상품의 인덱스를 입력해주세요 : ");
					int buyIndex = sc.nextInt();
					
					Product product = pc.products.get(buyIndex);
					
					System.out.println("구매하실 수량을 입력해주세요 : ");
					int buyAmount = sc.nextInt();
					
					if (product.getPro_amount() >= buyAmount) {
						product.setPro_amount(product.getPro_amount() - buyAmount);
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
				case 4:
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
	
	public void displayProduct(Product p) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(p);
	}
}
