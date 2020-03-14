package managedBeans;

import uis.StoreUI;
import dtos.StoreDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@Named(value = "store")
@SessionScoped
public class Store implements Serializable {

  private final StoreUI storeUI = new StoreUI();
  private StoreDTO storeDetails = null;
  private int totalStores = 0;
  
  public StoreDTO getStoreDetails()
  {
    return storeDetails;
  }
  
  public void setStoreDetails(StoreDTO storeDetails)
  {
    this.storeDetails = storeDetails;
  }
  
  public String fetchStoreDetails(int id)
  {
    storeDetails = storeUI.getStoreDetailsById(id);
    return "updateStore?faces-redirect=true";
  }
  
  public ArrayList<StoreDTO> getAllStores()
  {
    ArrayList<StoreDTO> storeDetails = storeUI.getStoreDetails();
    totalStores = storeDetails.size();
    return storeDetails;
  }
  
  public void removeStore(int id)
  {
    storeUI.deleteStore(id);
  }
  
  public String updateStore(StoreDTO store)
  {
    storeDetails = storeUI.updateStoreDetails(store);
    return "stores?faces-redirect=true";
  }
  
  
}
