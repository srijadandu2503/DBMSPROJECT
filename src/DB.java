import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter","root","#Sri#25#03");
		}catch(Exception e){System.out.println(e);}
		return con;
	}

}
