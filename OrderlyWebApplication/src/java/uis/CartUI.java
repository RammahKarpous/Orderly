package uis;

import dtos.CartDTO;
import dtos.CustomerDTO;
import java.util.ArrayList;
import managers.CartManager;

public class CartUI {
  
  private CartManager cartMngr = new CartManager();
  
  public ArrayList<CartDTO> addContentsToCart(CartDTO cart)
  {
    if (cartMngr.addToCart(cart))
    {
      return cartMngr.findCartContents(cart.getId(), cart.getCustomerId(), cart.getProductId(), cart.getQuantity(), cart.getSubTotal());
    }
    
    return null;
  }
}
