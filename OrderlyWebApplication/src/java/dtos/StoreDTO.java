package dtos;

import java.io.Serializable;

public class StoreDTO implements Serializable {
  
  private final int id;
  private final String name;
  private final String logoImage;
  private final String address;
  private final String city;
  private final String postcode;
  
  public StoreDTO(int id, String name, String logoImage, String address, String city, String postcode) {
    this.id = id;
    this.name = name;
    this.logoImage = logoImage;
    this.address = address;
    this.city = city;
    this.postcode = postcode;
  }
  
}
