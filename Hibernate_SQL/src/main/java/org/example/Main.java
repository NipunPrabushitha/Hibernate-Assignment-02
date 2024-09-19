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


        // Insert Query
        /*String sql1 = "INSERT INTO Customer (Cid, name) VALUES (:Cid, :name)";

        session.createNativeQuery(sql1)
                .setParameter("Cid", 1)
                .setParameter("name","Nipun" )
                .executeUpdate();

        String sql2 = "INSERT INTO Address (id,no,road,city,Cid) VALUES (:id, :no, :road, :city,:Cid)";
        session.createNativeQuery(sql2)
                .setParameter("id", 1)
                .setParameter("no", "123")
                .setParameter("road", "Flower Road")
                .setParameter("city", "Panadura")
                .setParameter("Cid", 1)
                .executeUpdate();*/

        // Query


        // Update Query
        /*String sql = "UPDATE Customer SET name = :name WHERE Cid = :Cid";

        session.createNativeQuery(sql)
                .setParameter("name","Nipun" )
                .setParameter("Cid", 1)
                .executeUpdate();*/

        // Delete Query
        /*String sql = "DELETE FROM Customer WHERE Cid = :Cid";

        session.createNativeQuery(sql)
                .setParameter("Cid", 1)
                .executeUpdate();*/
        // Query
       /* String sql = "SELECT * FROM Customer WHERE name = 'Nipun'";
        List<Object[]> resultList = session.createNativeQuery(sql).getResultList();
        for(Object[] row : resultList){
            System.out.println("Cid: " + row[0] + ", Name: " + row[1]);
        }*/


        String sql = "SELECT C.Cid , C.name, A.id FROM Customer C INNER JOIN Address A ON C.Cid = A.Cid";
        List<Object[]> resultList = session.createNativeQuery(sql).getResultList();

        for(Object[] student : resultList){
            System.out.println("Student ID: " + student[0] + ", Name: " + student[1] + ", Address ID: " + student[2]);
        }

        transaction.commit();
        session.close();
    }
}