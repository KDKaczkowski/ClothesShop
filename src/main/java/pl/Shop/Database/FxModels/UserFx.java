package pl.Shop.Database.FxModels;

import javafx.beans.property.*;

import java.math.BigDecimal;

public class UserFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private ObjectProperty<BigDecimal> price = new SimpleObjectProperty<>();
    private BooleanProperty isAdmin = new SimpleBooleanProperty();
    private BooleanProperty isLogged = new SimpleBooleanProperty();

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

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
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

    public boolean isIsAdmin() {
        return isAdmin.get();
    }

    public BooleanProperty isAdminProperty() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin.set(isAdmin);
    }

    public boolean isIsLogged() {
        return isLogged.get();
    }

    public BooleanProperty isLoggedProperty() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged.set(isLogged);
    }
}
