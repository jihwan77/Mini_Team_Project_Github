package model;

import java.util.ArrayList;

import model.domain.*;

public class Model {

//	public static Model model = new Model();
//	
//	private Model() {} // 싱글톤 패턴

//	public static Model getModel() {
//		return model;
//	}

	public static ArrayList<Product> getAllProduct() {
		return Database.getAllProduct();
	}

	public static void addProduct(int id, String name, int price, int kcal, int gram, String category) {

		ArrayList<Product> productList = Database.getAllProduct();
		int size = productList.size();

		for (int i = 0; i < size; i++) {
			if (productList.get(i).getId() == id) {
				System.out.println("해당 목록의 상품번호가 존재합니다\n");
				return;
			}

		}
		System.out.println("다음 내용이 추가되었습니다.\n");
		System.out.println("id : " + id + ", name : " + name + ", price : " + price + ", kcal : " + kcal + ", gram : "
				+ gram + ", category : " + category);
		Product newProduct = new Product(id, name, price, kcal, gram, category);
		Database.insertProduct(newProduct);

	}

	public static void deleteProduct(int id) {
		ArrayList<Product> productList = Database.getAllProduct();
		int size = productList.size();

		for (int i = 0; i < size; i++) {
			if (productList.get(i).getId() == id) {

				Database.deleteProduct(i);// 몇번째 인덱스에 있는지 구해야함
				System.out.println("입력하신 " + id + "가 삭제되었습니다!\n");
				return;
			}

		}
		System.out.println("해당 목록이 존재하지 않습니다\n");

	}

	public static void updateProduct(int id, String name, int price, int kcal, int gram, String category) {
		ArrayList<Product> productList = Database.getAllProduct();
		int size = productList.size();

		for (int i = 0; i < size; i++) {
			if (productList.get(i).getId() == id) {

				Database.updateProduct(i, name, price, kcal, gram, category);
				return;
			}

		}
		System.out.println("해당 목록이 존재하지 않습니다\n");

	}

	public static void cartAddProduct(int id, ShoppingCart shoppingArray) {
		ArrayList<Product> cartList = Database.getAllProduct(); // 목록을 다 가져옴

		Product temp = null;
		int size = cartList.size();

		for (int i = 0; i < size; i++) {
			temp = cartList.get(i);
			if (temp.getId() == id) {
				System.out.println(temp.getName() + " 장바구니 추가\n");
				shoppingArray.getCart().add(temp); // shoppingArray를 불러오고 추가
				break;
			}
		}
		System.out.println("해당 목록이 없어 장바구니에 담을 수 없습니다\n");
	}

	public static void cartDeleteProduct(int id, ShoppingCart shoppingArray) {
		ArrayList<Product> cartList = shoppingArray.getCart(); // 장바구니 목록 가져옴

		int size = cartList.size();

		for (int i = 0; i < size; i++) {
			if (cartList.get(i).getId() == id) {
				System.out.println(cartList.get(i).getName() + " 장바구니에서 제거\n");
				cartList.remove(i); // 해당 index 데이터 제거
				break;
			}
		}
		System.out.println("해당 목록이 없어 장바구니에서 제외할게 없습니다\n");
	}

	public static void showCartList(ShoppingCart shoppingArray) {
		ArrayList<Product> cartList = shoppingArray.getCart();

		int size = cartList.size();
		int totalPrice = 0;
		int totalKcal = 0;
		int totalGram = 0;

		if (size == 0) {
			System.out.println("현재 장바구니 목록이 없습니다.\n");
		} else {
			for (Product b : cartList) {
				System.out.println(b.toString());
				totalPrice += b.getPrice();
				totalKcal += b.getKcal();
				totalGram += b.getGram();
			}
			System.out.println("장바구니에 담은 상품은 " + size + "개 입니다.");
			System.out.println("총 가격은 " + totalPrice + "원 입니다.");
			System.out.println("총 칼로리는 " + totalKcal + "kcal 입니다.");
			System.out.println("총 그램은 " + totalGram + "g 입니다.\n");
		}
	}
	
}