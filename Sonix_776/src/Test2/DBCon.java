package Test2;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBCon {
	
	private static Connection con=null;
	static {
		String url = "jdbc:mysql://localhost:3306/task?useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pwd = "Paddu@8035";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con=DriverManager.getConnection(url,user,pwd);
        }catch(Exception e) {
        	e.printStackTrace();
        }
       
	}
	
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return con;
	}
	
}



