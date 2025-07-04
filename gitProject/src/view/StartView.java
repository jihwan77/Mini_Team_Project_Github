package view;

import java.util.Scanner;
import java.util.InputMismatchException;
import controller.Controller;
import model.domain.Product;
import model.domain.ShoppingCart;

import java.util.ArrayList;

public class StartView {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();
		ShoppingCart shoppingCart = new ShoppingCart();

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
				ArrayList<Product> cartList = Controller.getAllProduct();
				for (Product b : cartList) {
					System.out.println(b.toString());
				}
				System.out.println();
				break;
			case 2:
				System.out.print("선택할 상품 번호를 입력하세요 : ");
				String productNumber = sc.next();
				int productId = Integer.parseInt(productNumber);
				
				System.out.println("+++ " + shoppingCart.getCart());
				
				Controller.cartInsertProduct(productId, shoppingCart);
				
				break;
			case 3:
				 System.out.print("제거할 상품 번호를 입력하세요 : ");
				 String productNumber2 = sc.next();
				 int productId2 = Integer.parseInt(productNumber2);
				 Controller.cartDeleteProduct(productId2, shoppingCart);
				break;
			case 4:
				// userController.borrowBookList(nowUser);
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.\n");
				break;
			}
		}

	}
}
