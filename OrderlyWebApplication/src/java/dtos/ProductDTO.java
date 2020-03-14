package dtos;

import java.io.Serializable;
import javax.servlet.http.Part;

public class ProductDTO implements Serializable {

  private int id;
  private int storeId;
  private String productName;
  private String imageName;
  private int quantity;
  private double price;

  public ProductDTO(int id, int storeId, String productName, String imageName, int quantity, double price) {
    this.id = id;
    this.storeId = storeId;
    this.productName = productName;
    this.imageName = imageName;
    this.price = price;
    this.quantity = quantity;
  }

  public ProductDTO(int storeId, String productName, String imageName, int quantity, double price) {
    this.storeId = storeId;
    this.productName = productName;
    this.imageName = imageName;
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

  public String getImageName() {
    return imageName;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
  }
}
