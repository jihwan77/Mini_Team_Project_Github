package view;

import java.util.Scanner;
import java.util.InputMismatchException;
import controller.Controller;

import model.domain.ProductDTO;
import model.domain.ShoppingCartDTO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StartView {
	
	
	
	public static void selectMySQL() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			
			stmt = conn.createStatement();			
			rs = stmt.executeQuery("select * from product");
			
			while( rs.next() ) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) 
									+ " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getInt(5) + " " + rs.getString(6) );
			}
			
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {  
			DBUtil.close(conn, stmt, rs);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ShoppingCartDTO shoppingCart = new ShoppingCartDTO();
		
		
		selectMySQL();

		Controller.getAllProduct();
		while (true) {
			int num = 0;
			while (true) {
				try {
					System.out.println("1. 전체 상품 목록 보기");
					System.out.println("2. 상품 선택 (장바구니 담기)");
					System.out.println("3. 상품 제외 (장바구니 제외하기)");
					System.out.println("4. 장바구니 목록");
					System.out.println("5. 상품 추가하기");
					System.out.println("6. 상품 삭제하기");
					System.out.println("7. 상품 수정하기\n");

					System.out.print("\n번호 입력 : ");
					num = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
					sc.next();
				}
			}
			switch (num) {
			case 1:
				ArrayList<ProductDTO> cartList = Controller.getAllProduct();
				for (ProductDTO b : cartList) {
					System.out.println(b.toString());
				}
				System.out.println();
				break;
			case 2:
				System.out.print("선택할 상품 번호를 입력하세요 : ");
				String productNumber = sc.next();
				int productId = Integer.parseInt(productNumber);
				
				Controller.cartAddProduct(productId, shoppingCart);
				
				break;
			case 3:
				System.out.print("제거할 상품 번호를 입력히세요 : ");
				String productNumber2 = sc.next();
				int productId2 = Integer.parseInt(productNumber2);
				Controller.cartDeleteProduct(productId2, shoppingCart);
				break;
			case 4:
				System.out.println("현재 장바구니 목록입니다 : ");
				
				Controller.showCartList(shoppingCart);
				
				
				break;
			case 5:
				System.out.println("추가할 상품 정보를 입력하세요.\n");
				System.out.println("id입력 : ");
				int id = sc.nextInt();
				sc.nextLine();
			
				System.out.println("상품명 입력 : ");
				String name = sc.next();
				sc.nextLine();
				
				System.out.println("가격 입력 : ");
				int price = sc.nextInt();
				sc.nextLine();
				
				System.out.println("kcal 입력 : ");
				int kcal = sc.nextInt();
				sc.nextLine();
				
				System.out.println("gram 입력 : ");
				int gram = sc.nextInt();
				sc.nextLine();
				
				System.out.println("category 입력 : ");
				String category = sc.next();
				sc.nextLine();
				
				Controller.addProduct(id, name, price, kcal, gram, category);

				break;
			case 6: // 삭제 부분
				System.out.println("삭제할 상품 정보를 입력하세요.\n");
				System.out.println("id입력 : ");
				id = sc.nextInt();
				sc.nextLine();
				Controller.deleteProduct(id);
				//System.out.println("입력하신 "+ id + "가 삭제되었습니다!");
				break;
			case 7: // 수정
				System.out.println("수정을 원하는 상품의 id를 입력하시오.\n");
				System.out.println("id입력 : ");
				id = sc.nextInt();
				sc.nextLine();
			
				System.out.println("상품명 입력 : ");
				name = sc.next();
				sc.nextLine();
				
				System.out.println("가격 입력 : ");
				price = sc.nextInt();
				sc.nextLine();
				
				System.out.println("kcal 입력 : ");
				kcal = sc.nextInt();
				sc.nextLine();
				
				System.out.println("gram 입력 : ");
				gram = sc.nextInt();
				sc.nextLine();
				
				System.out.println("category 입력 : ");
				category = sc.next();
				sc.nextLine();
				System.out.println("다음 내용이 추가되었습니다.\n");
				System.out.println("id : " + id + ", name : " + name + ", price : " + price + ", kcal : " + kcal + ", gram : " + gram + ", category : " + category );
				
				Controller.updateProduct(id, name, price, kcal, gram, category);
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.\n");
				break;
			}
		}

	}
	}

