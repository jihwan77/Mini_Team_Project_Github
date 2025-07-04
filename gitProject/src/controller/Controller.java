package controller;

import java.util.ArrayList;


import model.Model;
import model.domain.Product;
import model.domain.ShoppingCart;
import view.SuccessView;

public class Controller {
	private static final Model model = Model.getModel();

	public static void getAllProduct(){
		ArrayList<Product> datas = model.getAllProduct();
		SuccessView.print("목록 정보입니다.\n", datas);
	}
	
	public static void insertProduct(Product datas) {
		model.insertProduct(datas);
	}
	
	public static void updateProduct(int index, String product_name, int product_price, int product_kcal, int product_gram, String product_catagory) {
		model.updateProduct(index, product_name, product_price, product_kcal, product_gram, product_catagory);
	}

	
	
	public static void cartInsertProduct(int id, ShoppingCart cart) {
		model.cartInsertProduct(id, cart);
	}
	public static void cartDeleteProduct(int id, ShoppingCart cart) {
		model.cartDeleteProduct(id, cart);
	}
	public static void getCartProduct(ShoppingCart cart) {
		model.getCartProduct(cart);
	}
	
	
}
