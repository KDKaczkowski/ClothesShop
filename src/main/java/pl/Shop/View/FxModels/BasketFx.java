package pl.Shop.View.FxModels;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import pl.Shop.Database.Models.BasketDetails;

import java.math.BigDecimal;

/**
 * Klasa odpowiedzialna za tworzenia obiektów  w JavaFX na podstawie modelu
 * Dotyczy koszyka
 */
public class BasketFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private BooleanProperty isActive = new SimpleBooleanProperty();
    private ObjectProperty<BigDecimal> summaryPrice = new SimpleObjectProperty<>();
    private ListProperty<BasketDetails> basketDetails = new SimpleListProperty<>();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public boolean isIsActive() {
        return isActive.get();
    }

    public BooleanProperty isActiveProperty() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive.set(isActive);
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

    public ObservableList<BasketDetails> getBasketDetails() {
        return basketDetails.get();
    }

    public ListProperty<BasketDetails> basketDetailsProperty() {
        return basketDetails;
    }

    public void setBasketDetails(ObservableList<BasketDetails> basketDetails) {
        this.basketDetails.set(basketDetails);
    }
}
