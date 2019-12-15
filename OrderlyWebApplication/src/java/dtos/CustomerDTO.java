package dtos;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
  
  private final int id;
  private final String firstName;
  private final String lastName;
  private final String emailAddress;
  private final String password;
  
  
  public CustomerDTO( int id, String firstName, String lastName, String emailAddress, String password ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.password = password;
  }
  
  public int getId() {
    return id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public String getEmailAddress() {
    return emailAddress;
  }
  
  public String getPassword() {
    return password;
  }
}
