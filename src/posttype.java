
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class posttype {

	public static boolean checkpost(String pid){
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
	public static int insertpost(String pid,String ptype){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into post_type(pid,ptype) values(?,?)");
			ps.setString(1,pid);
			ps.setString(2,ptype);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deletepost(String pid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from post_type where pid=?");
			ps.setString(1,pid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
