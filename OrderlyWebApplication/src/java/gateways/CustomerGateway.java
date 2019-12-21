package gateways;

import dtos.CustomerDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerGateway {
  public CustomerDTO find(String firstName, String lastName, String emailAddress) 
  {
    CustomerDTO cusDetails = null;
    
    try 
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver() );
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");

      String getDetails = "SELECT * FROM customers";
      PreparedStatement statement = conn.prepareStatement(getDetails);
      
      ResultSet result = statement.executeQuery();
      
      if (result.next()) 
      {
        cusDetails = new CustomerDTO
        (
          result.getInt("id"),
          result.getString("firstName"),
          result.getString("lastName"),
          result.getString("emailAddress"),
          result.getString("password")
        );
      }
      
      result.close();
      statement.close();
      conn.close();
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
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");
      
      PreparedStatement statement = conn.prepareStatement("INSERT INTO customers (firstName, lastName, emailAddress, password) VALUES(?, ?, ?, ?)");
      
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
