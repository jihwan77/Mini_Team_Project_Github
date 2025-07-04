package controller;

import java.util.ArrayList;

import model.Model;
import model.domain.Product;

public class Controller {
	private static final Model model = Model.getModel();
	
	public static void getAllProduct(){
		ArrayList<Product> datas = null;
			datas = model.cartInsertProduct();
	}
	
	
	public static void InsertProduct() {
		
	}
	
	
	
	public static void updateProduct() {
		
	}
	
	public static void deleteProduct() {
		
	}
	
	
}
