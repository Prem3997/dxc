package com.dxc.client.HibernateMongoDemo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.ogm.cfg.OgmConfiguration;

import com.dxc.model.Customer;
import com.dxc.model.Employee;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        OgmConfiguration cfg=new OgmConfiguration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Employee employee=new Employee(11576749, "Jishnu", "Bangalore", 65000);
        //Customer customer=new Customer(100234, "Jishnu", "HSRLayout", 4500);
        session.save(employee);
        //session.save(customer);
        transaction.commit();
        System.out.println("MongoDb stored the data");

    }
}
