package pl.Shop.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import pl.Shop.App;

public class LoginController {

    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("registerPage");
    }

    @FXML
    private void switchToMain() throws IOException{
        App.setRoot("mainPage");
    }
}
