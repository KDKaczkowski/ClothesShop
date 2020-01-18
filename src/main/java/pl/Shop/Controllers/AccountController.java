package pl.Shop.Controllers;

import antlr.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import pl.Shop.App;
import pl.Shop.Database.Dao.UserDao;
import pl.Shop.Database.Models.User;
import pl.Shop.View.Converters.ConverterUser;
import pl.Shop.View.FxModels.UserFx;

import java.io.IOException;
import java.math.BigDecimal;

public class AccountController {
    @FXML
    private TableView accountTableView;
    @FXML
    private TableColumn<UserFx, String> nameColumn;
    @FXML
    private TableColumn<UserFx, String> passwordColumn;
    @FXML
    private TableColumn<UserFx, Boolean> adminColumn;
    @FXML
    private TableColumn<UserFx, BigDecimal> balanceColumn;

    @FXML
    private TextField txtDeposit;
    @FXML
    private Button depositButton;
    @FXML
    private Label depositStatus;

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
    private void switchToMain() throws IOException {
        App.setRoot("mainPage");
    }

    @FXML
    private void depositMoney() {
        UserDao userDao = new UserDao();
        User user = userDao.getLoggedUser();
        int index = txtDeposit.getText().indexOf(".");
        if(txtDeposit.getText().length() > index +2 && txtDeposit.getText().contains(".") ) {
            try {
                txtDeposit.setText(txtDeposit.getText().substring(0, index + 2));
            } catch(IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
        boolean isNumeric = userDao.isNumeric( txtDeposit.getText());
        if(user == null
                || txtDeposit.getText().isBlank()
                || txtDeposit.getText().contains(" ")
                || txtDeposit.getText().contains(",")
                || !isNumeric )
        {
            depositStatus.setTextFill(Color.RED);
            depositStatus.setText("Deposit Failed");
        } else if( isNumeric ){
            BigDecimal toDeposit = new BigDecimal(txtDeposit.getText());
            userDao.updateUserBalance(user.getName(), toDeposit);
            depositStatus.setTextFill(Color.GREEN);
            depositStatus.setText("Deposit Successfully");
            userDao.printAllUsers();
        }else{
            depositStatus.setTextFill(Color.RED);
            depositStatus.setText("Deposit Failed");
        }
    }

}
