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
      return cusMngr.findCustomer(cus.getFirstName(), cus.getLastName(), cus.getEmailAddress());
    }
    
    return null;
  }
}
