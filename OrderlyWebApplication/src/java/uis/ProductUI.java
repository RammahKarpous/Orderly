package uis;

import dtos.ProductDTO;
import dtos.StoreDTO;
import java.io.IOException;
import java.util.ArrayList;
import managers.ProductManager;

public class ProductUI {
  
  final private ProductManager prodMngr = new ProductManager();
  
  public ProductDTO addProduct(ProductDTO product) throws IOException
  {
    if (prodMngr.addProduct(product))
    {
      return prodMngr.findProduct( product.getId(), product.getStoreId(), product.getProductName(), product.getImageName(), product.getQuantity(), product.getPrice(), product);
    }
    
    return null;
  }
  
  public ArrayList<ProductDTO> getProductDetails()
  {
    return prodMngr.getProductDetails();
  }
  
  public ProductDTO getProductDetailsById(int id)
  {
    return prodMngr.getProductDetailsById(id);
  }
  
  public ArrayList<ProductDTO> getProductsByStoreId( StoreDTO storeId)
  {
    return prodMngr.getProductsByStoreId(storeId);
  }
}
