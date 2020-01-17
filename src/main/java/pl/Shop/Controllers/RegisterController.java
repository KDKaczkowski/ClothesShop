package pl.Shop.Controllers;

import java.io.IOException;
import java.math.BigDecimal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.Shop.App;
import pl.Shop.Database.Dao.UserDao;

public class RegisterController {

    @FXML
    public Label registerStatus;
    @FXML
    public PasswordField txtPassword;
    @FXML
    public TextField txtUsername;

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("loginPage");
    }

    @FXML
    private void registerUser() throws IOException {
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