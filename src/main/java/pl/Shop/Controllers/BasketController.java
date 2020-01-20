package pl.Shop.Controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import pl.Shop.App;
import pl.Shop.Database.Dao.UserDao;
import pl.Shop.Database.Models.Basket;
import pl.Shop.Database.Models.BasketDetails;
import pl.Shop.View.FxModels.*;

import java.io.IOException;
import java.math.BigDecimal;


/**
 * Klasa odpowiedzialna za komunikacje widoku z bazą danych
 */
public class BasketController {


    /**
     * tabela przechowujaca dana o koszyku zalogowanego użykownika
     */
    @FXML
    private TableView basketTableView;
    /**
     * kolumna przechoujaca id ubrania znajdujacego sie w koszyku
     */
    @FXML
    private TableColumn<BasketDetailsFx, Number> clothIdColumn;
    /**
     * kolumna przechowujaca typ ubrania znajdujacego sie w koszyku
     */
    @FXML
    private TableColumn<BasketDetailsFx, String> typeColumn;
    /**
     * kolumna przechowująca nazwe marki ubrania znajdujacego sie w koszyku
     */
    @FXML
    private TableColumn<BasketDetailsFx, String> brandColumn;
    /**
     * kolumna przechowujaca ilosc zakupionych ubran danego typu
     */
    @FXML
    private TableColumn<BasketDetailsFx, Number> quantityColumn;
    /**
     * kolumna przechowujaca informacje o koszcie za dany typ ubrania
     */
    @FXML
    private TableColumn<BasketDetailsFx, BigDecimal> priceColumn;
    /**
     * kolumna przechowujaca przyciski do usuwania z koszyka
     */
    @FXML
    private TableColumn<BasketDetailsFx, BasketDetailsFx> deleteColumn;

    /**
     * label przechowujacy informacje o koszcie calkowitym
     */
    @FXML
    private Label txtToPay ;
    /**
     * label przechowujacy informacje o stanie konta zalogowanego uzytkownika
     */
    @FXML
    private Label txtBalance;

    private ListBasketsModel listBasketsModel;

    /**
     * funkcja inicjalizujaca tablice i labele przy przekierowaniu na te strone
     */
    @FXML
    private void initialize(){
        this.refreshBasketdetails();





    }

    /**
     * funkcja odswiezajaca dane na stronie
     */
    private void refreshBasketdetails(){
        UserDao userDao = new UserDao();
        Basket basket = userDao.getActiveBasketOfLoggedUser();
        BigDecimal pay = new BigDecimal("0.00");

        if( userDao.userHaveActiveBasket() ) {
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
        this.deleteColumn.setCellValueFactory(s -> new SimpleObjectProperty<>(s.getValue()));

        this.deleteColumn.setCellFactory(s -> new TableCell<BasketDetailsFx, BasketDetailsFx>(){
            Button button = createDeleteBasketDetailsButton();

            @Override
            protected void updateItem(BasketDetailsFx basketDetailsFx, boolean b) {
                super.updateItem(basketDetailsFx, b);
                if(!b){
                    setGraphic(button);
                    button.setOnAction(actionEvent -> {
                        listBasketsModel.deleteBasketDetail(basketDetailsFx);
                        refreshBasketdetails();
                    });
                }
            }
        });
    }

    /**
     * funckaj odpowiedzialna za obsluge zakupu ubran znajdujacych sie w koszyku
     */
    @FXML
    public void payForClothes() {
        UserDao userDao = new UserDao();
        System.out.println(userDao.payForClothes() + "---------------------------------------------------");
        initialize();

    }

    /**
     * funkcja przelaczajaca widok na strone mainPage.fxml
     * @throws IOException
     */
    public void switchToMain() throws IOException {
        App.setRoot("mainPage");
    }

    /**
     * funkcja tworzaca przycisk sluzacy do usuwania ubran z koszyka
     * @return Button
     */
    private Button createDeleteBasketDetailsButton(){
        Button button = new Button();
        Image image = new Image(this.getClass().getResource("/image/delete1.png").toString());

        ImageView imageView = new ImageView(image);
        imageView.setX(20);
        imageView.setY(20);

        button.setMaxSize(20, 20);
        button.setGraphic(imageView);
        return  button;
    }
}
