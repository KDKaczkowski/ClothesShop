package pl.Shop.Database.FxModels;

import javafx.beans.property.*;

import java.math.BigDecimal;

public class BucketFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private BooleanProperty isActive = new SimpleBooleanProperty();
    private ObjectProperty<BigDecimal> summaryPrice = new SimpleObjectProperty<>();

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
}
