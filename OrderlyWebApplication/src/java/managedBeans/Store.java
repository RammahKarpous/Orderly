package managedBeans;

import uis.StoreUI;
import dtos.StoreDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "store")
@SessionScoped
public class Store implements Serializable {

  private StoreUI storeDTO = new StoreUI();
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
  
}
