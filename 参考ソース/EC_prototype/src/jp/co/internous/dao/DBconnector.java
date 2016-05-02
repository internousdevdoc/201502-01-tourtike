package jp.co.internous.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnector {

	private static String driverName="com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/ecprototype";
	private static String user = "root";
	private static String pass ="mysql";
	public static Connection getConnection()throws Exception{
		Connection con=null;
		try{
		Class.forName(driverName);
		con = DriverManager.getConnection(url,user,pass);
		}catch(Exception e){

		}//catch
		return con;

	}
}
