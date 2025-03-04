package gateways;

import dtos.ProductDTO;
import dtos.StoreDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductGateway {

  // INSERT PROJECT PRODUCTS INTO DATABASE
  public boolean addProduct(ProductDTO product) {
    boolean productDetailsInserted = false;

    try {
      DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");

      PreparedStatement statement = conn.prepareCall("INSERT INTO products (storeId, productName, imageName, quantity, price) VALUES(?, ?, ?, ?, ?)");

      statement.setInt(1, product.getStoreId());
      statement.setString(2, product.getProductName());
      statement.setString(3, product.getImageName());
      statement.setInt(4, product.getQuantity());
      statement.setDouble(5, product.getPrice());

      int rows = statement.executeUpdate();

      productDetailsInserted = rows == 1;

      statement.close();
      conn.close();
    } catch (SQLException sqle) {

    }

    return productDetailsInserted;
  }

  // FIND ALL PRODUCTS
  public ArrayList<ProductDTO> findAllProducts() {
    ArrayList<ProductDTO> allProducts = new ArrayList<>();

    try {
      DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");

      String getProductDetails = "SELECT * FROM products";
      PreparedStatement statement = conn.prepareStatement(getProductDetails);

      ResultSet result = statement.executeQuery();

      while (result.next()) {
        ProductDTO productDetails = new ProductDTO(
                result.getInt("id"),
                result.getInt("storeId"),
                result.getString("productName"),
                result.getString("imageName"),
                result.getInt("quantity"),
                result.getDouble("price")
        );

        allProducts.add(productDetails);
      }

      result.close();
      statement.close();
      conn.close();
    } catch (SQLException sqle) {
    }

    return allProducts;
  }

  // FIND PRODUCTS BY STORE ID
  public ArrayList<ProductDTO> findProductsByStoreId(int id) {
    ArrayList<ProductDTO> allProducts = new ArrayList<>();

    try {
      DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");

      String getProductDetails = "SELECT * FROM products JOIN storeName stores USING stpreId = ?";
      PreparedStatement statement = conn.prepareStatement(getProductDetails);
      statement.setInt(1, id);

      ResultSet result = statement.executeQuery();

      while (result.next()) {
        ProductDTO productDetails = new ProductDTO(
                result.getInt("id"),
                result.getInt("storeId"),
                result.getString("productName"),
                result.getString("imageName"),
                result.getInt("quantity"),
                result.getDouble("price")
        );
        allProducts.add(productDetails);
      }

      result.close();
      statement.close();
      conn.close();
    } catch (SQLException sqle) {
    }

    return allProducts;
  }

  // FIND ONE PRODUCT
  public ProductDTO findProductById(int id) 
  {
    ProductDTO productDetails = null;

    try {
      DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");

      String getProduct = "SELECT * FROM products WHERE id = ?";

      PreparedStatement statement = conn.prepareStatement(getProduct);
      statement.setInt(1, id);

      ResultSet result = statement.executeQuery();

      if (result.next()) {
        productDetails = new ProductDTO(
                result.getInt("id"),
                result.getInt("storeId"),
                result.getString("productName"),
                result.getString("imageName"),
                result.getInt("quantity"),
                result.getDouble("price")
        );
      }

      result.close();
      statement.close();
      conn.close();
    } catch (SQLException sqle) {
    }

    return productDetails;
  }

  public ProductDTO findProduct(int id, int storeId, String productName, String imageName, int quantity, double price) {
    ProductDTO productDetails = null;

    try {
      DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");

      String getProduct = "SELECT * FROM products WHERE id = ?";

      PreparedStatement statement = conn.prepareStatement(getProduct);
      statement.setInt(1, id);

      ResultSet result = statement.executeQuery();

      if (result.next()) {
        productDetails = new ProductDTO(
                result.getInt("id"),
                result.getInt("storeId"),
                result.getString("productName"),
                result.getString("imageName"),
                result.getInt("quantity"),
                result.getDouble("price")
        );
      }

      result.close();
      statement.close();
      conn.close();
    } catch (SQLException sqle) {
    }

    return productDetails;
  }
  
  public void update(ProductDTO product, int id)
  {
    try {
        DriverManager.registerDriver( new org.apache.derby.jdbc.ClientDriver() );
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");

        PreparedStatement statement = conn.prepareStatement("UPDATE products SET productName = ?, imageName = ?, quantity = ?, price = ? WHERE id = ?");
        
        statement.setString(1, product.getProductName());
        statement.setString(2, product.getImageName());
        statement.setInt(3, product.getQuantity());
        statement.setDouble(4, product.getQuantity());
        statement.setInt(5, id);
        
        statement.executeUpdate();

        statement.close();
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

  public void delete(int id) 
  {

    try {
      DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
      Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/orderly_db", "username", "password");

      String deleteProd = "DELETE FROM products WHERE id = ?";
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
