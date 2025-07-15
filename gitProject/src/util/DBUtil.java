package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// File로 부터 1 byte 단위로 read하는 기능
import java.io.FileInputStream;

//properties 파일에서 key 로 value만 쏙쏘 뽑는 기능
import java.util.Properties;


public class DBUtil {
	private static Properties dbinfo = new Properties();

	static {
		
		try {
			dbinfo.load(new FileInputStream("dbinfo.properties"));
			Class.forName(dbinfo.getProperty("jdbc.driver"));

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbinfo.getProperty("jdbc.url"), dbinfo.getProperty("jdbc.id"),
				dbinfo.getProperty("jdbc.pw"));
	}

	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {

			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}


	public static void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}