package managedBeans;

import uis.CustomerUI;
import dtos.CustomerDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "customer")
@SessionScoped
public class Customer implements Serializable {

  private CustomerUI customerUI = new CustomerUI();
  private CustomerDTO customerDetails = null;
  private int totalCustomers = 0;
  
  public CustomerDTO getCustomerDetails() 
  {
    return customerDetails;
  }
  
  public void setCustomerDetails(CustomerDTO customerDetails)
  {
    this.customerDetails = customerDetails;
  }
}