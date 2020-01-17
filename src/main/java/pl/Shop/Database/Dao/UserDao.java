package pl.Shop.Database.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.Shop.Database.HibernateUtil.Util;
import pl.Shop.Database.Models.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public void createNewUser(String name, String password, boolean isAdmin, BigDecimal balance){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setAdmin(isAdmin);
        user.setLogged(false);
        user.setBalance(balance);

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateUserBalance(String name, BigDecimal balance){
        Transaction transaction = null;
       balance =  balance.add( getUserBalance(name) );
        try(Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.createQuery("UPDATE User U SET U.balance = :balance WHERE  U.name = :name")
                    .setParameter("balance", balance)
                    .setParameter("name", name)
                    .executeUpdate();
            transaction.commit();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void updateUserLoginStatus(String name, boolean value){
        Transaction transaction = null;
        try(Session session = Util.getSessionFactory().openSession() ){
            transaction = session.beginTransaction();
            session.createQuery("UPDATE User U set U.logged = :value WHERE  U.name = :name")
                    .setParameter("value", value)
                    .setParameter("name", name)
                    .executeUpdate();

            transaction.commit();

            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void updateUserAdminAttribute(String name, boolean isAdmin){
        try(Session session = Util.getSessionFactory().openSession()){
            session.createQuery("UPDATE User set admin = :isAdmin where  name = :name")
                    .setParameter("isAdmin", isAdmin)
                    .setParameter("name", name)
                    .executeUpdate();

            session.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updateUserPassword(String name){

    }

    public User getUserByName(String name){
        User user = new User();
        try (Session session = Util.getSessionFactory().openSession()) {
            user = (User) session.createQuery("from User E WHERE E.name = :name", User.class)
                    .setParameter("name", name)
                    .list().get(0);
            session.close();
        } catch (IndexOutOfBoundsException e) {

            user = null;
        }
        return user;
    }

    public User getLoggedUser(){
        User user = new User();
        try(Session session = Util.getSessionFactory().openSession() ){
            user = session.createQuery("FROM User WHERE logged = true", User.class)
                    .list().get(0);
            session.close();
        } catch (IndexOutOfBoundsException e){
            user = null;
        }
        return  user;
    }
    public BigDecimal getUserBalance(String name){
        User user = getUserByName(name);
        return user.getBalance();

    }

    public void printAllUsers(){
        StringBuilder output = new StringBuilder();
        try (Session session = Util.getSessionFactory().openSession()) {
            List< User > students = session.createQuery("from User", User.class).list();
            students.forEach(s -> output.append(
                            "Name: " + s.getName() + "\n"
                            + "Password: " + s.getPassword() + "\n"
                            + "Is admin: " + s.getAdmin() + "\n"
                            + "Is logged in: " + s.getLogged() + "\n"
                            + "Balance: " + s.getBalance() + "\n"
                            + "-----------------------------" + "\n"
                        ));
            System.out.println(output.toString());
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List< User > getAllUsers(){
        List< User > users = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            users = session.createQuery("from User", User.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

}
