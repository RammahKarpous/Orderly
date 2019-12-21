package dtos;

import java.io.Serializable;

public class StoreDTO implements Serializable {
  
  private final int id;
  private final String storeName;
  private final String logoImage;
  private final String address;
  private final String city;
  private final String postcode;
  
  public StoreDTO(int id, String storeName, String logoImage, String address, String city, String postcode) {
    this.id = id;
    this.storeName = storeName;
    this.logoImage = logoImage;
    this.address = address;
    this.city = city;
    this.postcode = postcode;
  }
  
  public int getId() {
    return id;
  }
  
  public String getStoreName() {
    return storeName;
  }
  
  public String getLogoImage() {
    return logoImage;
  }
  
  public String getAddress() {
    return address;
  }
  
  public String getCity() {
    return city;
  }
  
  public String getPostcode() {
    return postcode;
  }
}
