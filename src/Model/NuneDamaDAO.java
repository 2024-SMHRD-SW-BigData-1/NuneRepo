package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NuneDamaDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	public NuneDamaDTO Select(NuneDamaDTO dto) {
		
		dbOpen();
		
		String sql = "SELECT * FROM DAMA WHERE ID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getId());

			rs = psmt.executeQuery();
		
			if(rs.next()) {
				String id = rs.getString(1);
				int exp = rs.getInt(2);
				int hp = rs.getInt(3);
				int lv = rs.getInt(4);
				dto = new NuneDamaDTO(id, exp, hp, lv);
			}
		} catch (SQLException e) {
			System.out.println("sql 실행 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return dto;
	}
			
			

		
		
		
		
	

	

//	public int update(StudentDTO dto) {
//
//		int cnt = 0;
//
//		dbOpen();
//
//		try {
//			String sql = "UPDATE STUDENT SET CLASS = ? WHERE NAME = ? AND AGE = ?";
//
//			psmt = conn.prepareStatement(sql);
//
//			psmt.setString(1, dto.getCls());
//			psmt.setString(2, dto.getName());
//			psmt.setInt(3, dto.getAge());
//
//			cnt = psmt.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println("sql 실행 에러");
//			e.printStackTrace();
//		} finally {
//			dbClose();
//		}
//
//		return cnt;
//	}

	// 학생 정보 전체 조회

	// 데이터베이스와의 동적로딩/권한확인
	public void dbOpen() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String id = "campus_24SW_BIG_p1_5";
			String pw = "smhrd5";
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";

			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("동적 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("권한 확인 실패");
			e.printStackTrace();
		}

	}

	// 데이터베이스 자원 반납
	public void dbClose() {
		try {
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
