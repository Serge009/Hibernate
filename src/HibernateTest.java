import dto.Address;
import dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Matrix on 15.07.2014.
 */
public class HibernateTest {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserId(1);
        user.setUsername("First User");

        Address addr1 = new Address();
        addr1.setAddressId(1);
        addr1.setCity("City1");

        Address addr2 = new Address();
        addr2.setAddressId(2);
        addr2.setCity("City2");

        user.getAddresses().add(addr1);
        user.getAddresses().add(addr2);

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        user = null;
        session = factory.openSession();
        session.beginTransaction();

        user = (UserDetails)session.get(UserDetails.class, 1);
        session.getTransaction().commit();
        System.out.println(user);
        session.close();
        factory.close();

    }
}
