import dto.Address;
import dto.UserDetails;
import dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Matrix on 15.07.2014.
 */
public class HibernateTest {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUsername("First User");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Jeep");

        user.getVehicle().add(vehicle);
        user.getVehicle().add(vehicle2);

        vehicle.getUser().add(user);
        vehicle2.getUser().add(user);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();

        factory.close();

    }
}
