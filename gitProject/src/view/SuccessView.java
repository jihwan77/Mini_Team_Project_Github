package view;

import java.util.ArrayList;

import model.domain.Product;

public class SuccessView {


	public static void print(String string, ArrayList<Product> datas) {
		System.out.println(string);
		
		for(Product b : datas) {
			System.out.println(b.getName());
			
			
		}
	}

}
