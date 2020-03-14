package managers;

import dtos.CustomerDTO;
import gateways.CustomerGateway;
import java.util.ArrayList;

public class CustomerManager {
  private CustomerGateway gateway = new CustomerGateway();
  
  public CustomerDTO findCustomer(int id, String firstName, String lastName, String emailAddress, String password, String address, String city, String postcode) 
  {
    return gateway.find(id, firstName, lastName, emailAddress, password, address, city, postcode);
  }
  
  public boolean registerCustomer(CustomerDTO customer) 
  {
    return gateway.insert(customer);
  }
  
  public ArrayList<CustomerDTO> findAllCustomers()
  {
    return gateway.getAllCustomers();
  }
  
  public void removeCustomer(int id)
  {
    gateway.delete(id);
  }
}