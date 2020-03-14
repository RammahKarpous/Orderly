package gateways;

import dtos.CustomerDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerGateway {
  public CustomerDTO find(int id, String firstName, String lastName, String emailAddress, String password, String address, String city, String postcode) 
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
          result.getString("password"),
          result.getString("address"),
          result.getString("city"),
          result.getString("postcode")
        );
      }
      
      result.close();
      statement.close();
      conn.close();
    } 
    catch(SQLException sqle) {  }
    
    return cusDetails;
  }
  
  public boolean insert(CustomerDTO customer) 
  {
    boolean customerInserted = false;
    
    try 
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");
      
      PreparedStatement statement = conn.prepareStatement("INSERT INTO customers (firstName, lastName, emailAddress, password, address, city, postcode) VALUES(?, ?, ?, ?, ?, ?, ?)");
      
      statement.setString(1, customer.getFirstName());
      statement.setString(2, customer.getLastName());
      statement.setString(3, customer.getEmailAddress());
      statement.setString(4, customer.getPassword());
      statement.setString(5, customer.getAddress());
      statement.setString(6, customer.getCity());
      statement.setString(7, customer.getPostcode());
      
      int rows = statement.executeUpdate();
      
      customerInserted = rows == 1;
      
      statement.close();
      conn.close();
    }
    catch (SQLException sqle) {  }
    
    return customerInserted;
  }
  
  public ArrayList<CustomerDTO> getAllCustomers()
  {
    ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
    
    try 
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");
      
      String selectAll = "SELECT * FROM customers";
      PreparedStatement statement = conn.prepareStatement(selectAll);
      
      ResultSet res = statement.executeQuery();
      
      while (res.next())
      {
        CustomerDTO customerDetails = new CustomerDTO
        (
          res.getInt("id"),
          res.getString("firstName"),
          res.getString("lastName"),
          res.getString("emailAddress"),
          res.getString("password"),
          res.getString("address"),
          res.getString("city"),
          res.getString("postcode")
        );
        
        allCustomers.add(customerDetails);
      }
      
      res.close();
      statement.close();
      conn.close();
      
    }
    
    catch(SQLException sqle) {  }
    
    return allCustomers;
  }
  
  public void delete(int id) 
  {

    try {
      DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");

      String deleteProd = "DELETE FROM customers WHERE id = ?";
      PreparedStatement statement = conn.prepareStatement(deleteProd);
      statement.setInt(1, id);

      statement.execute();

      statement.close();
      conn.close();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }
}
