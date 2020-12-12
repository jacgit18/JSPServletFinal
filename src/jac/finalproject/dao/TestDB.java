package jac.finalproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import jac.finalproject.controller.DB_BuisnessLogicMiddleware;
import jac.finalproject.controller.SocialLookupRule;
import jac.finalproject.model.SocialSECBean;

public class TestDB {

	public static void main(String[] args) throws  SQLException, ClassNotFoundException {

		
		
		SocialLookupRule serviceUtil = new  DB_BuisnessLogicMiddleware();
		SocialSECBean studentModel = serviceUtil.FindSocial("823978432");

		
		DBUtil db = new DBUtil();
		db.connectDB();
		ResultSet resultset = db.getQuery("select * from Students where ssn = '823978432' ");
		
		if (resultset.next()){
			System.out.println(resultset.getString(1));
			
		} else {
			System.out.println("no Student");
			

		}
		resultset.close();
		db.closeConn();
		
	}

}
