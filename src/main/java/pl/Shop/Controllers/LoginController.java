package pl.Shop.Controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.Shop.App;
import pl.Shop.Database.Dao.BasketDao;
import pl.Shop.Database.Dao.UserDao;
import pl.Shop.Database.Models.User;

/**
 * klasa odpowiedzialan za komunikacje widoku loginPage.fxml z baza danych
 */
public class LoginController {

    /**
     * przechowuje wpisane haslo przez uzytkownika
     */
    @FXML
    public PasswordField txtPassword;
    /**
     * przechowuje wpisany login uzykownika
     */
    @FXML
    public TextField txtUsername;
    /**
     * przechowuje status logowania
     */
    @FXML
    public Label loginStatus;

    /**
     * przelaczenie na strone registerPage.fxml
     * @throws IOException
     */
    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("registerPage");
    }

    /**
     * obsluga logowania uzykownika
     * @throws IOException
     */
    @FXML
    private void login() throws IOException{
        UserDao userDao = new UserDao();
        BasketDao basketDao = new BasketDao();
        User user = userDao.getUserByName( txtUsername.getText() );
        if ( user == null ) {
            loginStatus.setText("Login Failed");
        }
        else if(user.ifStringIsAPassword( txtPassword.getText() ) ){

            userDao.updateUserLoginStatus( user.getName(), true);
            userDao.addNewBasket();
            App.setRoot("mainPage");
        } else {
            loginStatus.setText("Login Failed");
        }

    }
}
