package managedBeans;

import uis.CustomerUI;
import dtos.CustomerDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

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
  
  public ArrayList<CustomerDTO> getAllCustomers()
  {
    ArrayList<CustomerDTO> customerDetails = customerUI.findAllCustomers();
    totalCustomers = customerDetails.size();
    return customerDetails;
  }
  
  public String deleteCustomer(int id)
  {
    customerUI.deleteCustomer(id);
    return "/admin/customers";
  }
}