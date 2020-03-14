package managedBeans;

import uis.ProductUI;
import dtos.ProductDTO;
import dtos.StoreDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@Named(value = "product")
@SessionScoped
public class Product implements Serializable {

  private final ProductUI productUI = new ProductUI();
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
  
  public String fetchProductDetails(int id)
  {
    productDetails = productUI.getProductDetailsById(id);
    return "viewProduct?faces-redirect=true";
  }
  
  public ArrayList<ProductDTO> getAllProducts()
  {
    ArrayList<ProductDTO> productDetails = productUI.getProductDetails();
    totalProducts = productDetails.size();
    return productDetails;
  }
  
  public ArrayList<ProductDTO> getProductsByStoreId(int id)
  {
    ArrayList<ProductDTO> productDetails = productUI.getProductsByStoreId(id);
    totalProducts = productDetails.size();
    return productDetails;
  }
  
  public String deleteProduct(int id)
  {
    productUI.deleteProduct(id);
    return "products?faces-redirect=true";
  }
}
