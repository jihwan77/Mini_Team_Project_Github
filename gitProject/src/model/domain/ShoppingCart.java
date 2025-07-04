package model.domain;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
	private int id;
	private String name;
	private int price;
	private int kcal;
	private int gram;
	private String catagory;
	ArrayList<Product> cart = new ArrayList<>();
	
	public ShoppingCart (int id, String name, int price, int kcal, int gram, String catagory) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.kcal = kcal;
		this.gram = gram;
		this.catagory = catagory;
	
	}
}
