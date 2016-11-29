package com.mock.Mockito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({DriverManager.class, DatabaseOpr.class})

public class MockitoMain {
	
	
    @Mock
    Connection mockConn;
    @Mock
    Statement mockStmnt;
    @Mock
    ResultSet mockResultSet;
    int userId = 100;
    
//    PowerMockito.mockStatic(DriverManager.class);
    @Test
    public void test() throws Exception {
        
    	PowerMockito.mockStatic(DriverManager.class);
    	when(DriverManager.getConnection(anyString(), anyString(), anyString())).thenReturn(mockConn);
        doNothing().when(mockConn).commit();
        when(mockConn.createStatement()).thenReturn(mockStmnt);
        doNothing().when(mockStmnt);
        when(mockStmnt.executeQuery(anyString())).thenReturn(mockResultSet);
        when(mockStmnt.getGeneratedKeys()).thenReturn(mockResultSet);
        
        DatabaseOpr databaseOpr = new DatabaseOpr();
		List<Employee> empList = databaseOpr.getAllEmployees();
		System.out.println(empList);
		assertEquals(new ArrayList<Employee>(), empList);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
