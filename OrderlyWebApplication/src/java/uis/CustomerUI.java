package uis;

import dtos.CustomerDTO;
import java.util.ArrayList;
import managers.CustomerManager;

public class CustomerUI {
  final private CustomerManager cusMngr = new CustomerManager();
  
  public CustomerDTO addCustomer(CustomerDTO cus) 
  {
    if (cusMngr.registerCustomer(cus)) 
    {
      return cusMngr.findCustomer(cus.getId(), cus.getFirstName(), cus.getLastName(), cus.getEmailAddress(), cus.getPassword(), cus.getAddress(), cus.getCity(), cus.getPostcode());
    }
    
    return null;
  }
  
  public ArrayList<CustomerDTO> findAllCustomers()
  {
    return cusMngr.findAllCustomers();
  }
  
  public void deleteCustomer(int id)
  {
    cusMngr.removeCustomer(id);
  }
}
