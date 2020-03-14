package gateways;

import dtos.StoreDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreGateway {
  public StoreDTO find(int id, String name, String address, String city, String postcode)
  {
    StoreDTO storeDetails = null;
    
    try
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver() );
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");
      
      String getStoreDetails = "SELECT * FROM stores";
      PreparedStatement statement = conn.prepareStatement(getStoreDetails);
      
      ResultSet result = statement.executeQuery();
      
      if (result.next()) 
      {
        storeDetails = new StoreDTO
        (
          result.getInt("id"),
          result.getString("storeName"),
          result.getString("address"),
          result.getString("city"),
          result.getString("postcode")
        );
      }
      
      result.close();
      statement.close();
      conn.close();
    }
    
    catch (SQLException sqle)
    {
      
    }
    
    return storeDetails;
    
  }
  
  public ArrayList<StoreDTO> findAllStores()
  {
    ArrayList<StoreDTO> allStores = new ArrayList<>();
    
    try
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver() );
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");
      
      String getStoreDetails = "SELECT * FROM stores";
      PreparedStatement statement = conn.prepareStatement(getStoreDetails);
      
      ResultSet result = statement.executeQuery();
      
      while (result.next()) 
      {
        StoreDTO storeDetails = new StoreDTO
        (
          result.getInt("id"),
          result.getString("storeName"),
          result.getString("address"),
          result.getString("city"),
          result.getString("postcode")
        );
        allStores.add(storeDetails);
      }
      
      result.close();
      statement.close();
      conn.close();
    }
    
    catch (SQLException sqle)
    {
      
    }
    
    return allStores;
    
  }
  
  public StoreDTO findStoreById(int id) 
  {
    StoreDTO storeDetails = null;

    try {
      DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");

      String getProduct = "SELECT * FROM stores WHERE id = ?";

      PreparedStatement statement = conn.prepareStatement(getProduct);
      statement.setInt(1, id);

      ResultSet result = statement.executeQuery();

      if (result.next()) {
        storeDetails = new StoreDTO(
                result.getInt("id"),
                result.getString("storeName"),
                result.getString("address"),
                result.getString("city"),
                result.getString("postcode")
        );
      }

      result.close();
      statement.close();
      conn.close();
    } catch (SQLException sqle) {
    }

    return storeDetails;
  }
  
  public boolean insert(StoreDTO store)
  {
    boolean storeDetailsInserted = false;
    
    try 
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");
      
      PreparedStatement statement = conn.prepareCall("INSERT INTO stores (storeName, address, city, postcode) VALUES(?, ?, ?, ?)");
      
      statement.setString(1, store.getStoreName());
      statement.setString(2, store.getAddress());
      statement.setString(3, store.getCity());
      statement.setString(4, store.getPostcode());
      
      int rows = statement.executeUpdate();
      
      storeDetailsInserted = rows == 1;
      
      statement.close();
      conn.close();
    }
    
    catch (SQLException sqle)
    {
      
    }
    
    return storeDetailsInserted;
  }
  
  public void delete(int id) {

    try {
      DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");
      
      String deleteProducts = "DELETE FROM products WHERE storeId = ?";
      String deleteProd = "DELETE FROM stores WHERE id = ?";
      
      PreparedStatement statementProducts = conn.prepareStatement(deleteProducts);
      statementProducts.setInt(1, id);
      
      PreparedStatement statementStores = conn.prepareStatement(deleteProd);
      statementStores.setInt(1, id);

      statementProducts.execute();
      statementStores.execute();

      statementStores.close();
      conn.close();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }
  
  public StoreDTO update(StoreDTO store)
  {
    StoreDTO storeDetails = null;
    
    try {
        DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver() );
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");

        PreparedStatement statement = conn.prepareStatement("UPDATE stores SET storeName = ?, address = ?, CITY = ?, city = ?, postcode = ? WHERE id = ?");
        
        statement.setString(1, store.getStoreName());
        statement.setString(2, store.getAddress());
        statement.setString(3, store.getCity());
        statement.setString(4, store.getPostcode());
        statement.setInt(5, store.getId());
        
        statement.executeUpdate();

        statement.close();
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return storeDetails;
  }
}
