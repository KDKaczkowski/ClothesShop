package pl.Shop.Controllers;

import javafx.fxml.FXML;
import pl.Shop.App;

import java.io.IOException;

public class TopMenuController {
    @FXML
    public void switchToLogin() throws IOException {
        App.setRoot("loginPage");
    }

    @FXML
    public void switchToAccount() throws IOException {
        App.setRoot("accountPage");
    }
}
