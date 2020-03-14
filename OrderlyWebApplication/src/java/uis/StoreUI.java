package uis;

import dtos.StoreDTO;
import java.util.ArrayList;
import managers.StoreManager;

public class StoreUI {
  private final StoreManager storeMngr = new StoreManager();
  
  public StoreDTO addStore(StoreDTO store) 
  {
    if (storeMngr.registerStore(store))
    {
      return storeMngr.findStore(store.getId(), store.getStoreName(), store.getAddress(), store.getCity(), store.getPostcode());
    }
    
    return null;
  }
  
  public ArrayList<StoreDTO> getStoreDetails()
  {
    return storeMngr.getStoreDetails();
  }
  
  public StoreDTO getStoreDetailsById(int id)
  {
    return storeMngr.getStoreDetailsById(id);
  }
  
  public void deleteStore(int id)
  {
    storeMngr.remove(id);
  }
  
  public StoreDTO updateStoreDetails(StoreDTO store)
  {
    return storeMngr.updateStore(store);
  }
}
