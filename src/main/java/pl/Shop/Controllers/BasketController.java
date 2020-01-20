package pl.Shop.Controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import pl.Shop.App;
import pl.Shop.Database.Dao.UserDao;
import pl.Shop.Database.Models.Basket;
import pl.Shop.Database.Models.Cloth;
import pl.Shop.View.FxModels.*;

import java.io.IOException;
import java.math.BigDecimal;

public class BasketController {

    @FXML
    private TableView basketTableView;
    @FXML
    private TableColumn<BasketDetailsFx, Number> clothIdColumn;
    @FXML
    private TableColumn<BasketDetailsFx, String> typeColumn;
    @FXML
    private TableColumn<BasketDetailsFx, String> brandColumn;
    @FXML
    private TableColumn<BasketDetailsFx, Number> quantityColumn;
    @FXML
    private TableColumn<BasketDetailsFx, BigDecimal> priceColumn;

    @FXML
    private Label txtToPay ;
    @FXML
    private Label txtBalance;

    private ListBasketsModel listBasketsModel;
    @FXML
    private void initialize(){
        UserDao userDao = new UserDao();
        Basket basket = userDao.getActiveBasketOfLoggedUser();
        BigDecimal pay = new BigDecimal("0.00");
        if(basket != null ) {
            pay = basket.getSummaryPrice();
        }
        BigDecimal balance = userDao.getLoggedUser().getBalance();
        txtBalance.setText( balance.toString() );
        txtToPay.setText( pay.toString() );
        if(pay.compareTo(balance) > 0){
            txtToPay.setTextFill(Color.RED);
            txtBalance.setTextFill(Color.RED);
        } else {
            txtToPay.setTextFill(Color.GREEN);
            txtBalance.setTextFill(Color.GREEN);
        }
        this.listBasketsModel = new ListBasketsModel();
        this.listBasketsModel.init();

        this.basketTableView.setItems( listBasketsModel.getBasketDetailsFxObservableList() );
        this.clothIdColumn.setCellValueFactory(s -> new SimpleIntegerProperty(s.getValue().getId()));
        this.typeColumn.setCellValueFactory(s-> new SimpleStringProperty( s.getValue().getCloth().getType().getName() ));
        this.brandColumn.setCellValueFactory(s -> new SimpleStringProperty( s.getValue().getCloth().getBrand().getName() ));
        this.quantityColumn.setCellValueFactory(s -> new SimpleIntegerProperty( s.getValue().getAmountBought() ));
        this.priceColumn.setCellValueFactory(s -> s.getValue().costProperty());

    }


    @FXML
    public void payForClothes() {
        UserDao userDao = new UserDao();
        System.out.println(userDao.payForClothes() + "---------------------------------------------------");
        initialize();

    }

    public void switchToMain(ActionEvent actionEvent) throws IOException {
        App.setRoot("mainPage");
    }
}
