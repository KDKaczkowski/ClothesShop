package pl.Shop.Controllers;

import javafx.fxml.FXML;
import pl.Shop.App;

import java.io.IOException;

public class AccountController {
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("loginPage");
    }

    @FXML
    private void switchToMain() throws IOException {
        App.setRoot("mainPage");
    }
}
