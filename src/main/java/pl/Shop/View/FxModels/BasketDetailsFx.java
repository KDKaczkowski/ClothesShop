package pl.Shop.View.FxModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.Shop.Database.Models.Basket;
import pl.Shop.Database.Models.Cloth;

import java.math.BigDecimal;

public class BasketDetailsFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private IntegerProperty amountBought = new SimpleIntegerProperty();
    private ObjectProperty<BigDecimal> summaryPrice = new SimpleObjectProperty<>();
    private ObjectProperty<Cloth> cloth = new SimpleObjectProperty<>();
    private ObjectProperty<Basket> basket = new SimpleObjectProperty<>();



    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getAmountBought() {
        return amountBought.get();
    }

    public IntegerProperty amountBoughtProperty() {
        return amountBought;
    }

    public void setAmountBought(int amountBought) {
        this.amountBought.set(amountBought);
    }

    public BigDecimal getSummaryPrice() {
        return summaryPrice.get();
    }

    public ObjectProperty<BigDecimal> summaryPriceProperty() {
        return summaryPrice;
    }

    public void setSummaryPrice(BigDecimal summaryPrice) {
        this.summaryPrice.set(summaryPrice);
    }

    public Cloth getCloth() {
        return cloth.get();
    }

    public ObjectProperty<Cloth> clothProperty() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth.set(cloth);
    }

    public Basket getBasket() {
        return basket.get();
    }

    public ObjectProperty<Basket> basketProperty() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket.set(basket);
    }

}
