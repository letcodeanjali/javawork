package Mypakage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
		

public class Mydb {
	

	
	    public static void main(String[] args) {
	        try {
	            
	            Properties properties = loadProperties("db.properties");

	           
	            String driver = properties.getProperty("dvt");
	            String url = properties.getProperty("con");
	            String username = properties.getProperty("un");
	            String password = properties.getProperty("pw");
	            String selectQuery = properties.getProperty("Q");
	           
	            
	            
	            String updateQuery = properties.getProperty("Q1");
	            String deleteQuery = properties.getProperty("Q3");
	            String insertQuery = properties.getProperty("Q4");

	            // Load JDBC driver
	            Class.forName(driver);

	            try (
	               
	                Connection connection = DriverManager.getConnection(url, username, password);
	                Statement statement = connection.createStatement()
	            ) {
	                

	                // Read data
	            	 System.out.println("Read");
		                statement.executeUpdate(updateQuery);
	                ResultSet resultSet = statement.executeQuery(selectQuery);
	                
	                while (resultSet.next()) {
	                    System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2) + " " + resultSet.getString(3));
	                }

	                // Update data
	                System.out.println("Update ");
	                statement.executeUpdate(updateQuery);

	                // Read data after update
	                ResultSet resultSetAfterUpdate = statement.executeQuery(selectQuery);
	             
	                while (resultSetAfterUpdate.next()) {
	                    System.out.println(resultSetAfterUpdate.getInt(1) + " " + resultSetAfterUpdate.getString(2) + " " + resultSetAfterUpdate.getInt(3));
	                }

	                // Delete data
	                System.out.println("Delete");
	                statement.executeUpdate(deleteQuery);

	                // Read data after delete
	                ResultSet resultSetAfterDelete = statement.executeQuery(selectQuery);
	                
	                while (resultSetAfterDelete.next()) {
	                    System.out.println(resultSetAfterDelete.getInt(1) + " " + resultSetAfterDelete.getString(2));
	                }

	                // Insert data
	                System.out.println("Insert ");
	                statement.executeUpdate(insertQuery);
	             // Read data after insert
	                ResultSet resultSetAfterinsert= statement.executeQuery(selectQuery);
	               
	                while (resultSetAfterinsert.next()) {
	                    System.out.println(resultSetAfterinsert.getInt(1) + " " + resultSetAfterinsert.getString(2)+ " " + resultSetAfterinsert.getString(3));
	                }


	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	    private static Properties loadProperties(String fileName) throws IOException {
	        try (FileReader fileReader = new FileReader(fileName)) {
	            Properties properties = new Properties();
	            properties.load(fileReader);
	            return properties;
	        }
	    }
	}
