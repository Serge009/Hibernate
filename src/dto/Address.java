package dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

/**
 * Created by Matrix on 15.07.2014.
 */

@Embeddable
public class Address {

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

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                '}';
    }
}
