package org.example;


import org.example.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*String jpql = "INSERT INTO Customer (Cid, name) values (:customerId, :name)";
        session.createNativeQuery(jpql)
                .setParameter("customerId", 2)
                .setParameter("name", "Gihan")
                .executeUpdate();*/

       /* String hql = "UPDATE Customer set name = :name where Cid = :customerId";
        session.createQuery(hql)
               .setParameter("name", "Prabushitha")
               .setParameter("customerId", 1)
               .executeUpdate();*/

       /* String hql = "DELETE FROM Customer WHERE Cid = :customerId";
        session.createQuery(hql)
               .setParameter("customerId", 2)
               .executeUpdate();*/

        /*String hql = "SELECT Cid, name FROM Customer WHERE Cid = :customerId";
        Query query = session.createQuery(hql);
        query.setParameter("customerId", 1);
        List<Object[]> customerList = query.list();
        for (Object[] customer : customerList) {
            System.out.println("Customer ID: " + customer[0] + ", Name: " + customer[1]);
        }*/

        String sql = "SELECT C.Cid , C.name, A.id FROM Customer C INNER JOIN Address A ON C.Cid = A.Cid";
        List<Object[]> resultList = session.createNativeQuery(sql).getResultList();
        for(Object[] customer : resultList){
            System.out.println("Customer ID: " + customer[0] + ", Name: " + customer[1] + ", Address ID: " + customer[2]);
        }

        transaction.commit();
        session.close();
    }
}