package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Sample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
/*		Statement stmt=con.createStatement();
		
/*		int updates= stmt.executeUpdate("UPDATE DEPT SET NAME = 'RnD' WHERE ID=3");
		System.out.println("No. of Updates : "+updates);
		
		updates=stmt.executeUpdate("DELETE FROM DEPT WHERE ID=6");
		System.out.println("No. of Deletes : "+updates);
		
		ResultSet rs=stmt.executeQuery("SELECT * FROM DEPT");
		while(rs.next())
		{
			System.out.println(rs.getInt("ID")+" - " +rs.getString("NAME"));
			
		}
		
		updates=stmt.executeUpdate("INSERT INTO DEPT VALUES (6 , 'Management') ");
		System.out.println("No. of Inserts : "+updates);
		
		rs=stmt.executeQuery("SELECT * FROM DEPT");
*/
		PreparedStatement pstmt=con.prepareStatement("UPDATE DEPT SET NAME = ? WHERE ID=?");
		pstmt.setString(1, "RandS");
		pstmt.setInt(2, 3);
		int updates= pstmt.executeUpdate();
		System.out.println("No. of Updates : "+updates);
		
		PreparedStatement pstmt1=con.prepareStatement("DELETE FROM DEPT WHERE ID=?");
		pstmt1.setInt(1, 6);
		updates= pstmt1.executeUpdate();
		System.out.println("No. of Deletes : "+updates);
		
		PreparedStatement pstmt3=con.prepareStatement("INSERT INTO DEPT VALUES (? , ?) ");
		pstmt3.setInt(1, 6);
		pstmt3.setString(2, "Mngmt");
		updates= pstmt3.executeUpdate();
		System.out.println("No. of Inserts : "+updates);
		
		PreparedStatement pstmt2=con.prepareStatement("SELECT * FROM DEPT");
		ResultSet rs= pstmt2.executeQuery();		
		while(rs.next())
		{
			System.out.println(rs.getInt("ID")+" - " +rs.getString("NAME"));
			
		}
		
		rs.close();
		pstmt.close();
		pstmt1.close();
		pstmt2.close();
		pstmt3.close();
		con.close();		
	}

}
