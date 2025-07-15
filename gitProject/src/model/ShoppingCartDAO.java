package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.domain.ProductDTO;
import model.domain.ShoppingCartDTO;
import util.DBUtil;

public class ShoppingCartDAO {
	
	private static ShoppingCartDAO model = new ShoppingCartDAO();
//	private ProductDAO() {
//	}

	public static ShoppingCartDAO getModel() {
		return model;
	}
	
	public static ArrayList<ProductDTO> getAllProduct() throws SQLException{ //전체 항목 불러오기
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<ProductDTO> all = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product");

			all = new ArrayList<>(); // 10개의 메모리 증가하는 동적 메모리 생성
			while (rs.next()) {
				all.add(new ProductDTO(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getInt("kcal")
						, rs.getInt("gram"), rs.getString("category")));
			}

		} finally {
			DBUtil.close(conn, stmt, rs);
		}

		return all;
	}
	@Test // public 생성자 필요, private 생성자 주석 처리 함
	public void test() {
		try {
			System.out.println(getAllProduct());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean addProduct(ProductDTO newProduct) throws SQLException { // 객체를 추가
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into employee values (?, ?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, newProduct.getId());
			pstmt.setString(2, newProduct.getName());
			pstmt.setInt(3, newProduct.getPrice());
			pstmt.setInt(4, newProduct.getKcal());
			pstmt.setInt(5, newProduct.getGram());
			pstmt.setString(6, newProduct.getCategory());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
			
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	
	public static boolean updateProduct(int index, String product_name, int product_price,
			int product_kcal, int product_gram, String product_category) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update employee set index=?, product_name=?, "
					+ "product_price=?, product_kcal, product_gram, product_category");
			
			pstmt.setInt(1, index);
			pstmt.setString(2, product_name);
			pstmt.setInt(3, product_price);
			pstmt.setInt(4, product_kcal);
			pstmt.setInt(5, product_gram);
			pstmt.setString(6, product_category);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
			
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return false;
		
	}
	public static boolean deleteProduct(int index) throws SQLException{ // 상품번호로 삭제
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from product where=?");
			
			pstmt.setInt(1, index);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
			
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	public static void cartAddProduct(int id, ShoppingCartDTO shoppingArray) throws Exception{
		ArrayList<ProductDTO> cartList = ProductDAO.getAllProduct(); // 목록을 다 가져옴

		ProductDTO temp = null;
		int size = cartList.size();

		for (int i = 0; i < size; i++) {
			temp = cartList.get(i);
			if (temp.getId() == id) {
				System.out.println(temp.getName() + " 장바구니 추가\n");
				shoppingArray.getCart().add(temp); // shoppingArray를 불러오고 추가
				break;
			}
		}
		System.out.println("해당 목록이 없어 장바구니에 담을 수 없습니다\n");
	}

	public static void cartDeleteProduct(int id, ShoppingCartDTO shoppingArray) throws Exception{
		ArrayList<ProductDTO> cartList = shoppingArray.getCart(); // 장바구니 목록 가져옴

		int size = cartList.size();

		for (int i = 0; i < size; i++) {
			if (cartList.get(i).getId() == id) {
				System.out.println(cartList.get(i).getName() + " 장바구니에서 제거\n");
				cartList.remove(i); // 해당 index 데이터 제거
				break;
			}
		}
		System.out.println("해당 목록이 없어 장바구니에서 제외할게 없습니다\n");
	}

	public static void showCartList(ShoppingCartDTO shoppingArray) throws Exception {
		ArrayList<ProductDTO> cartList = shoppingArray.getCart();

		int size = cartList.size();
		int totalPrice = 0;
		int totalKcal = 0;
		int totalGram = 0;

		if (size == 0) {
			System.out.println("현재 장바구니 목록이 없습니다.\n");
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
		}
	}
	
}
