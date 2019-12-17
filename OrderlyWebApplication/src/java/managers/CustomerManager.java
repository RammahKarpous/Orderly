package managers;

import dtos.CustomerDTO;
import gateways.CustomerGateway;
import java.util.ArrayList;

public class CustomerManager {
  private CustomerGateway gateway = new CustomerGateway();
  
  public CustomerDTO findCustomer(String firstName, String lastName, String emailAddress) 
  {
    return gateway.find(firstName, lastName, emailAddress);
  }
  
  public boolean registerCustomer(CustomerDTO customer) 
  {
    return gateway.insert(customer);
  }
}
