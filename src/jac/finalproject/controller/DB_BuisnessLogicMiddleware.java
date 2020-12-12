package jac.finalproject.controller;

import java.sql.ResultSet;
import java.sql.SQLException;




import jac.finalproject.dao.DBUtil;
import jac.finalproject.model.SocialSECBean;

public class DB_BuisnessLogicMiddleware implements SocialLookupRule  {
	
	private ResultSet resultset;

	public DB_BuisnessLogicMiddleware(){
		
	}

	public SocialSECBean FindSocial(String SSN) {
		SocialSECBean studentModelBean = new SocialSECBean();
		try{
			String queryString2 = "select * from Students where ssn = ? ";

			DBUtil db = new DBUtil();
			
			studentModelBean = db.ssnValidation(SSN);
			
//			studentModelBean = (SocialSECBean) db.getQuery(queryString2);

			db.closeConn();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		
		return (studentModelBean);
	}
	
	 

	
	
	
}
