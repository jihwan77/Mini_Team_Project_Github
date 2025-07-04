package controller;

import java.util.ArrayList;

import model.Model;
import model.domain.Product;
import model.domain.ShoppingCart;

public class Controller {

	public static ArrayList<Product> getAllProduct(){
		return Model.getAllProduct();
		
	}
	
	public static void insertProduct(Product datas) {
		Model.insertProduct(datas);
	}
	
	public static void updateProduct(int index, String product_name, int product_price, int product_kcal, int product_gram, String product_catagory) {
		Model.updateProduct(index, product_name, product_price, product_kcal, product_gram, product_catagory);
	}

	
	
	public static void cartInsertProduct(int id, ShoppingCart cart) {
		Model.cartInsertProduct(id, cart);
	}
	public static void cartDeleteProduct(int id, ShoppingCart cart) {
		Model.cartDeleteProduct(id, cart);
	}
	public static void getCartProduct(ShoppingCart cart) {
		Model.getCartProduct(cart);
	}
	
	
}
