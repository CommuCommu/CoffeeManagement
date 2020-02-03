package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.CoffeeMemberDto;

public class CoffeeMemberDaoImpl implements CoffeeMemberDao {

	@Override
	public CoffeeMemberDto login(String id, String pwd) {
		String sql = " SELECT * " //COUNT(*)
				+ "    FROM COFFEE_MEMBER "
				+ "    WHERE PWD = ? "
				+ "     AND  ID = ? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		CoffeeMemberDto memberDto = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.setString(2, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				memberDto = new CoffeeMemberDto();
				
				memberDto.setId( rs.getString("id"));
				memberDto.setPwd( rs.getString("pwd"));
				memberDto.setName( rs.getString("name"));
				memberDto.setEmail( rs.getString("email"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}	
		return memberDto;	
	}

	@Override
	public boolean regiMember(CoffeeMemberDto dto) {
		String sql = " INSERT INTO COFFEE_MEMBER "
				+ "    VALUES( ? , ? , ? , ?) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		boolean result = false;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getEmail());
			
			rs = psmt.executeQuery();
			result = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			DBClose.close(psmt, conn, rs);
		}	
		return result;	
	}	
}
