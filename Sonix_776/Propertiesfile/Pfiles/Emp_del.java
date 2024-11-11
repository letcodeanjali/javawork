package Pfiles;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Properties;
			

	
public class Emp_del {
	

	    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	        FileReader fr = new FileReader("Pdrive.properties");
	        Properties p = new Properties();
	        p.load(fr);
	        String dt = p.getProperty("dvt");
	        String cn = p.getProperty("con");

	        String un = p.getProperty("un");
	        String ps = p.getProperty("pw");
	        String qry = p.getProperty("qr");

	        String qr1 = p.getProperty("qr1");
	        String qr2 = p.getProperty("qr2");
	        String qr3 = p.getProperty("qr3");
	        String qr4 = p.getProperty("qr4");

	        Class.forName(dt);
	        Connection c = DriverManager.getConnection(cn, un, ps);
	        Statement s = c.createStatement();

	        // Read
	        ResultSet r = s.executeQuery(qry);
	        System.out.println("Retrieve");
	        while (r.next()) {
	            System.out.println(r.getInt(1) + "  " + r.getString(2) );
	        }
	        r.close();
	System.out.println();
	        // Create
	        s.executeUpdate(qr4);
	        System.out.println("Insert and Update");

	        // Update
	        s.executeUpdate(qr1);
	       // System.out.println("This is Update Operation");
	        // Read After Create and Update
	        ResultSet r1 = s.executeQuery(qr2);
	        while (r1.next()) {
	            System.out.println(r1.getInt(1) + " " + r1.getString(2) );
	        }
	        r1.close();
	        System.out.println();

	        // Delete
	        s.executeUpdate(qr3);
	        System.out.println("Delete");
	        // Read After Delete
	        ResultSet r2 = s.executeQuery(qr2);
	        //system.out.println("This is Read Operation After delete");
	        while (r2.next()) {
	            System.out.println(r2.getInt(1) + " " + r2.getString(2));
	        }
	        
	        c.close();
	    }
}
