package view;

import java.util.ArrayList;

import model.domain.ProductDTO;

public class SuccessView {

	public static void print(String successMsg, ArrayList<ProductDTO> datas) {
		System.out.println(successMsg);
		
		
		for(ProductDTO emp : datas) {
			System.out.println(emp);
		}
	}

	public static void printMsg(String Message) {
		System.out.println(Message);
	}

}
