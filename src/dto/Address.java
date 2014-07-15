package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Matrix on 15.07.2014.
 */

@Entity
public class Address {
    @Id
    private int addressId;

    private String city;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
