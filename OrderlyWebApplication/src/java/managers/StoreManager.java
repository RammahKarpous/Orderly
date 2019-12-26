package managers;

import dtos.StoreDTO;
import gateways.StoreGateway;
import java.util.ArrayList;

public class StoreManager {
  private StoreGateway gateway = new StoreGateway();
  
//  public StoreDTO findStore(int id)
//  {
//    return gateway.find(id);
//  }
  
  public StoreDTO findStore(int id, String name, String logoImage, String address, String city, String postcode)
  {
    return gateway.find(id, name, logoImage, address, city, postcode);
  }
  
  public ArrayList<StoreDTO> getStoreDetails()
  {
    return gateway.findAllStores();
  }
  
  public boolean registerStore(StoreDTO customer) 
  {
    return gateway.insert(customer);
  }
}