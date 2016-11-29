package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class EmpMain1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		Statement stmt=con.createStatement();		

		stmt.executeUpdate("CREATE TABLE EMP_COPY2(ID NUMBER(4) ,NAME VARCHAR2(30) , SAL NUMBER(8,2))");
		
		PreparedStatement pstmt=con.prepareStatement("INSERT INTO EMP_COPY2 VALUES(?,?,?)");
		ResultSet rs=stmt.executeQuery("SELECT * FROM EMP");
		try
		{
			con.setAutoCommit(false);
			while(rs.next())
			{
				pstmt.setInt(1, rs.getInt("ID"));
				pstmt.setString(2, rs.getString("NAME"));
				pstmt.setDouble(3, rs.getDouble("SALARY"));
				pstmt.addBatch();
	
				pstmt.clearParameters();
			}
			pstmt.executeBatch();
			con.commit();
		}
		catch(Exception e)
		{
			con.rollback();
		}
		finally
		{
			con.setAutoCommit(true);
		}
		
	
//		stmt.executeUpdate("DELETE FROM EMP_COPY2 WHERE ID=1");
/*		
		PreparedStatement pstmt1=con.prepareStatement("DELETE FROM EMP_COPY2 WHERE ID=?");
		pstmt1.setInt(1, 1);
		int updates= pstmt1.executeUpdate();
		System.out.println("No. of Deletes : "+updates);
*/		
		
		PreparedStatement pstmt2=con.prepareStatement("SELECT * FROM EMP_COPY2");
		rs= pstmt2.executeQuery();		

		while(rs.next())
		{
			System.out.println(rs.getInt("ID")+" - " +rs.getString("NAME")+ "-"+ rs.getDouble("SAL"));
		}	
		pstmt.close();
		pstmt2.close();		
		rs.close();
		stmt.close();


		stmt.close();
		con.close();			
	}

}
