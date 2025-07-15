package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.ProductDAO;
import model.ShoppingCartDAO;
import model.domain.*;

public class Controller {

	private static final ProductDAO model = ProductDAO.getModel();
	private static final ShoppingCartDAO S_model = ShoppingCartDAO.getModel();

	public static void getAllProduct(){
		ArrayList<ProductDTO> datas = null;
		
		try {
			datas = model.getAllProduct();
			SuccessView.print("모든 상품의 정보입니다.")
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.print(e.getMessage());
		}

	// 이것도 insertProduct로 이름을 바꾸어야하나?
	public static void addProduct(int id, String name, int price, int kcal, int gram, String category) {
		if (id != 0 && name != null && name.length() != 0 && price != 0 && kcal != 0 && gram != 0 && category != null
				&& category.length() != 0) {
			try {
				boolean result = model.addProduct(new ProductDTO(id, name, price, kcal, gram, category));
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
		if (id != 0) {
			try {
				boolean result = model.deleteProduct(new ProductDTO(id));
				if (result) {
					SuccessView.printMsg(id + "상품을 삭제하였습니다!"); // 성공이라는거
				} else {
					SuccessView.printMsg(id + "이 상품이 지금 재고가 없어요 다시 해주세요");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print("id값 중복 여부 확인 부탁드립니다 ㅠㅠㅠ"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요");
		}

	}

	public static void updateProduct(int id, String product_name, int product_price, int product_kcal, int product_gram,
			String product_catagory) {
		if (id != 0 && product_name != null && product_name.length() != 0 && product_price != 0 && product_kcal != 0
				&& product_gram != 0 && product_catagory != null && product_catagory.length() != 0) {

			try {
				boolean result = model.updateProduct(id, product_name, product_price, product_kcal, product_gram,
						product_catagory);

				if (result) {
					SuccessView.printMsg(product_name + "상품을 등록 성공!!!"); // 성공이라는거
				} else {
					SuccessView.printMsg(product_name + "이 상품이 지금 재고가 없어요 다시 해주세요");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print("id값 중복 여부 확인 부탁드립니다 ㅠㅠㅠ"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요");
		}

	}

	public static void cartAddProduct(int id, ShoppingCartDTO cart) {
		if (id != 0 && cart != null) {

			try {
				boolean result = S_model.cartAddProduct(id, cart);
				if (result) {
					SuccessView.printMsg(id + "장바구니 담기 성공!!!"); // 성공이라는거
				} else {
					SuccessView.printMsg(id + "이 상품이 지금 재고가 없어요 다시 해주세요.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print("id값 중복 여부 확인 부탁드립니다 ㅠㅠㅠ"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요");
		}

	public static void cartDeleteProduct(int id, ShoppingCartDTO cart) {
		if (id != 0 && cart != null) {
			try {
				boolean result = S_model.cartDeleteProduct(id, cart);

				if (result) {
					SuccessView.printMsg("장바구니에서 " + id + " 제거 성공!!!"); // 성공이라는거
				} else {
					SuccessView.printMsg(id + "이 상품이 지금 재고가 없어요 다시 해주세요");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print("id값 중복 여부 확인 부탁드립니다 ㅠㅠㅠ"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요");
		}

	}

	public static void showCartList(ShoppingCartDTO cart) {
		ArrayList<ShoppingCartDTO> datas = null;
	
		if(cart!=null) {
			try {
				S_datas = S_model.showCartList(cart);
				SuccessView.print("장바구니에 담긴 모든 상품의 정보입니다.")
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print(e.getMessage());
			}
		}F
	}
}
