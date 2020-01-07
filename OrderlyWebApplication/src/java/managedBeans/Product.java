package managedBeans;

import uis.ProductUI;
import dtos.ProductDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;


@Named(value = "product")
@SessionScoped
public class Product implements Serializable {

  private ProductUI productUI = new ProductUI();
  private ProductDTO productDetails = null;
  private int totalProducts = 0;
  
  public ProductDTO getProductDetails()
  {
    return productDetails;
  }
  
  public void setProductDetails(ProductDTO productDetails)
  {
    this.productDetails = productDetails;
  }
  
  public ProductDTO fetchProductDetails(int id)
  {
    return productUI.getProductDetailsById(id);
  }
  
  public ArrayList<ProductDTO> getAllProducts()
  {
    ArrayList<ProductDTO> productDetails = productUI.getProductDetails();
    totalProducts = productDetails.size();
    return productDetails;
  }
  
  public ArrayList<ProductDTO> getProductsByStoreId()
  {
    ArrayList<ProductDTO> productDetails = productUI.getProductDetails();
    totalProducts = productDetails.size();
    return productDetails;
  }
  
  public String deleteProduct(int id)
  {
    productUI.deleteProduct(id);
    return "products?faces-redirect=true";
  }
}
