package pl.Shop.View.FxModels;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import pl.Shop.Database.Models.Brand;
import pl.Shop.Database.Models.BucketDetails;
import pl.Shop.Database.Models.Size;
import pl.Shop.Database.Models.Type;

import java.math.BigDecimal;

public class ClothFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<Type> type = new SimpleObjectProperty<>();
    private ObjectProperty<Brand> brand = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> price = new SimpleObjectProperty<>();
    private ObjectProperty<Size> size = new SimpleObjectProperty<>();
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

    public BigDecimal getPrice() {
        return price.get();
    }

    public ObjectProperty<BigDecimal> priceProperty() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price.set(price);
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


    public Brand getBrand() {
        return brand.get();
    }

    public ObjectProperty<Brand> brandProperty() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand.set(brand);
    }

    public Size getSize() {
        return size.get();
    }

    public ObjectProperty<Size> sizeProperty() {
        return size;
    }

    public void setSize(Size size) {
        this.size.set(size);
    }

    public Type getType() {
        return type.get();
    }

    public ObjectProperty<Type> typeProperty() {
        return type;
    }

    public void setType(Type type) {
        this.type.set(type);
    }
}
