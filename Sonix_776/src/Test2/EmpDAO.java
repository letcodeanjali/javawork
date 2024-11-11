package Test2;
import java.sql.SQLException;
import java.util.List;

public interface EmpDAO {

	

	
		public List<Employee> getEmployees()throws SQLException;
		public int add(Employee emp) throws SQLException;
		public void delete(int id)throws SQLException;
		public void update(int id)throws SQLException;
		
		
	

	
}
