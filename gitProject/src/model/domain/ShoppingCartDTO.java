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
public class ShoppingCartDTO {
	private int id;
	private String name;
	private int price;
	private int kcal;
	private int gram;
	private String category;
	ArrayList<ProductDTO> cart = new ArrayList<>();
	
	public ShoppingCartDTO (int id, String name, int price, int kcal, int gram, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.kcal = kcal;
		this.gram = gram;
		this.category = category;
	
	}
}
