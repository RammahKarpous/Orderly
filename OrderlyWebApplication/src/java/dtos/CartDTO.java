package dtos;

import java.io.Serializable;

public class CartDTO implements Serializable {
  private final int id;
  private final CustomerDTO customerId;
  private final ProductDTO productId;
  private final int quantity;
  private final double subTotal;
  
  public CartDTO( int id, CustomerDTO customerId, ProductDTO productId, int quantity, double subTotal )
  {
    this.id = id;
    this.customerId = customerId;
    this.productId = productId;
    this.quantity = quantity;
    this.subTotal = subTotal;
  }

  public int getId() {
    return id;
  }

  public CustomerDTO getCustomerId() {
    return customerId;
  }

  public ProductDTO getProductId() {
    return productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getSubTotal() {
    return subTotal;
  }
}