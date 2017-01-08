package com.jfsaaved.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfsaaved.model.Circle;

public class JDBCDAO {

	public Circle getCircle(int id) {
		Connection conn = null;
		
		try{
			String driver = "org.apache.derby.jdbc.ClientDriver";
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id = ?");
			ps.setInt(1, id);
			
			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				circle = new Circle(id, rs.getString("name"));
			}
			
			rs.close();
			ps.close();
			
		return circle;
		} catch (Exception e) {
			System.out.println("ERROR");
		} finally {
			try {
				conn.close();
			} catch(SQLException se) {
				System.out.println("ERROR");
			}
		}
		
		return null;

	}
}
