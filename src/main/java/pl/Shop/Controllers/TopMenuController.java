package pl.Shop.Controllers;

import javafx.fxml.FXML;
import pl.Shop.App;
import pl.Shop.Database.Dao.UserDao;

import java.io.IOException;

public class TopMenuController {
    @FXML
    private void logout() throws IOException {
        UserDao userDao = new UserDao();
        userDao.updateUserLoginStatus(
                userDao.getLoggedUser().getName()
                , false
        );
        System.out.println("Logged Out successfully");
        App.setRoot("loginPage");
    }

    @FXML
    public void switchToAccount() throws IOException {
        App.setRoot("accountPage");
    }
}
