package managedBeans;

import dtos.ProductDTO;
import uis.ProductUI;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "updateProducts")
@SessionScoped
public class UpdateProducts implements Serializable {

  private int id;
  private int storeId;
  private String productName;
  private String imageName;
  private int quantity;
  private double price;
  private ProductDTO productDTO;
  private ProductUI productUI = new ProductUI();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getStoreId() {
    return storeId;
  }

  public void setStoreId(int storeId) {
    this.storeId = storeId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String updateProduct() {
    productDTO = new ProductDTO(storeId, productName, imageName, quantity, price);
    productUI.updateProduct(productDTO, id);
    return ("/admin/products");
  }

}
