package pl.Shop.Database.Dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Bucket;
import pl.Shop.Database.Models.BucketDetails;

import java.util.ArrayList;
import java.util.List;

public class BucketDetailsDao {

    private int createNewBcuketDetails(){
        BucketDetails bucketDetails = new BucketDetails();
        int id = -1;
        Transaction transaction = null;
        try(Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            id = (int) session.save(bucketDetails);
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

    private List< BucketDetails > getAllBucketsDetails(){
        List< BucketDetails > bucketDetails = new ArrayList<>();
        try(Session session = Util.getSessionFactory().openSession()){
            bucketDetails = session.createQuery("from BucketDetails", BucketDetails.class).list();
            session.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return bucketDetails;
    }

    private List< BucketDetails > getBucketsDetailsForBucket(Bucket bucket){
        return new ArrayList<>();
    }
}
