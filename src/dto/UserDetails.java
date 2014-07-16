package dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Matrix on 15.07.2014.
 */
@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String username;

    /*
    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<Vehicle> vehicle = new ArrayList<>();

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public int getUserId() {
        return userId;
    }
    */

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
                '}';
    }
}
