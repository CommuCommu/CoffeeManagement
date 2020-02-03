package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.CoffeeOrderListDto;

public class CoffeeOrderListDaoImpl implements CoffeeOrderListDao {

	@Override
	public boolean orderCoffee(CoffeeOrderListDto dto) {
		String sql = " INSERT INTO COFFEE_ORDER_LIST "
				+ "    VALUES( ? , ? , ? , ? , ? , ? , ? , sysdate) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		boolean result = false;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getSyrup());
			psmt.setString(3, dto.getOrdersize());
			psmt.setInt(4, dto.getShot());
			psmt.setInt(5, dto.getCream());
			psmt.setInt(6, dto.getOrdercount());
			psmt.setInt(7, dto.getPrice());
			
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

	@Override
	public List<CoffeeOrderListDto> getOrderList() {
		String sql = " SELECT * "
				+ "    FROM COFFEE_ORDER_LIST "
				+ "    ORDER BY ORDERDATE DESC ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<CoffeeOrderListDto> list = new ArrayList<CoffeeOrderListDto>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//SELECT SEQ, ID, TITLE, CONTENT, WDATE, DEL, READCOUNT " 이 순서에 있는 것들이 순서대로 1,2,3,4 순서가 매겨져 있음. 단. 자료형 구분 잘해서 넣을 것.
				CoffeeOrderListDto dto = new CoffeeOrderListDto(rs.getString(1), //이름,
																rs.getString(2), //시럽,
																rs.getString(3), //크기,
																rs.getInt(4), //샷,
																rs.getInt(5), //크림,
																rs.getInt(6), //주문 갯수,
																rs.getInt(7), //총가격
																rs.getString(8) //날짜
																);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//conn.rollback(); 지금은 사용하지 말 것.
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}

}
