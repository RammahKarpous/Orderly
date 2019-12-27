package dtos;

import java.io.Serializable;

public class ProductDTO implements Serializable {
  
  private final int id;
  private final int storeId;
  private final String productName;
  private final String productImage;
  private final int price;
  private final int quantity;
  
  public ProductDTO(int id, int storeId, String productName, String productImage, int price, int quantity) 
  {
    this.id = id;
    this.storeId = storeId;
    this.productName = productName;
    this.productImage = productImage;
    this.price = price;
    this.quantity = quantity;
  }
  
  public int getId() {
    return id;
  }
  
  public int getStoreId() {
    return storeId;
  }
  
  public String getProductName() {
    return productName;
  }
  
  public String getProductImage() {
    return productImage;
  }
  
  public int getPrice() {
    return price;
  }
  
  public int getQuantity() {
    return quantity;
  }
  
}
