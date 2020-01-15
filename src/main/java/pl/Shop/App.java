package pl.Shop;

import pl.Shop.Database.Dao.UserDao;
import  pl.Shop.Database.HibernateUtil.Util;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.Shop.Database.Models.User;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("loginPage"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        userDao.createNewUser("Kamil", "kanapeczka", false, new BigDecimal("9.50") );
        userDao.createNewUser("Aga", "assaadda", true, new BigDecimal("0.50") );

        userDao.printAllUsers();
        /*User user1 = new User();
        User user2 = new User();

        user1.setName("Kamil");
        user2.setName("Aga");

        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(user1);
            session.save(user2);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = Util.getSessionFactory().openSession()) {
            List< User > students = session.createQuery("from User", User.class).list();
            students.forEach(s -> System.out.println(s.getName()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }*/
        /*User user = new User();
        user.setName("Kamil");
        SessionFactory sessionFactory = buildSessionFactory(User.class);
        Session session = sessionFactory.openSession();
        session.save(user);
        User savedUser = session.get(User.class, 1);
        System.out.println("----------------"+ savedUser.getName());*/

        launch();
        /*System.out.println("----------------"+ savedUser.getName());
        session.close();
        sessionFactory.close();*/
    }

}