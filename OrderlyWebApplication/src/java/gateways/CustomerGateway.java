package gateways;

import dtos.CustomerDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerGateway {
  public CustomerDTO find(String firstName, String lastName, String emailAddress) {
    CustomerDTO cusDetails = null;
    
    try 
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "orderlyUsername", "orderly-password");

      String getDetails = "SELECT * FROM customers";
    } 
    catch(SQLException sqle) 
    {

    }
    
    return cusDetails;
  }
  
  public boolean insert(CustomerDTO customer) 
  {
    boolean customerInserted = false;
    
    try 
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "orderlyUsername", "orderly-password");
      
      PreparedStatement statement = conn.prepareStatement("INSET INTO customers (firstName, lastName, emailAddress, password) VALUES(?, ?, ?, ?)");
      statement.setString(1, customer.getFirstName());
      statement.setString(2, customer.getLastName());
      statement.setString(3, customer.getEmailAddress());
      statement.setString(4, customer.getPassword());
      
      int rows = statement.executeUpdate();
      
      customerInserted = rows == 1;
      
      statement.close();
      conn.close();
    }
    catch (SQLException sqle) 
    {
      
    }
    
    return customerInserted;
  }
}
