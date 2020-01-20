package pl.Shop.View.FxModels;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Klasa odpowiedzialna za tworzenia obiektów  w JavaFX na podstawie modelu
 * Dotyczy typu ubran
 */
public class TypeFx {

    private StringProperty name = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return name.get();
    }
}
