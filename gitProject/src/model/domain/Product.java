package model.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
	private int id;
	private String name;
	private int price;
	private int kcal;
	private int gram;
	private String catagory;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", kcal=");
		builder.append(kcal);
		builder.append(", gram=");
		builder.append(gram);
		builder.append(", catagory=");
		builder.append(catagory);
		builder.append("]");
		builder.append("\n");

		return builder.toString();
	}
	
	
}

