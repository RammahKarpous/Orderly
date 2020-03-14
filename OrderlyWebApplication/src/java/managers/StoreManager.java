package managers;

import dtos.StoreDTO;
import gateways.StoreGateway;
import java.util.ArrayList;

public class StoreManager {
  private StoreGateway gateway = new StoreGateway();
  
  public StoreDTO findStore(int id, String name, String address, String city, String postcode)
  {
    return gateway.find(id, name, address, city, postcode);
  }
  
  public ArrayList<StoreDTO> getStoreDetails()
  {
    return gateway.findAllStores();
  }
  
  public boolean registerStore(StoreDTO store) 
  {
    return gateway.insert(store);
  }
  
  public StoreDTO getStoreDetailsById(int id)
  {
    return gateway.findStoreById(id);
  }
  
  public void remove(int id)
  {
     gateway.delete(id);
  }
  
  public StoreDTO updateStore(StoreDTO store)
  {
     return gateway.update(store);
  }
}