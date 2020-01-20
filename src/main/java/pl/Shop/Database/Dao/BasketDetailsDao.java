package pl.Shop.Database.Dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Basket;
import pl.Shop.Database.Models.BasketDetails;
import pl.Shop.Database.Models.Cloth;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasketDetailsDao {

    public void createNewBasketDetails(Cloth cloth){

        UserDao userDao = new UserDao();
        Basket basket = userDao.getActiveBasketOfLoggedUser(); // active basket of logged user

        BasketDetails basketDetails = this.checkIfClothAlreadyBought(cloth, basket);
        if(basketDetails == null) {  // IF cloth was already added to cart
            basketDetails = new BasketDetails();
            basketDetails.setBasket(basket);
            if (cloth.getQuantity() > 0) {
                basketDetails.setCloth(cloth);
                basketDetails.setAmountBought(1);
                basketDetails.setCost(cloth.getPrice());

                Transaction transaction = null;
                try(Session session = Util.getSessionFactory().openSession()){
                    transaction = session.beginTransaction();
                    session.save(basketDetails);

                    session.createQuery("UPDATE Cloth C SET C.quantity = C.quantity-1 " +
                            "WHERE  C.id = :id AND C.quantity > 0")
                            .setParameter("id", cloth.getId())
                            .executeUpdate();

                    session.createQuery("update Basket B SET B.summaryPrice = B.summaryPrice + :price WHERE B.id = :id")
                            .setParameter("price", cloth.getPrice())
                            .setParameter("id", basket.getId())
                            .executeUpdate();
                    transaction.commit();
                } catch (Exception e){
                    if(transaction != null){
                        transaction.rollback();
                    }
                    e.printStackTrace();
                }

            }
        }else {       // If cloth wasnt added to cart
            Transaction transaction = null;
            try(Session session = Util.getSessionFactory().openSession()){
                transaction = session.beginTransaction();
                session.createQuery("UPDATE BasketDetails B " +
                        "SET B.amountBought = B.amountBought + 1, B.cost = B.cost + :price " +
                        "WHERE B.id = :id")
                        .setParameter("price", cloth.getPrice())
                        .setParameter("id", basketDetails.getId())
                        .executeUpdate();

                session.createQuery("UPDATE Cloth C SET C.quantity = C.quantity-1 " +
                        "WHERE  C.id = :id AND C.quantity > 0")
                        .setParameter("id", cloth.getId())
                        .executeUpdate();

                session.createQuery("update Basket B SET B.summaryPrice = B.summaryPrice + :price WHERE B.id = :id")
                        .setParameter("price", cloth.getPrice())
                        .setParameter("id", basket.getId())
                        .executeUpdate();
                transaction.commit();
            } catch (Exception e){
                if(transaction != null){
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }

    }

    public List<BasketDetails> getAllBasketsDetails(){
        List<BasketDetails> basketDetails = new ArrayList<>();
        try(Session session = Util.getSessionFactory().openSession()){
            basketDetails = session.createQuery("from BasketDetails", BasketDetails.class).list();
            session.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return basketDetails;
    }
    public BasketDetails checkIfClothAlreadyBought(Cloth cloth, Basket basket){
        List<BasketDetails> basketDetailsList = getBasketsDetailsForBucket(basket);
        for (int i = 0; i < basketDetailsList.size() ; i++) {
            if( basketDetailsList.get(i).getCloth().getName().equals( cloth.getName() ))
                return  basketDetailsList.get(i);
        }
        return null;
    }
    public List<BasketDetails> getBasketsDetailsForBucket(Basket basket){
        List<BasketDetails> basketDetails = new ArrayList<>();
        try(Session session = Util.getSessionFactory().openSession()){
            basketDetails = session.createQuery("from BasketDetails B WHERE B.basket = :basket", BasketDetails.class)
                    .setParameter("basket", basket)
                    .list();
            session.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return basketDetails;
    }

    public void deleteBasketDetail(BasketDetails basketDetails){

        Transaction transaction = null;
        try(Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.createQuery("UPDATE Basket B " +
                    "SET B.summaryPrice = B.summaryPrice - :deletedOrder " +
                    "WHERE B.id = :id")
                    .setParameter("deletedOrder", basketDetails.getCost() )
                    .setParameter("id", basketDetails.getBasket().getId() )
                    .executeUpdate();

            session.createQuery("UPDATE Cloth C " +
                    "SET C.quantity = C.quantity + :amountBought " +
                    "WHERE C.id = :id")
                    .setParameter("amountBought", basketDetails.getAmountBought())
                    .setParameter("id", basketDetails.getCloth().getId())
                    .executeUpdate();

            session.createQuery("DELETE BasketDetails B where B.id = :id")
                    .setParameter("id", basketDetails.getId())
                    .executeUpdate();



            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
