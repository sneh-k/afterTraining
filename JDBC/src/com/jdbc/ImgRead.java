package com.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImgRead {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
		
/*		PreparedStatement pstmt = 
				con.prepareStatement("INSERT INTO EMP1 VALUES(?, ?, ?)");
		pstmt.setInt(1,  200);
		pstmt.setString(2,  "Tom");
		File file = new File("C:/Users/kamat_sn/workspace/JDBC/src/com/jdbc/photo.jpg");
		FileInputStream fis = new FileInputStream(file);
		pstmt.setBinaryStream(3, fis, file.length());
		pstmt.executeUpdate();
*/
		try
		{
		PreparedStatement ps=con.prepareStatement("select * from EMP1");  
		ResultSet rs=ps.executeQuery();  
		if(rs.next()){ 
		              
		Blob b=rs.getBlob(3); 
		byte barr[]=b.getBytes(1,(int)b.length()); 
		              
		FileOutputStream fout=new FileOutputStream("d:\\p1.jpg");  
		fout.write(barr);  
		              
		fout.close();  
		}//end of if  
		System.out.println("ok");  
		              
		con.close();  
		}
		catch(Exception e)
		{
			e.printStackTrace();  
		}  
	}  
}
