package Test2;

import java.sql.*;
import java.util.Scanner;

public class Travel {
	public static void main(String[] args) {

		  String jdbcURL = "jdbc:mysql://localhost:3306/task?useLegacyDatetimeCode=false&serverTimezone=UTC";
	        String username = "root";
	        String password = "Paddu@8035";
	        String Query="INSERT INTO customer (cid,cname,doj,src,dest,dist,price) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        
	        try(Connection con = DriverManager.getConnection(jdbcURL, username, password);
	       
	                Scanner cs = new Scanner(System.in)){
	        	
	                double price=0.0;
	                System.out.print("Enter Customer Id				 	 : ");
	                int cid=cs.nextInt();
	                System.out.print("Enter Customer Name			     : ");
	                String cname=cs.next();
	                System.out.print("Enter Date of Journey (YYYY-MM-DD) : ");
	                String doj=cs.next();
	                System.out.print("Enter Source City(India)		     : ");
	                String src=cs.next();
	                System.out.print("Enter Destination City(India)	     : ");
	                String dest=cs.next();
	                System.out.print("Enter Distance		  			 : ");
	                double dist=cs.nextDouble();
	                
	                if(dist>1200.00) {
	                	price=dist*15;
	                }else if(dist>=1000.00) {
	                	price=dist*34;
	                }else if(dist>=800.00) {
	                	price=dist*22;
	                }else if(dist>=600.00) {
	                	price=dist*11;
	                }else if(dist>=400.00) {
	                	price=dist*10;
	                }else {
	                	price=dist*18;
	                }
	                System.out.println("We get the estimated price :"+price);
	                PreparedStatement ps=con.prepareStatement(Query); 
	                ps.setInt(1, cid);
	                ps.setString(2, cname);
	                ps.setString(3, doj);
	                ps.setString(4, src);
	                ps.setString(5, dest);
	                ps.setDouble(6, dist);
	                ps.setDouble(7, price);
	                int rowsAffected = ps.executeUpdate();
	                System.out.println(rowsAffected + " Record Inserted");
	        	
	        	
	        	cs.close();
	        	con.close();
	        	
	        
  }
	        catch(SQLException e) {
	        e.printStackTrace();	
	        }
	 
	}

}
