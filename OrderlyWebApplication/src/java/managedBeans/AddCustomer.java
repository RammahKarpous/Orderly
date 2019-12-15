/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rammah
 */
@Named(value = "addCustomer")
@RequestScoped
public class AddCustomer {

  /**
   * Creates a new instance of AddCustomer
   */
  public AddCustomer() {
  }
  
}
