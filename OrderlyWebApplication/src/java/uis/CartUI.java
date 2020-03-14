package uis;

import dtos.CartDTO;
import dtos.CustomerDTO;
import java.util.ArrayList;
import managers.CartManager;

public class CartUI {
  
  private CartManager cartMngr = new CartManager();
  
  public ArrayList<CartDTO> addContentsToCart(CartDTO crt)
  {
    if (cartMngr.addToCart(crt))
    {
      return cartMngr.findCartContents(crt.getId(), crt.getCustomerId(), crt.getProductId(), crt.getQuantity(), crt.getSubTotal());
    }
    
    return null;
  }
}
