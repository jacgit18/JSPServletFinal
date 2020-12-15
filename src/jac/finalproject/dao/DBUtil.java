package jac.finalproject.dao;

import java.sql.*;
import jac.finalproject.model.SocialSECBean;

public class DBUtil {

	private static Connection connect;
	private ResultSet resultset;
	private static boolean autoCommit;
	private static String Url = "jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;integratedSecurity=false;";
	private static String Username = "cst4713";
	private static String Password = "password1";

	// private static PreparedStatement preparedStatement;

//	/**
//	 * 
//	 * @param args
//	 * @throws SQLException
//	 * @throws ClassNotFoundException
//	 */
//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//
//	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void closeConn() throws SQLException {
		connect.close();
	}

	/**
	 * method wasnt static before 
	 * @throws SQLException
	 */
	public static void connectDB() throws SQLException {

		try {

			String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			// Class.forName(Driver);
			// System.out.println("Driver loaded ");
			System.out.println(Class.forName(Driver) + " Driver loaded ");

			// Connect to a database
//			String Url = "jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;integratedSecurity=false;";
//			String Username = "cst4713";
//			String Password = "password1";
			connect = DriverManager.getConnection(Url, Username, Password);

			System.out.println("Before commit call ");
			autoCommit = connect.getAutoCommit(); // wasnt static before 

			System.out.println("Before commit value edit " + autoCommit);
			connect.setAutoCommit(false);
			System.out.println("After set value edit " + connect);
			System.out.println("After set value auto commit edit " + autoCommit);

			connect.commit();
			System.out.println("Database commit done");

		} catch (ClassNotFoundException | SQLException ex) {
			// System.out.println(ex);

			connect.rollback(); // get rid of connectDB() throw if issues
			ex.printStackTrace();

		} finally {
			connect.setAutoCommit(autoCommit);
		}
	}

	/**
	 * Universal way to get Student table and other table
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ResultSet getQuery(String query) throws SQLException, ClassNotFoundException {

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
	 * 
	 * @param table
	 * @param query
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void updateValues(String table, String query) throws SQLException, ClassNotFoundException {

		try {
			connectDB();
			Statement statement = connect.createStatement();// alt to
															// PreparedStatement
			statement.executeQuery(query);

		} catch (SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();

		}
	}

	/**
	 * Specfic to Student table Be careful with query
	 * 
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
			// preparedStatement = connect.preparedStatement
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
				// closeConn();

				// resultset.close();

				return (studentModelAccessPass);

			} else {
				System.out.println("Not found");
				resultset.close();

				// connect.close();
				System.out.println("Database closed");
				return (studentModelAccessPass);

			}
			// resultset.close();
		} catch (SQLException ex) {
			// ex.printStackTrace();
			return null;

		}

	}

	public static void  maketb() {
		String queryString ="CREATE TABLE IF NOT EXISTS iamalive(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))";



		try {
			connectDB();
			PreparedStatement preparedStatement = connect.prepareStatement(queryString);
			preparedStatement.executeUpdate();
		} catch (Exception ex) {
			// ex.printStackTrace();

		} finally {
			System.out.println("Function completed");
		}

	}

	
	  public static void post() throws SQLException{
	        final String var1 = "John";
	        final String var2 = "Miller";
	        try{
				connectDB();
	            PreparedStatement posted = connect.prepareStatement("INSERT INTO iamalive (first, last) VALUES ('"+var1+"', '"+var2+"')");
	            
	            posted.executeUpdate();
	        } catch(Exception e){System.out.println(e);}
	        finally {
	            System.out.println("Insert Completed.");
	        }
	    }
	
	
}