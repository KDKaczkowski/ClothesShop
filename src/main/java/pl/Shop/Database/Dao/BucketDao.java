package pl.Shop.Database.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Bucket;
import pl.Shop.Database.Models.User;

import java.util.ArrayList;
import java.util.List;

public class BucketDao {

    public int createNewBucket(){
        Bucket bucket = new Bucket();
        Transaction transaction = null;
        int id = -1;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            id = (int) session.save(bucket);
            transaction.commit();
            session.close();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return id;

    }

    public void updateBucketActivity(){

    }

    public void updateBucketSummaryPrice(){

    }

    public void updateBucketBucketDetails(){

    }

    private List<Bucket> getAllBuckets(){
        List<Bucket> buckets = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()){
            buckets = session.createQuery("from Bucket", Bucket.class).list();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return buckets;
    }

    public List<Bucket> getAllBucketsOfUser(User user){
        return new ArrayList<>();
    }

    public Bucket getActiveBucketOfUser(User user){
        return new Bucket();
    }
}
