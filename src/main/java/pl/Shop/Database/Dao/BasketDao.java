package pl.Shop.Database.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.Basket;
import pl.Shop.Database.Models.Cloth;
import pl.Shop.Database.Models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * klasa odpowiedzialna za komunikacje z baza danych dla zdarzen dotyczacych koszyka
 */
public class BasketDao {

    /**
     * funckaj tworzaca nowy koszyk
     * @return
     */
    public int createNewBasket(){
        UserDao userDao = new UserDao();
        Basket basket = new Basket();
        basket.setUser(userDao.getLoggedUser());
        Transaction transaction = null;
        int ID = -1;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ID = (int) session.save(basket);
            transaction.commit();
            session.close();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return ID;

    }

    /**
     * funkcja uaktualniajaca informacje czy koszyk jest aktywny
     * @param isActive - boolean w zaleznosci czy koszyk ma byc aktywny czy nie
     * @param user - uzykownik ktorego koszyk mamy zaaktualizowac
     */
    public void updateBasketActivity(boolean isActive, User user){
        Transaction transaction = null;
        try(Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.createQuery("UPDATE Basket B SET B.isActive = :active WHERE B.user = :user")
                    .setParameter("active", isActive)
                    .setParameter("user", user)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void updateBasketSummaryPrice(){

    }

    public void updateBasketBucketDetails(){

    }

    /**
     * funkcja dodajaca pojedyncze zamowienie do koszyka
     * @param cloth
     */
    public void addBasketDetails(Cloth cloth){
        BasketDetailsDao basketDetailsDao = new BasketDetailsDao();
        basketDetailsDao.createNewBasketDetails(cloth);

    }

    /**
     * funkcja wypisujaca wszystkie koszyki w konsoli
     */
    public void printAllBaskets(){
        StringBuilder output = new StringBuilder();
        try (Session session = Util.getSessionFactory().openSession()) {
            List< Basket > students = session.createQuery("from Basket ", Basket.class).list();
            students.forEach(s -> output.append(
                    "Id: " + s.getId() + "\n"
                            + "isActive: " + s.isActive() + "\n"
                            + "User name: " + s.getUser().getName() + "\n"
                            + "Summary price: " + s.getSummaryPrice() + "\n"
                            + "-----------------------------" + "\n"
            ));
            System.out.println(output.toString());
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * funkcja zwracajaca liste wszystkich koszykow
     * @return
     */
    private List<Basket> getAllBaskets(){
        List<Basket> baskets = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()){
            baskets = session.createQuery("from Basket", Basket.class).list();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return baskets;
    }

    public List<Basket> getAllBasketsOfUser(User user){
        return new ArrayList<>();
    }

    /**
     * funkcja zwracajaca aktywny koszyk danego uzytkownika
     * @param user - uzykownik ktorego koszyk chcemy zwrocic
     * @return zwraca null jezeli nie ma aktywnego koszyka
     */
    public Basket getActiveBasketOfUser(User user){
        Basket basket = new Basket();
        basket = null;
        try (Session session = Util.getSessionFactory().openSession()){
            basket = session.createQuery("FROM Basket B WHERE B.user = :user AND B.isActive = true", Basket.class)
                    .setParameter("user", user)
                    .list()
                    .get(0);
            session.close();
        } catch (IndexOutOfBoundsException e){
            return null;
        }
        return basket;
    }
}
