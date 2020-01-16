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

    public void updateUserBalance(String name){

    }

    public void updateUserPassword(String name){

    }

    public User getUserByName(String name){
        User user = new User();
        try (Session session = Util.getSessionFactory().openSession()) {
            Query query = session.createQuery("from User E WHERE E.name = :name", User.class);
            query.setParameter("name", name);
            user = (User) query.list().get(0);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
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
