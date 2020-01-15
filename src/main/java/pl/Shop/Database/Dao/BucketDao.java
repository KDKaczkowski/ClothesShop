package pl.Shop.Database.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Bucket;

import java.util.ArrayList;
import java.util.List;

public class BucketDao {

    private int createNewBucket(){
        Bucket bucket = new Bucket();
        int id = -1;
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            id = (int) session.save(bucket);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return id;
    }

    private List<Bucket> getAllBuckets(){
        List<Bucket> buckets = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()){
            buckets = session.createQuery("from Bucket", Bucket.class).list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return buckets;
    }
}
