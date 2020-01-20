package pl.Shop.Controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.Shop.Database.Dao.BasketDao;
import pl.Shop.Database.Dao.UserDao;
import pl.Shop.Database.Models.Brand;
import pl.Shop.Database.Models.Size;
import pl.Shop.Database.Models.Type;
import pl.Shop.View.FxModels.ClothFx;
import pl.Shop.View.FxModels.ListClothesModel;

import java.math.BigDecimal;


/**
 * klasa odpowiedzialan za komunikacje widoku listClothes.fxml z baza danych
 */
public class ListClothesController {


    /**
     * tablica przechowujaca dane o ubraniach znajdujacych sie w sklepie
     */
    @FXML
    private TableView clothesTableView;
    /**
     * kolumna tablicy przechowujaca id ubran znajdujacych sie w sklepie
     */
    @FXML
    private TableColumn <ClothFx, Number> idColumn;
    /**
     * kolumna tablicy przechowujaca nazwe ubran znajdujacych sie w sklepie
     */
    @FXML
    private TableColumn <ClothFx, String> nameColumn;
    /**
     * kolumna tablicy przechowujaca typ ubran znajdujacych sie w sklepie
     */
    @FXML
    private TableColumn <ClothFx, String> typeColumn;
    /**
     * kolumna tablicy przechowujaca nazwe marki ubran znajdujacych sie w sklepie
     */
    @FXML
    private TableColumn <ClothFx, String> brandColumn;
    /**
     * kolumna tablicy przechowujaca cene ubran znajdujacych sie w sklepie
     */
    @FXML
    private TableColumn <ClothFx, BigDecimal> priceColumn;
    /**
     * kolumna tablicy przechowujaca rozmiar ubran znajdujacych sie w sklepie
     */
    @FXML
    private TableColumn <ClothFx, Size> sizeColumn;
    /**
     * kolumna tablicy przechowujaca ilosc dostepnych ubranw sklepie
     */
    @FXML
    private TableColumn <ClothFx, Number> quantityColumn;
    /**
     * kolumna tablicy przechowujaca przycisk umozliwiajacy dodanie ubrania do koszyka
     */
    @FXML
    public TableColumn <ClothFx, ClothFx> buyClothColumn;

    /**
     * comboBox przechowujacy typy ubran dostepnych w sklepie i umozliwiajacy sortowanie po nich
     */
    @FXML
    private ComboBox typeComboBox;
    /**
     * comboBox przechowujacy nazwy marek dostepnych w sklepie i umozliwiajacy sortowanie po nich
     */
    @FXML
    private ComboBox brandComboBox;

    private ListClothesModel listClothesModel;

    /**
     * funkcja inicjalizujaca widok
     */
    @FXML
    private void initialize(){
        this.listClothesModel = new ListClothesModel();
        this.listClothesModel.init();

        this.typeComboBox.setItems( this.listClothesModel.getTypeFxObservableList() );
        this.brandComboBox.setItems( this.listClothesModel.getBrandFxObservableList() );
        this.listClothesModel.brandFxObjectPropertyProperty().bind(this.brandComboBox.valueProperty());
        this.listClothesModel.typeFxObjectPropertyProperty().bind(this.typeComboBox.valueProperty());

        this.clothesTableView.setItems( listClothesModel.getClothFxObservableList() );
        this.idColumn.setCellValueFactory(s -> s.getValue().idProperty());
        this.nameColumn.setCellValueFactory(s -> s.getValue().nameProperty());
        this.typeColumn.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getType().getName()));
        this.brandColumn.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getBrand().getName()));
        this.priceColumn.setCellValueFactory(s -> s.getValue().priceProperty());
        this.sizeColumn.setCellValueFactory(s -> s.getValue().sizeProperty());
        this.quantityColumn.setCellValueFactory(s -> s.getValue().quantityProperty());
        this.buyClothColumn.setCellValueFactory(s -> new SimpleObjectProperty<>(s.getValue()));

        this.buyClothColumn.setCellFactory(s -> new TableCell<ClothFx, ClothFx>(){
            Button button = createBuyClothButton();
            @Override
            protected void updateItem(ClothFx clothFx, boolean b) {
                super.updateItem(clothFx, b);
                if(b){
                    setGraphic(null);
                    return;

                }
                if(!b){
                    setGraphic(button);
                    button.setOnAction(actionEvent -> {
                        listClothesModel.addToCart(clothFx);
                        refreshList();
                    });
                }
            }
        });




    }

    /**
     * funkcja odswiezajaca widok po dodaniu ubrania do koszyka
     */
    public void refreshList(){
        this.listClothesModel = new ListClothesModel();
        this.listClothesModel.init();
        this.listClothesModel.brandFxObjectPropertyProperty().bind(this.brandComboBox.valueProperty());
        this.listClothesModel.typeFxObjectPropertyProperty().bind(this.typeComboBox.valueProperty());

        this.clothesTableView.setItems( listClothesModel.getClothFxObservableList() );
        this.idColumn.setCellValueFactory(s -> s.getValue().idProperty());
        this.nameColumn.setCellValueFactory(s -> s.getValue().nameProperty());
        this.typeColumn.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getType().getName()));
        this.brandColumn.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getBrand().getName()));
        this.priceColumn.setCellValueFactory(s -> s.getValue().priceProperty());
        this.sizeColumn.setCellValueFactory(s -> s.getValue().sizeProperty());
        this.quantityColumn.setCellValueFactory(s -> s.getValue().quantityProperty());
        this.buyClothColumn.setCellValueFactory(s -> new SimpleObjectProperty<>(s.getValue()));
        filterOnActionComboBox();

    }

    /**
     * funkcja obslugujaca filtrowanie listy po wybraniu opcji w comboBox
     */
    public void filterOnActionComboBox() {
        this.listClothesModel.filterClothesList();
    }

    /**
     * funkcja czyszczaca wczesniejszy wybor uzywkonika w typeComboBox
     */
    public void clearTypeComboBox() {
        this.typeComboBox.getSelectionModel().clearSelection();

    }

    /**
     * funkcja czyszczaca wczesniejszy wybor uzykownika w brandComboBox
     */
    public void clearBrandComboBox() {
        this.brandComboBox.getSelectionModel().clearSelection();
    }

    /**
     * funkcja tworzaca przycisk umozliwiajacy dodawanie ubrania do koszyka
     * @return Button
     */
    private Button createBuyClothButton(){
        Button button = new Button();
        Image image = new Image(this.getClass().getResource("/image/baskett.png").toString());

        ImageView imageView = new ImageView(image);
        imageView.setX(20);
        imageView.setY(20);

        button.setMaxSize(20, 20);
        button.setGraphic(imageView);
        return  button;
    }
}
