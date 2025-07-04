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
		return "상품번호 : " + "상품명 : " + "가격 : " + "kcal : " + "무게(g) : " + "카테고리 : ";
		
	}
}

