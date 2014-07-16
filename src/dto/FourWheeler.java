package dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Matrix on 16.07.2014.
 */

@Entity
public class FourWheeler extends Vehicle {
    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
