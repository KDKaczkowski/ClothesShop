package pl.Shop.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.Shop.App;
import pl.Shop.Database.Dao.UserDao;
import pl.Shop.Database.Models.User;
import pl.Shop.View.Converters.ConverterUser;
import pl.Shop.View.FxModels.UserFx;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class AccountController {
    @FXML
    public TableView accountTableView;
    @FXML
    public TableColumn<UserFx, String> nameColumn;
    @FXML
    public TableColumn<UserFx, String> passwordColumn;
    @FXML
    public TableColumn<UserFx, Boolean> adminColumn;
    @FXML
    public TableColumn<UserFx, BigDecimal> balanceColumn;

    @FXML
    private void initialize(){
        ObservableList<UserFx> userFxObservableList = FXCollections.observableArrayList();
        UserDao userDao = new UserDao();
        User user = userDao.getUserByName("Kamil");
        userFxObservableList.add(ConverterUser.convertToUserFx( user ));

        this.accountTableView.setItems( userFxObservableList );
        this.nameColumn.setCellValueFactory(s -> s.getValue().nameProperty());
        this.passwordColumn.setCellValueFactory(s -> s.getValue().passwordProperty());
        this.adminColumn.setCellValueFactory(s -> s.getValue().adminProperty());
        this.balanceColumn.setCellValueFactory(s -> s.getValue().balanceProperty());
    }


    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("loginPage");
    }

    @FXML
    private void switchToMain() throws IOException {
        App.setRoot("mainPage");
    }
}
