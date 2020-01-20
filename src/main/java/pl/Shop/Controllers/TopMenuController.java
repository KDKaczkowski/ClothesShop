package pl.Shop.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pl.Shop.App;
import pl.Shop.Database.Dao.UserDao;

import java.io.IOException;

/**
 * klasa odpowiedzialan za komunikacje widoku topMenu.fxml z baza danych
 */
public class TopMenuController {
    /**
     * obsluga wylogowania
     * @throws IOException
     */
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

    /**
     * przelaczenia na widok konta zalogowanego uzytkownika
     * @throws IOException
     */
    @FXML
    private void switchToAccount() throws IOException {
        App.setRoot("accountPage");
    }

    /**
     * przelaczenie na widok koszyka zalogowanego uzytkownika
     * @throws IOException
     */
    @FXML
    private void switchToBasketPage() throws IOException{
        App.setRoot("basketPage");
    }
}
