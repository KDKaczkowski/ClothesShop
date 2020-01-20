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

public class LoginController {

    @FXML
    public PasswordField txtPassword;
    @FXML
    public TextField txtUsername;
    @FXML
    public Label loginStatus;

    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("registerPage");
    }

    @FXML
    private void login() throws IOException, NoSuchAlgorithmException {
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
