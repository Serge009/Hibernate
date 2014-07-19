import dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Matrix on 15.07.2014.
 */
public class HibernateTest {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) {

        //createTestUsers();

        UserDetails user = null;

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        user = (UserDetails) session.get(UserDetails.class, 6);
        user.setUsername("New Name");
        System.out.println(user);
        session.update(user);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();

    }

    public static void createTestUsers(){
        List<UserDetails> users = new ArrayList<>();

        for(int i = 1; i <= 10; i++){
            UserDetails user = new UserDetails("Name #" + i);
            users.add(user);
        }

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for(UserDetails user : users){
            session.save(user);
        }
        session.getTransaction().commit();
        session.close();
    }
}
