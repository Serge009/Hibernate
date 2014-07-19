import dto.*;
import org.hibernate.Query;
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

        createTestUsers();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from UserDetails where userId > 5");
        List users = query.list();


        session.getTransaction().commit();
        session.close();

        System.out.println("Size of list result = " + users.size());



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
