package pl.Shop.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import pl.Shop.App;

public class RegisterController {

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("loginPage");
    }
}