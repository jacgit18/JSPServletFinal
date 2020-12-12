package jac.finalproject.dao;

import java.sql.*;
import jac.finalproject.model.SocialSECBean;

public class DBUtil   {
	
	private static Connection connect;
	private ResultSet resultset;

//	private static PreparedStatement preparedStatement;
	
	
	public void closeConn() throws SQLException  {
		connect.close();
	}


	public void connectDB(){
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver loaded");

			// Connect to a database
			connect = DriverManager.getConnection(
					"jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;integratedSecurity=false;",
					"cst4713", "password1");
			System.out.println("Database connected");

		} catch ( ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Universal way to get  Student table and other table 
	 * @param query
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ResultSet getQuery(String query) throws SQLException, ClassNotFoundException{
		
		try {
			connectDB();
			Statement statement = connect.createStatement();
			resultset = statement.executeQuery(query);
			
		} catch (SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();

		}
		
		return resultset;
	}

	
	/**
	 * insert into db
	 * @param table
	 * @param query
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void updateValues(String table, String query) throws SQLException, ClassNotFoundException{
		
		
		try {
			connectDB();
			Statement statement = connect.createStatement();// alt to PreparedStatement
			statement.executeQuery(query);
			
		} catch (SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();

		}
	}
	
	
	
	/**
	 * Specfic to Student table
	 * Be careful with query
	 * @param SSN
	 * @return
	 */
	public SocialSECBean ssnValidation(String SSN) {
		String queryString = "select firstName, mi, " + "lastName, title, grade from Students, Enrollment, Course "
				+ "where Students.ssn = ? and Enrollment.courseId = ? " + "and Enrollment.courseId = Course.courseId";
		
		String queryString2 = "select * from Students where ssn = ? ";

		
		SocialSECBean studentModelAccessPass = new SocialSECBean();
		
		try {
			connectDB();
//			preparedStatement = connect.preparedStatement
			PreparedStatement preparedStatement = connect.prepareStatement(queryString2);
			preparedStatement.setString(1, SSN);
			ResultSet resultset = preparedStatement.executeQuery();
			if (resultset.next()) {
				
				studentModelAccessPass.setSSN(resultset.getString(1));
				studentModelAccessPass.setfName(resultset.getString(2));
				studentModelAccessPass.setMi(resultset.getString(3));

				studentModelAccessPass.setlName(resultset.getString(4));
				studentModelAccessPass.setBirthDate(resultset.getString(5));
				studentModelAccessPass.setStreet(resultset.getString(6));

				studentModelAccessPass.setPhone(resultset.getString(7));
				studentModelAccessPass.setZipcode(resultset.getString(8));
				studentModelAccessPass.setDepId(resultset.getString(9));
//				closeConn();

//				resultset.close();

				return (studentModelAccessPass);
				
			} else {
				System.out.println("Not found");
				resultset.close();

//				connect.close();
				System.out.println("Database closed");
				return (studentModelAccessPass);

			}
//			resultset.close();
		} catch (SQLException ex) {
//			ex.printStackTrace();
			return null;

		}

		
	}


//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//		
//
//		
//		
//
//	}


	


}