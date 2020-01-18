package pl.Shop.Database.Dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Basket;
import pl.Shop.Database.Models.BasketDetails;

import java.util.ArrayList;
import java.util.List;

public class BasketDetailsDao {

    private int createNewBcuketDetails(){
        BasketDetails basketDetails = new BasketDetails();
        int id = -1;
        Transaction transaction = null;
        try(Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            id = (int) session.save(basketDetails);
            transaction.commit();
            session.close();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return id;
    }

    private List<BasketDetails> getAllBucketsDetails(){
        List<BasketDetails> basketDetails = new ArrayList<>();
        try(Session session = Util.getSessionFactory().openSession()){
            basketDetails = session.createQuery("from BasketDetails", BasketDetails.class).list();
            session.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return basketDetails;
    }

    private List<BasketDetails> getBucketsDetailsForBucket(Basket basket){
        return new ArrayList<>();
    }
}
