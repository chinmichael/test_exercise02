package dbpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public static Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "kosea3";
		String pw = "kosea2019a";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		return conn;
	}
	
	public int memberLogin(String id, String pw, String level) {
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pass, lev from employee where id = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.last();
			
			if(rs.getRow() == 0) {
				result = -1;
				System.out.println("못옴");
			} else {
				rs.beforeFirst();
				while(rs.next()) {
					System.out.println("잘옴");
					if(pw.equals(rs.getString("pass")) && level.equals(rs.getString("lev"))) {
						result = 1;
					} else {
						result = 0;
					}
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public MemberVO getInfo(String id, String pw, String lev) {

		MemberVO result = new MemberVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select name, gender, phone from employee where id = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				
				result = new MemberVO(id, pw, name, lev, gender, phone);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	public int updateMember(MemberVO mv) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update employee set pass = ?, name = ?, lev = ?, gender = ?, phone = ? where id = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getPw());
			pstmt.setString(2, mv.getName());
			pstmt.setString(3, mv.getLevel());
			pstmt.setString(4, mv.getGender());
			pstmt.setString(5, mv.getPhone());
			pstmt.setString(6, mv.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			} 
			
		}
		
		return result;
	}
	
	public int insertMember(MemberVO mv) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into employee(id, pass, name, lev, gender, phone) values (?,?,?,?,?,?)";
		String sql2 = "select id from employee where id = ?";
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, mv.getId());
			rs = pstmt.executeQuery();
			rs.last();
			
			if(rs.getRow() == 0) {
				rs.close();
				pstmt.close();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mv.getId());
				pstmt.setString(2, mv.getPw());
				pstmt.setString(3, mv.getName());
				pstmt.setString(4, mv.getLevel());
				pstmt.setString(5, mv.getGender());
				pstmt.setString(6, mv.getPhone());
				
				result = pstmt.executeUpdate();
				
			} else {
				result = -1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			} 
			
		}
		
		return result;
	}
}
