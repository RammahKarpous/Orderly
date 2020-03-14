package managers;

import dtos.CartDTO;
import dtos.CustomerDTO;
import dtos.ProductDTO;
import gateways.CartGateway;
import java.util.ArrayList;

public class CartManager {
  
  private CartGateway gateway = new CartGateway();
  
  public ArrayList<CartDTO> findCartContents(int id, CustomerDTO customerId, ProductDTO productId, int quantity, double subTotal)
  {
    return gateway.find(id, customerId, productId, quantity, subTotal);
  }
  
  public boolean addToCart(CartDTO crt)
  {
    return gateway.add(crt);
  }
}