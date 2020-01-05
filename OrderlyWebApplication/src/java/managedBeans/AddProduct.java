package managedBeans;

import uis.ProductUI;
import dtos.ProductDTO;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "addProduct")
@RequestScoped
public class AddProduct {

  private ProductUI productUI = new ProductUI();
  
  @Inject
  Product product;
  
  private int id;
  private String productName;
  private int quantity = 1;
  private double price = 0.00;
  private String imageName;
  private int storeId;
  
  public AddProduct() {  }
  
  public String addProduct() throws IOException
  {
    product.setProductDetails(
      productUI.addProduct(
        new ProductDTO
        (
          id,
          storeId,
          productName,
          imageName,
          quantity,
          price
        )
      )
    );
    
    return "addProducts";
  }

  public int getId() {
    return id;
  }

  public String getProductName() {
    return productName;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
  }

  public String getImageName() {
    return imageName;
  }

  public int getStoreId() {
    return storeId;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public void setStoreId(int storeId) {
    this.storeId = storeId;
  }
}