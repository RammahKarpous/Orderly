package managedBeans;

import uis.StoreUI;
import dtos.StoreDTO;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "addStore")
@RequestScoped
public class AddStore 
{

  private StoreUI storeUI = new StoreUI();
  
  @Inject
  Store store;
  
  private int id;
  private String storeName;
  private String address;
  private String city;
  private String postcode;
  
  public AddStore() { }
  
  public String addStore()
  {
    store.setStoreDetails
    (
      storeUI.addStore
      (
        new StoreDTO 
        (
          id,
          storeName,
          address,
          city,
          postcode
        )
      )
    );
    
    return "stores?faces-redirect=true";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }
}
