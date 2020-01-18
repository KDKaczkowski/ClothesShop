package pl.Shop;

import pl.Shop.Database.Dao.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.Shop.Database.Models.Size;

import java.io.IOException;
import java.math.BigDecimal;

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
        ClothDao clothDao = new ClothDao();
        BrandDao brandDao = new BrandDao();
        TypeDao typeDao = new TypeDao();
        BasketDao basketDao = new BasketDao();

        brandDao.createNewBrand("Reserved");
        brandDao.createNewBrand("Cropp");

        typeDao.createNewType("T-shirt");
        typeDao.createNewType("Shorts");

        userDao.createNewUser("Kamil", "123", false, new BigDecimal("9.50") );
        userDao.createNewUser("Aga", "maple", true, new BigDecimal("0.50") );




        //userDao.addNewBasket();


        //basketDao.printAllBaskets();

        clothDao.createNewCloth("slawe", typeDao.getTypeByName("T-shirt"), brandDao.getBrandByName("Reserved"), new BigDecimal(90.00), Size.XL, 70);
        clothDao.createNewCloth("a jak", typeDao.getTypeByName("Shorts"), brandDao.getBrandByName("Cropp"), new BigDecimal(45.00), Size.S, 0);

        userDao.printAllUsers();

        clothDao.printAllClothes();
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