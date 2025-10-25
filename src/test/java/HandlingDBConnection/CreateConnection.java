package HandlingDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection {
	public static Object getDetailsDB(int x) throws SQLException {
		Connection con = null;//this is a String that's why we are declaring its a null
		Statement mystmt = null;//this is a String that's why we are declaring its a null
		ResultSet myrs = null;
		Object obj = null;
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apisk08","root","root");
		mystmt = con.createStatement();
		myrs = mystmt.executeQuery(SQLQueryEx.sqlQuery());
		while(myrs.next()) 
		{
			obj = myrs.getString(x);
			//      myrs.getString(2);
		    //		myrs.getString(3);
		    //		myrs.getString(4);
		}
		con.close();
		return obj;
}
}
