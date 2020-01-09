package managedBeans;

import dtos.CustomerDTO;
import dtos.CartDTO;
import uis.CartUI;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@Named(value = "cart")
@SessionScoped
public class Cart implements Serializable {

  private CartUI cartUI = new CartUI();
  private CartDTO cartContents = null;
  private int totalContents = 0;
  
  public CartDTO getCartContents() 
  {
    return cartContents;
  }
  
  public void setCartContents(CartDTO cartContents)
  {
    this.cartContents = cartContents;
  }
  
  public ArrayList<CartDTO> addToCart(CartDTO cart)
  {
    ArrayList<CartDTO> cartContents = cartUI.addContentsToCart(cart);
    totalContents = cartContents.size();
    return cartContents;
  }
}
