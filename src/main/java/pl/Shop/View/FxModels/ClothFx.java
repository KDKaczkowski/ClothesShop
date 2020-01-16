package pl.Shop.View.FxModels;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import pl.Shop.Database.Models.BucketDetails;

import java.math.BigDecimal;

public class ClothFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty type = new SimpleStringProperty();
    private StringProperty brand = new SimpleStringProperty();
    private ObjectProperty<BigDecimal> price = new SimpleObjectProperty<>();
    private StringProperty size = new SimpleStringProperty();
    private IntegerProperty quantity = new SimpleIntegerProperty();
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getBrand() {
        return brand.get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public BigDecimal getPrice() {
        return price.get();
    }

    public ObjectProperty<BigDecimal> priceProperty() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price.set(price);
    }

    public String getSize() {
        return size.get();
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
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
