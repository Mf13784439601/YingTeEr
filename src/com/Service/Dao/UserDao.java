package com.Service.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class UserDao {
	public boolean isExit(String username, String password) throws SQLException {
	
	     if(!username.equals("root")||!password.equals("root"))
	     {
	    	 System.out.println("用户名或密码错误");
	    	 return false;
	    	 
	     }
		else {
			 return true;
		}
			
	}
	
}
