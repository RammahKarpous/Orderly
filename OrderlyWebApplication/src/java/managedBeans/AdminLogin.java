package managedBeans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "Alogin")
@SessionScoped
public class AdminLogin implements Serializable {

  private String firstName;
  private String password;
  private boolean CorrectCredentials = false;

  public AdminLogin() {
  }
  
  public String getFirstName() {
    return firstName;
  }

  public String getPassword() {
      return password;
  }

  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public String checkCredentials() {

    if (firstName.equals("ADMIN") && password.equals("ADMIN")) {
      return "adminPanel?faces-redirect=true";
    } else {
      clearFields();
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Your login credentials are not correct! Try again later..."));
      return "adminLogin?faces-redirect=true";
    }
  }

  private void clearFields() {
    this.firstName = "";
    this.password = "";
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
  }

  public boolean credentialsAreCorrect() {
    return CorrectCredentials;
  }
}
