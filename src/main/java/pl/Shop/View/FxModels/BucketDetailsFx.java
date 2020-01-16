package pl.Shop.View.FxModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.Shop.Database.Models.Bucket;
import pl.Shop.Database.Models.Cloth;

import java.math.BigDecimal;

public class BucketDetailsFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private IntegerProperty amountBought = new SimpleIntegerProperty();
    private ObjectProperty<BigDecimal> summaryPrice = new SimpleObjectProperty<>();
    private ObjectProperty<Cloth> cloth = new SimpleObjectProperty<>();
    private ObjectProperty<Bucket> bucket = new SimpleObjectProperty<>();



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

    public Bucket getBucket() {
        return bucket.get();
    }

    public ObjectProperty<Bucket> bucketProperty() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket.set(bucket);
    }

}
