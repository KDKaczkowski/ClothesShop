package pl.Shop.View.FxModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.Shop.Database.Dao.*;
import pl.Shop.Database.Models.*;
import pl.Shop.View.Converters.ConverterBasketDetails;


import java.util.List;

/**
 * klasa-model komunikująca zdarzenia na Obiektach JavaFx pojedynczych zamowien w koszyku z Dao
 */
public class ListBasketsModel {

    private ObservableList<BasketDetailsFx> basketDetailsFxObservableList = FXCollections.observableArrayList();

    public void init(){
        initBasketDetailsFx();
    }

    /**
     * inicjalizacja listy zawierajacej wszystkie pojedyncze zmowienia
     */
    public void initBasketDetailsFx(){
        BasketDetailsDao basketDetailsDao = new BasketDetailsDao();
        UserDao userDao = new UserDao();
        Basket basket = userDao.getActiveBasketOfLoggedUser();
        List<BasketDetails> basketDetails = basketDetailsDao.getBasketsDetailsForBucket(basket);
        basketDetails.forEach(s -> this.basketDetailsFxObservableList.add(ConverterBasketDetails.convertToBasketDetailsFx( s )));
    }

    public ObservableList<BasketDetailsFx> getBasketDetailsFxObservableList() {
        return basketDetailsFxObservableList;
    }

    public void setBasketDetailsFxObservableList(ObservableList<BasketDetailsFx> basketDetailsFxObservableList) {
        this.basketDetailsFxObservableList = basketDetailsFxObservableList;
    }

    public void deleteBasketDetail(BasketDetailsFx basketDetailsFx){
        BasketDetailsDao basketDetailsDao = new BasketDetailsDao();
        basketDetailsDao.deleteBasketDetail( ConverterBasketDetails.convertToBasketDetails( basketDetailsFx));
    }
}
