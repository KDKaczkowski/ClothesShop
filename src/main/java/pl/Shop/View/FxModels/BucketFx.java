package pl.Shop.View.FxModels;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import pl.Shop.Database.Models.BucketDetails;

import java.math.BigDecimal;

public class BucketFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private BooleanProperty isActive = new SimpleBooleanProperty();
    private ObjectProperty<BigDecimal> summaryPrice = new SimpleObjectProperty<>();
    private ListProperty<BucketDetails> bucketDetails = new SimpleListProperty<>();

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

    public ObservableList<BucketDetails> getBucketDetails() {
        return bucketDetails.get();
    }

    public ListProperty<BucketDetails> bucketDetailsProperty() {
        return bucketDetails;
    }

    public void setBucketDetails(ObservableList<BucketDetails> bucketDetails) {
        this.bucketDetails.set(bucketDetails);
    }
}
