package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.ProductDAO;
import model.ShoppingCartDAO;
import model.domain.*;
import view.FailView;
import view.SuccessView;

public class Controller {

//	private static final ProductDAO model = ProductDAO.getModel();
//	private static final ShoppingCartDAO S_model = ShoppingCartDAO.getModel();

	public static void getAllProduct() {
		ArrayList<ProductDTO> datas = null;

		try {
			datas = ProductDAO.getAllProduct();
			SuccessView.print("모든 상품의 정보입니다.\n", datas);
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
				boolean result = ProductDAO.addProduct(new ProductDTO(id, name, price, kcal, gram, category));
				if (result) {
					SuccessView.printMsg(name + "상품을 등록 성공!!!\n"); // 성공이라는거
				} else {
					SuccessView.printMsg(name + "이 상품이 지금 재고가 없어요 다시 해주세요\n");
				}
			} catch (SQLException e) {
				//e.printStackTrace();
				FailView.print("id값 중복 여부 확인 부탁드립니다 ㅠㅠㅠ\n"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요\n");
		}
	}

	public static void deleteProduct(int id) {
		if (id != 0) {
			try {
				boolean result = ProductDAO.deleteProduct(id);
				if (result) {
					SuccessView.printMsg("id = " + id + "상품을 성공적으로 삭제하였습니다!\n"); 
				} else {
					SuccessView.printMsg("id = " + id + "이 상품이 지금 등록되어 있지 않습니다. 다시 해주세요\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print("잠시후 재시도 해주십시오.\n"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요\n");
		}

	}

	public static void updateProduct(int id, String product_name, int product_price, int product_kcal, int product_gram,
			String product_catagory) {
		if (id != 0 && product_name != null && product_name.length() != 0 && product_price != 0 && product_kcal != 0
				&& product_gram != 0 && product_catagory != null && product_catagory.length() != 0) {

			try {
				boolean result = ProductDAO.updateProduct(id, product_name, product_price, product_kcal, product_gram,
						product_catagory);

				if (result) {
					SuccessView.printMsg("id : " + id + ", 상품 이름 : " + product_name + "에 대한 상품 정보 업데이트 성공!!!\n"); // 성공이라는거
				} else {
					SuccessView.printMsg("id : " + id + ", 상품 이룸 : " + product_name + "에 대한 상품 정보 업데이트에 실패했어요.\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				FailView.print("잠시후 재시도 해주십시오.\n"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요\n");
		}

	}

	public static void cartAddProduct(int id, ShoppingCartDTO cart) {
		if (id != 0 && cart != null) {

			try {
				boolean result = ShoppingCartDAO.cartAddProduct(id, cart);
				if (result) {
					SuccessView.printMsg(id + "장바구니 담기 성공!!!\n"); // 성공이라는거
				} else {
					SuccessView.printMsg("id = " + id + "해당 상품은 등록되어 있지 않습니다.\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
				FailView.print("잠시후 재시도 해주십시오.\n"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요\n");
		}
	}

	public static void cartDeleteProduct(int id, ShoppingCartDTO cart) {
		if (id != 0 && cart != null) {
			try {
				boolean result = ShoppingCartDAO.cartDeleteProduct(id, cart);

				if (result) {
					SuccessView.printMsg("장바구니에서 " + id + " 제거 성공!!!\n"); // 성공이라는거
				} else {
					SuccessView.printMsg(id + "이 상품은 등록되어 있지 않습니다.\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
				FailView.print("잠시후 다시 시도해주십시오.\n"); // 실패라는거
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요\n");
		}
	}

	public static void showCartList(ShoppingCartDTO cart) {

		if (cart != null) {
			try {
				boolean result = ShoppingCartDAO.showCartList(cart);
				if (result) {
					SuccessView.printMsg("장바구니에 담긴 모든 상품의 정보입니다.\n");
				} else {
					SuccessView.printMsg("장바구니에 담긴 상품이 없습니다.\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
				FailView.print("잠시후 다시 시도하세요.\n");
			}
		} else {
			SuccessView.printMsg("메인 화면 입니다. 입력 데이터 재확인 부탁드려요\n");
		}
	}

}
