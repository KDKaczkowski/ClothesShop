package pl.Shop.View.FxModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.Shop.Database.Models.Basket;
import pl.Shop.Database.Models.Cloth;

import java.math.BigDecimal;

/**
 * Klasa odpowiedzialna za tworzenia obiektów  w JavaFX na podstawie modelu
 * Dotyczy pojedynczego zamówienia w koszyku
 */
public class BasketDetailsFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private IntegerProperty amountBought = new SimpleIntegerProperty();
    private ObjectProperty<BigDecimal> cost = new SimpleObjectProperty<>();
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

    public BigDecimal getCost() {
        return cost.get();
    }

    public ObjectProperty<BigDecimal> costProperty() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost.set(cost);
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
