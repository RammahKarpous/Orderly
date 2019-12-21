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
      return storeMngr.findStore(store.getId(), store.getStoreName(), store.getLogoImage(), store.getAddress(), store.getCity(), store.getPostcode());
    }
    
    return null;
  }
}
