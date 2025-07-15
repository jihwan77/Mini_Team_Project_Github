package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.domain.ProductDTO;
import util.DBUtil;

public class ProductDAO {
	
	private static ProductDAO model = new ProductDAO();
//	private ProductDAO() {
//	}

	public static ProductDAO getModel() {
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
	
	
	public static boolean insertProduct(ProductDTO newProduct) { // 객체를 추가
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into employee values (?, ?, ?)");
			
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setInt(3, emp.getDeptno());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
			
		}finally{
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	
	public static void updateProduct(int index, String product_name, int product_price, int product_kcal, int product_gram, String product_category) {
		ProductDTO pd = productArray.get(index);
		pd.setName(product_name);
		pd.setPrice(product_price);
		pd.setKcal(product_kcal);
		pd.setGram(product_gram);
		pd.setCategory(product_category);
		productArray.remove(index);
		productArray.add(pd);
		
	}// 변수값 수정
	public static void deleteProduct(int index) { // 상품번호로 삭제
		productArray.remove(index);
	}
	
}
