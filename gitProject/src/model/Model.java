package model;

import java.util.ArrayList;

import model.domain.*;

public class Model {
	
	private static Model model = new Model();
	
	private Model() {}
	
	public static Model getModel() {
		return model;
	}
	
	public static ArrayList<Product> getAllProduct() {
		return Database.getAllProduct();
	}
	
	public static void insertProduct(Product newProduct) {
		Database.insertProduct(newProduct);
		
	}
	
	public static void updateProduct(int index, String product_name, int product_price, int product_kcal, int product_gram, String product_catagory) {
		Database.updateProduct(index, product_name, product_price, product_kcal, product_gram, product_catagory);
	}
	
	public void deleteProduct(int index) {
		Database.deleteProduct(index);
	}
	
	
//	public static void cartInsertProduct(int id, ShoppingCart shoppingArray){ // 장바구니 추가
//		
//		ArrayList<Product> ownProduct = db.getAllProduct();
//		
//		
//		Product temp = new Product(0, null, 0, 0, 0, null);
//		
//		for (int i = 0; i < ownProduct.size(); i++) {
//			if (ownProduct.get(i).getId() == id) {
//				
//				System.out.println(ownProduct.get(i).getName() + "을(를) 담았습니다.\n");
//				temp = ownProduct.get(i);
//				break;
//			} 
//		}
//		shoppingArray.getCart().add(temp);
//	}
	
	
	
	public static void cartInsertProduct(int id, ShoppingCart shoppingArray){ // 장바구니 추가
		
		ArrayList<Product> ownProduct = Database.getAllProduct();
		int size = ownProduct.size();
		
		Product product = null;
		
		for (int i = 0; i < size; i++) {
			product = ownProduct.get(i);
			
			if (product.getId() == id) {
				
				System.out.println(product.getName() + "을(를) 담았습니다.\n");
				shoppingArray.getCart().add(product);
				System.out.println("**** " + shoppingArray.getCart());
				break;
			} 
		}
	}
	
	
	public static void cartDeleteProduct(int id, ShoppingCart shoppingArray){ // 장바구니 제거
		
		ArrayList<Product> ownProduct = shoppingArray.getCart();
		
		Product product2 = null;
		
		int size = ownProduct.size();
		
		for (int i = 0; i < size; i++) {
			product2 = ownProduct.get(i);
			
			if (product2.getId() == id) {
				
				System.out.println(product2.getName() + "을(를) 제외합니다.\n");
				
				ownProduct.remove(i);
				break;
			} 
		}
		System.out.println("장바구니에 해당 상품이 없습니다.");
	}
		

	
	public static void getCartProduct(ShoppingCart shoppingArray){
		
		ArrayList<Product> cartList = shoppingArray.getCart();
		if(cartList.size() == 0) {
			System.out.println("현재 다음 목록이 없습니다.\n");
		}else {
			for (Product b : cartList) {
				System.out.println(b.toString());
			}
		}
	}
	
	
	
}
