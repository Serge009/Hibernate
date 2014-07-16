import dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Matrix on 15.07.2014.
 */
public class HibernateTest {
    public static void main(String[] args) {
        UserDetails user = null;

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        user = (UserDetails) session.get(UserDetails.class, 6);
        user.setUsername("New Name");
        System.out.println(user);
        session.update(user);
        session.delete(user);
        session.getTransaction().commit();
        session.close();



    }
}
