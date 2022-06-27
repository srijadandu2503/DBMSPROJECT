
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userdetails {

	public static boolean checkbook(String uid){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user_details where uid=?");
			ps.setString(1,uid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int insertbook(String Uid,String Uemail,String Upno){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user_details(Uid,Uemail,Upno) values(?,?,?)");
			ps.setString(1,Uid);
			ps.setString(2,Uemail);
			ps.setString(3,Upno);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deleteuser(String uid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from user_details where uid=?");
			ps.setString(1,uid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
