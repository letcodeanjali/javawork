package Test2;

import java.sql.*;
import java.util.*;

public class EmpDAOImp implements EmpDAO{


	Connection con=DBCon.getConnection();
	
public List<Employee>getEmployees()throws SQLException{
		return null;
		
	}
	public int add(Employee emp) throws SQLException{
		return 0;
	}
	
	/*
	 * Read Operations
	 */
	
	public List<Employee> getEmployees1() throws SQLException{
		String query="select * from employee";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		List<Employee> ls=new ArrayList<Employee>();
		while(rs.next()) {
			Employee em=new Employee();
			em.setId(rs.getInt("EMP_ID"));
			em.setFirstname("FIRST_NAME");
			em.setLastname("LAST_NAME");
			ls.add(em);
		}
		
		return ls;
		
	}
	
	/*
	 * Delete Operations
	 */
	
	public void delete(int id)throws SQLException {
		String query="delete from employee where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,id);
		ps.executeUpdate();
		System.out.println("Record Deleted Sucessfully.....");
	}
		
	
	

	
}
