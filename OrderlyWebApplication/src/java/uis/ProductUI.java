package uis;

import dtos.ProductDTO;
import java.util.ArrayList;
import managers.ProductManager;

public class ProductUI {
  
  final private ProductManager prodMngr = new ProductManager();
  
  public ArrayList<ProductDTO> getProductDetails()
  {
    return prodMngr.getProductDetails();
  }
  
}
