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

//  public String fetchAllStoreDetails(int id)
//  {
//    storeDetails = storeUI.findStoreById(id);
//    return "index";
//  }
  
  public StoreDTO getStoreDetails()
  {
    return storeDetails;
  }
  
  public void setStoreDetails(StoreDTO storeDetails)
  {
    this.storeDetails = storeDetails;
  }
  
  public ArrayList<StoreDTO> getAllStores()
  {
    ArrayList<StoreDTO> storeDetails = storeUI.getStoreDetails();
    totalStores = storeDetails.size();
    return storeDetails;
  }
}
