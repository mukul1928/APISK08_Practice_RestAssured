package HandlingDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection {
	public static void main(String[] args) throws SQLException {
		Connection con = null;//this is a String that's why we are declaring its a null
		Statement mystmt = null;//this is a String that's why we are declaring its a null
		ResultSet myrs = null;
		Object obj = null;
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apisk08","root","root");
		mystmt = con.createStatement();
		myrs = mystmt.executeQuery("select * from apisk08.employees limit 1");
		while(myrs.next()) {
			obj = myrs.getString(1);
			//      myrs.getString(2);
		    //		myrs.getString(3);
		    //		myrs.getString(4);
		}
		System.out.println(obj);
	}
}
