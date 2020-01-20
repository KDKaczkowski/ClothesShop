package pl.Shop.View.FxModels;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import pl.Shop.Database.Models.Basket;

import java.math.BigDecimal;

/**
 * Klasa odpowiedzialna za tworzenia obiektów  w JavaFX na podstawie modelu
 * Dotyczy uzytkownika
 */
public class UserFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private ObjectProperty<BigDecimal> balance = new SimpleObjectProperty<>();
    private BooleanProperty admin = new SimpleBooleanProperty();
    private BooleanProperty logged = new SimpleBooleanProperty();
    private ListProperty<Basket> baskets = new SimpleListProperty<>();

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

    public BigDecimal getBalance() {
        return balance.get();
    }

    public ObjectProperty<BigDecimal> balanceProperty() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance.set(balance);
    }

    public boolean getAdmin() {
        return admin.get();
    }

    public BooleanProperty adminProperty() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin.set(admin);
    }

    public boolean getLogged() {
        return logged.get();
    }

    public BooleanProperty loggedProperty() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged.set(logged);
    }

    public ObservableList<Basket> getBaskets() {
        return baskets.get();
    }

    public ListProperty<Basket> basketsProperty() {
        return baskets;
    }

    public void setBaskets(ObservableList<Basket> baskets) {
        this.baskets.set(baskets);
    }
}
