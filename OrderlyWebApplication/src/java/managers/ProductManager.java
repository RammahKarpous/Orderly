package managers;

import dtos.ProductDTO;
import gateways.ProductGateway;
import java.util.ArrayList;

public class ProductManager {
  
  private ProductGateway gateway = new ProductGateway();
  
  public ArrayList<ProductDTO> getProductDetails()
  {
    return gateway.findAllProducts();
  }
  
}
