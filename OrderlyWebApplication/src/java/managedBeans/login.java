package managedBeans;

import database.dbManager;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "login")
@SessionScoped
public class login implements Serializable {

  private int id;
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String password;
  private String address;
  private String city;
  private String postcode;

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

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public boolean isCorrectCredentials() {
    return CorrectCredentials;
  }
  
  private boolean CorrectCredentials = false;

  public login() {  }

  public String checkCredentials()
  {
    CorrectCredentials = false;
    try
    {
      Connection conn = dbManager.getConnection();
      PreparedStatement statement = conn.prepareStatement("SELECT * FROM customers WHERE emailAddress = ?");
      statement.setString(1, emailAddress);
      ResultSet rs = statement.executeQuery();

      CorrectCredentials = rs.next() && rs.getString("password").equals(password);

      rs.close();
      statement.close();
      conn.close();
    }
    catch (Exception e)
    {
      Logger.getLogger(login.class.getName()).log(Level.SEVERE, e.toString());
    }

    if (CorrectCredentials)
    {
      return "/profile?faces-redirect=true";
    }
    else
    {
      clearFields();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Your login credentials are not correct. Try later again"));
      return null;
    }
  }

  private void clearFields() {
    this.emailAddress = "";
    this.password = "";
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  }

  public boolean credentialsAreCorrect() {
    return CorrectCredentials;
  }
}
