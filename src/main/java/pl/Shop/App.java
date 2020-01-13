package pl.Shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.Shop.Database.Models.User;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

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
    private static SessionFactory buildSessionFactory(Class clazz){
        return new Configuration()
                .configure()
                .addAnnotatedClass(clazz)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("Kamil");
        SessionFactory sessionFactory = buildSessionFactory(User.class);
        Session session = sessionFactory.openSession();
        session.save(user);
        User savedUser = session.get(User.class, 1);
        System.out.println("----------------"+ savedUser.getName());

        launch();
        System.out.println("----------------"+ savedUser.getName());
        session.close();
        sessionFactory.close();
    }

}