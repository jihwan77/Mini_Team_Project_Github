package controller;

import java.util.ArrayList;
import model.Model;
import model.domain.*;

public class Controller {
	
	public static ArrayList<Product> getAllProduct(){
		return Model.getAllProduct();
	}
	
	public static void addProduct(int id, String name, int price, int kcal, int gram, String category) {
		Model.addProduct(id, name, price, kcal, gram, category);
	}
	
	public static void deleteProduct(int id) {
		Model.deleteProduct(id);
	}
	
	public static void updateProduct(int index, String product_name, int product_price, int product_kcal, int product_gram, String product_catagory) {
		Model.updateProduct(index, product_name, product_price, product_kcal, product_gram, product_catagory);
	}

	
	
	public static void cartAddProduct(int id, ShoppingCart cart) {
		Model.cartAddProduct(id, cart);
	}
	public static void cartDeleteProduct(int id, ShoppingCart cart) {
		Model.cartDeleteProduct(id, cart);
	}
	public static void showCartList(ShoppingCart cart) {
		Model.showCartList(cart);
	}
	
	
}
