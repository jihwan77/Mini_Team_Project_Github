package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.ProductDAO;
import model.ShoppingCartDAO;
import model.domain.*;
import view.SuccessView;

public class Controller {
	
	public static void getAllProduct(){
		ArrayList<ProductDTO> datas = null;
		
		try {
			datas = ProductDAO.getAllProduct();
			SuccessView.print("상품 정보입니다.", datas);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	
	}
	
	public static void addProduct(int id, String product_name, int product_price, int product_kcal, int product_gram, String product_category) {
		ProductDTO newProduct = new ProductDTO(id, product_name, product_price, product_kcal, product_gram, product_category);
		try {
			ProductDAO.addProduct(newProduct);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteProduct(int id) {
		try {
			ProductDAO.deleteProduct(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateProduct(int id, String product_name, int product_price, int product_kcal, int product_gram, String product_catagory) {
		try {
			ProductDAO.updateProduct(id, product_name, product_price, product_kcal, product_gram, product_catagory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void cartAddProduct(int id, ShoppingCartDTO cart) {
		try {
			ShoppingCartDAO.cartAddProduct(id, cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void cartDeleteProduct(int id, ShoppingCartDTO cart) {
		ShoppingCartDAO.cartDeleteProduct(id, cart);
	}
	public static void showCartList(ShoppingCartDTO cart) {
		ShoppingCartDAO.showCartList(cart);
	}
	
	
}
