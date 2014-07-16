package dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Matrix on 16.07.2014.
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;
    private String vehicleName;

    @ManyToMany(mappedBy = "vehicle")
    private Collection<UserDetails> users = new ArrayList<>();

    public Collection<UserDetails> getUser() {
        return users;
    }

    public void setUser(Collection<UserDetails> users) {
        this.users = users;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
