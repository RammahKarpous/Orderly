package managers;

import dtos.CustomerDTO;
import gateways.CustomerGateway;
import java.util.ArrayList;

public class CustomerManager {
  private CustomerGateway gateway = new CustomerGateway();
  
  public boolean registerCustomer(CustomerDTO customer) {
    return gateway.insert(customer);
  } 
}
