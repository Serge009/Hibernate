package dto;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Matrix on 15.07.2014.
 */
@Entity(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String username;

    @ElementCollection
    @CollectionTable(name = "Addresses", joinColumns = { @JoinColumn(name = "user")})
    private Collection<Address> addresses = new HashSet<>();

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> listOfAddresses) {
        this.addresses = listOfAddresses;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", listOfAddresses=" + addresses +
                '}';
    }
}
