package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class EmpMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		Statement stmt=con.createStatement();
	
		PreparedStatement pstmt=con.prepareStatement("INSERT INTO EMP_COPY VALUES(?,?,?,?,?,?,?,?,?)");

		ResultSet rs=stmt.executeQuery("SELECT * FROM EMP");

		while(rs.next())
		{
			pstmt.setInt(1, rs.getInt("ID"));
			pstmt.setString(2, rs.getString("NAME"));
			pstmt.setDouble(3, rs.getDouble("SALARY"));
			pstmt.setDouble(4, rs.getDouble("COMMISSION"));
			pstmt.setString(5, rs.getString("ROLE"));
			pstmt.setInt(6, rs.getInt("DEPT_NO"));
			pstmt.setDate(7, rs.getDate("HIRED_DATE"));
			pstmt.setInt(8, rs.getInt("MANAGER_ID"));
			pstmt.setString(9, rs.getString("LOC"));

			pstmt.execute();

			pstmt.clearParameters();
		}

		PreparedStatement pstmt2=con.prepareStatement("SELECT * FROM EMP_COPY");
		rs= pstmt2.executeQuery();		

		while(rs.next())
		{
			System.out.println(rs.getInt("ID")+" - " +rs.getString("NAME"));
			
		}
		rs.close();
		stmt.close();
		pstmt.close();
		pstmt2.close();
		con.close();			
	}

}
