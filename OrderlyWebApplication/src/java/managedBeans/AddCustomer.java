package managedBeans;

import uis.CustomerUI;
import dtos.CustomerDTO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@Named(value = "addCustomer")
@RequestScoped
public class AddCustomer {

  private CustomerUI customerUI = new CustomerUI();
  
  @Inject
  Customer customer;
  
  private int id;
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String password;
  
  public AddCustomer() { }
  
  public String addCustomer() {
    customer.setCustomerDetails(
      customerUI.addCustomer(
        new CustomerDTO(
          id,
          firstName,
          lastName,
          emailAddress,
          password
        )
      )
    );
    return "userAccount";
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public void setFirstName(String fistName) 
  {
    this.firstName = firstName;
  }
  
  public void setLastName(String lastName) 
  {
    this.lastName = lastName;
  }
  
  public void setEmailAddress(String emailAddress) 
  {
    this.emailAddress = emailAddress;
  }
  
  public void setPassword(String password) 
  {
    this.password = password;
  }
  
  public int getId() {
    return id;
  }
  
  public String getFirstName() 
  {
    return firstName;
  }
  
  public String getLastName() 
  {
    return lastName;
  }
  
  public String getEmailAddress() 
  {
    return emailAddress;
  }
  
  public String getPassword() 
  {
    return password;
  }
}
