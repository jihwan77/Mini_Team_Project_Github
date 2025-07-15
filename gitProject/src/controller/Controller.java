package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Model;
import model.ProductDAO;
import model.domain.*;

public class Controller {

	private static final ProductDAO model = ProductDAO.getModel();

	public static void getAllProduct(){
		ArrayList<ProductDTO> datas = null;
		
		try {
			datas = model.getAllProduct();
			SuccessView.print("모든 상품의 정보입니다.")
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.print(e.getMessage());
		}
	}

	// 이것도 insertProduct로 이름을 바꾸어야하나?
	public static void addProduct(int id, String name, int price, int kcal, int gram, String category) {
		if (id != 0 && name != null && name.length() != 0 && price != 0 && kcal != 0 && gram != 0 && category != null
				&& category.length() != 0) {
			try {
				boolean result = ProductDAO.insertProduct(new ProductDTO(id, name, price, kcal, gram, category));
				if (result) {
					SuccessView.printMsg(name + "상품을 등록 성공!!!"); // 성공이라는거
				} else {
					SuccessView.printMsg(name + "이 상품이 지금 재고가 없어요 다시 해주세요");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print("id값 중복 여부 확인 부탁드립니다 ㅠㅠㅠ"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요");
		}
	}

	public static void deleteProduct(int id) {
		Model.deleteProduct(id);
	}

	public static void updateProduct(int index, String product_name, int product_price, int product_kcal,
			int product_gram, String product_catagory) {
		Model.updateProduct(index, product_name, product_price, product_kcal, product_gram, product_catagory);
	}

	public static void cartAddProduct(int id, ShoppingCart cart) {
		Model.cartAddProduct(id, cart);
	}

	public static void cartDeleteProduct(int id, ShoppingCart cart) {
		Model.cartDeleteProduct(id, cart);
	}

	public static void showCartList(ShoppingCart cart) {
		Model.showCartList(cart);
	}

}
