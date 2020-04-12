package gateways;

import dtos.CartDTO;
import dtos.CustomerDTO;
import dtos.ProductDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartGateway {
  public boolean add(CartDTO crt)
  {
    boolean contentsAdded = false;
    
    try {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");
      
      PreparedStatement statement = conn.prepareStatement("INSERT INTO cart (id, customerId, productId, quantity, subTotal)");
      
      statement.setInt(1, crt.getId());
      statement.setObject(2, crt.getCustomerId());
      statement.setObject(3, crt.getProductId());
      statement.setInt(4, crt.getQuantity());
      statement.setDouble(5, crt.getSubTotal());
      
      int rows = statement.executeUpdate();
      
      contentsAdded = rows == 1;
      
      statement.close();
      conn.close();
      
    }
    catch(SQLException sqle) {  }
    
    return contentsAdded;
  }
  
  public ArrayList<CartDTO> find(int id, CustomerDTO customerId, ProductDTO productId, int quantity, double subTotal)
  {
    ArrayList<CartDTO> cartContents = new ArrayList<>();
    
    try 
    {
      DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");
      
      String pullCart = "SELECT * FROM cart WHERE customerId = ?";
      
      PreparedStatement statement = conn.prepareStatement(pullCart);
      statement.setObject(1, customerId);
      
      ResultSet result = statement.executeQuery();
      
      while (result.next())
      {
        CartDTO cartContent = new CartDTO(
          result.getInt("id"),
          new CustomerDTO(result.getInt("customerId"), result.getString("fistName"), result.getString("lastName"), result.getString("emailAddress"), result.getString("password"), result.getString("address"), result.getString("city"), result.getString("postcode")),
          new ProductDTO(result.getInt("productId"), result.getInt("storeId"), result.getString("productName"), result.getString("imageName"), result.getInt("quantity"), result.getDouble("price")),
          result.getInt("quantity"),
          result.getDouble("subTotal")
        );
        cartContents.add(cartContent);
      }
      
      result.close();
      statement.close();
      conn.close();
    }
    
    catch(SQLException sqle) {  }
    
    return cartContents;
  }
}
