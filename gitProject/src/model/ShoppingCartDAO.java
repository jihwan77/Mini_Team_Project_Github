package model;

import java.util.ArrayList;

import model.domain.ProductDTO;
import model.domain.ShoppingCartDTO;

public class ShoppingCartDAO {
	

	
	public static boolean cartAddProduct(int id, ShoppingCartDTO shoppingArray) throws Exception{
		ArrayList<ProductDTO> cartList = ProductDAO.getAllProduct(); // 목록을 다 가져옴

		ProductDTO temp = null;
		int size = cartList.size();

		for (int i = 0; i < size; i++) {
			temp = cartList.get(i);
			if (temp.getId() == id) {
				System.out.println(temp.getName() + " 장바구니 추가\n");
				shoppingArray.getCart().add(temp); // shoppingArray를 불러오고 추가
				return true;
			}
		}
		//System.out.println("해당 목록이 없어 장바구니에 담을 수 없습니다\n");
		return false;
	}

	public static boolean cartDeleteProduct(int id, ShoppingCartDTO shoppingArray) throws Exception{
		ArrayList<ProductDTO> cartList = shoppingArray.getCart(); // 장바구니 목록 가져옴

		int size = cartList.size();

		for (int i = 0; i < size; i++) {
			if (cartList.get(i).getId() == id) {
				System.out.println(cartList.get(i).getName() + " 장바구니에서 제거\n");
				cartList.remove(i); // 해당 index 데이터 제거
				return true;
			}
		}
		//System.out.println("해당 목록이 없어 장바구니에서 제외할게 없습니다\n");
		return false;
	}

	public static boolean showCartList(ShoppingCartDTO shoppingArray) throws Exception {
		ArrayList<ProductDTO> cartList = shoppingArray.getCart();

		int size = cartList.size();
		int totalPrice = 0;
		int totalKcal = 0;
		int totalGram = 0;

		if (size == 0) {
			return false;
		} else {
			for (ProductDTO b : cartList) {
				System.out.println(b.toString());
				totalPrice += b.getPrice();
				totalKcal += b.getKcal();
				totalGram += b.getGram();
			}
			System.out.println("장바구니에 담은 상품은 " + size + "개 입니다.");
			System.out.println("총 가격은 " + totalPrice + "원 입니다.");
			System.out.println("총 칼로리는 " + totalKcal + "kcal 입니다.");
			System.out.println("총 그램은 " + totalGram + "g 입니다.\n");
			return true;
		}
	}
	
}
