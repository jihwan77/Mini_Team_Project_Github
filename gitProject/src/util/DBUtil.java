/**
 * 24 시간 365일 실행되는 서버의 실행 코드라 간주
 * - 요청 수와 무관하게 최초 단 한번만 1회성으로 공유자원 초기화하는 공통 코드로 간주
 * - db의 driver로딩 로직
 * - 시스템 다운 방지를 위한 리소스 최적화
 * 	: Connection 수는 절대 제한 해야됨(유한자원)
 * 	- web server내부에서 설정으로 DB server 시스템 동시 접속 수 제어 얘정
 * 	- Connection Pool 기법 (CP)
 * 	- Connection 제공, 회수하는 주체 필요(javax.sql.DataSource가 할 예정)
 * 
 * 	결론
 * 		- Driver로딩 한번만 실행 보장
 *  	- Connection 객체 반환하는 로직
 *  	- DB의 설정 정보는 별도의 key로 db접속 정보 매핑해서 properties 
 *  		파일로 분리
 *  	- 참고
 *  		: 설정 정보를 코드에서 분리하는 원조가 JDBC
 *  		 - Spring 에선 default
 */

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

/**
 * DBUtil 는 편집 불가능한 구조 권장
 **
 */
public class DBUtil {
	private static Properties dbinfo = new Properties();

	static {
		// 존재하는 파일로 부터 자바 코드로 read하는 API
		try {
			dbinfo.load(new FileInputStream("dbinfo.properties"));
			Class.forName(dbinfo.getProperty("jdbc.driver"));

			System.out.println(dbinfo.getProperty("jdbc.id"));
			System.out.println("로딩 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 추후 CP 기능이 적용될 예정 커넥션 수 제어하는
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbinfo.getProperty("jdbc.url"), dbinfo.getProperty("jdbc.id"),
				dbinfo.getProperty("jdbc.pw"));
	}

	// 자원반환 필수 (query)
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

	// 자원 반환 필수 (insert/update/delete)
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