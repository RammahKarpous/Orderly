package gateways;

import dtos.ProductDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductGateway {
  
  public ArrayList<ProductDTO> findAllProducts()
  {
    ArrayList<ProductDTO> allProducts = new ArrayList<>();
    
    try 
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver() );
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly-db", "dbUsername", "welkom01");
      
      String getProductDetails = "SELECT * FROM products";
      PreparedStatement statement = conn.prepareStatement(getProductDetails);
      
      ResultSet result = statement.executeQuery();
      
      while (result.next()) 
      {
        ProductDTO productDetails = new ProductDTO
        (
          result.getInt("id"),
          result.getInt("storeId"),
          result.getString("productName"),
          result.getString("productImage"),
          result.getInt("quantity"),
          result.getInt("price")
        );
        allProducts.add(productDetails);
      }
      
      result.close();
      statement.close();
      conn.close();
    }
    catch(SQLException sqle)
    {

    }
    
    return allProducts;
  }
  
}
