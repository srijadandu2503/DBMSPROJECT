
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class commentdetails {

	public static boolean checkbook(String pid){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from post_type where pid=?");
			ps.setString(1,pid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int insertcomment(String pid,String feedback){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into comment(pid,feedback) values(?,?)");
			ps.setString(1,pid);
			ps.setString(2,feedback);
			//ps.setString(3,Upno);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deleteuser(String pid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from comment where pid=?");
			ps.setString(1,pid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
