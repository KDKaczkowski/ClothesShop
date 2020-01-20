package pl.Shop.Controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.Shop.App;
import pl.Shop.Database.Dao.UserDao;
/**
 * klasa odpowiedzialan za komunikacje widoku registerPage.fxml z baza danych
 */
public class RegisterController {

    /**
     * przechowuje statusu rejestracji
     */
    @FXML
    public Label registerStatus;
    /**
     * przechowuje haslo wprowadzone przez uzytkownika
     */
    @FXML
    public PasswordField txtPassword;
    /**
     * przechowuje nazwa uzytkownika wprowadzona przez uzytkownika
     */
    @FXML
    public TextField txtUsername;

    /**
     * przelacza widok na strone logowania
     * @throws IOException
     */
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("loginPage");
    }

    /**
     * obluga rejestracji uzytkownika
     * @throws IOException
     */
    @FXML
    private void registerUser() throws IOException{
        UserDao userDao = new UserDao();
        if
        ( txtPassword.getText().isBlank()                         //Password or username is blank
                || txtUsername.getText().isBlank()
                || txtUsername.getText().contains(" ")            // Password or username contains space
                || txtPassword.getText().contains(" ")
        ){
            registerStatus.setText("Username and Password can not contain spaces or be empty");
        } else if(userDao.getUserByName( txtUsername.getText() ) != null){
            registerStatus.setText("Name is already taken");
        } else {
            userDao.createNewUser( txtUsername.getText(), txtPassword.getText(), false, new BigDecimal(0) );
            App.setRoot("loginPage");
        }

    }
}