package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


       /* String hql = "Delete from Address Where id = :addressId";
        session.createQuery(hql)
                        .setParameter("addressId",1)
                        .executeUpdate();*/

        /*String hql = "Update Address set road = :road where id = :addressId";
        session.createQuery(hql)
                        .setParameter("addressId",1)
                        .setParameter("road", "Beach Road")
                        .executeUpdate();*/

        /*Query query = session.createQuery("select Cid,name from Customer where Cid= ?1");
        query.setParameter(1,"1");

        List<Object[]> customerList = query.list();

        for (Object[] customer : customerList) {
            System.out.println("Customer ID: " + customer[0] + ", Name: " + customer[1]);
        }*/

        /*Query query = session.createQuery("SELECT Cid,name FROM Customer");
        List<Object[]> customerList = query.list();

        for (Object[] customer : customerList) {
            System.out.println("Customer ID: " + customer[0] + ", Name: " + customer[1]);
        }
*/
        //Query query = session.createQuery("select a.aid,a.name from Address a inner join Customer c on a.aid = c.cid");

       /* Query query = session.createQuery("SELECT S.studentId, S.name FROM Student S inner join Address A on S.studentId = A.Id");
        List<Object[]> studentList = query.getResultList();*/

        /*String hql = "SELECT C.Cid, C.name FROM Customer C inner join Address A on C.Cid = A.Cid";
        List<Object[]> customerList = session.createNativeQuery(hql).getResultList();

        System.out.println(customerList);

        for (Object[] customer : customerList) {
            System.out.println("Student ID: " + customer[0] + ", Name: " + customer[1]);
        }*/

        transaction.commit();
        session.close();
    }
}