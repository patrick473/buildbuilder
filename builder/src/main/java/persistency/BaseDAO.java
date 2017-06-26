package persistency;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	//Connectie maken met de database. Voorkomt stacken van connecties.
	protected static Connection getConnection() {
	    Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			//Heroku database gegevens. voer localen gegevens in, voor lokaal gebruik.
			String username = "postgres";
			String password = "hunter2";
		    String dbUrl = "jdbc:postgresql://localhost:5432/lolbuilder";

		    con = DriverManager.getConnection(dbUrl, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("connection succesful");
		return con;
	}
}
