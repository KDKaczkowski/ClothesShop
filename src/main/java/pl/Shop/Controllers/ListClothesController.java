package pl.Shop.Controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.Shop.Database.Models.Brand;
import pl.Shop.Database.Models.Size;
import pl.Shop.Database.Models.Type;
import pl.Shop.View.FxModels.ClothFx;
import pl.Shop.View.FxModels.ListClothesModel;

import java.math.BigDecimal;

public class ListClothesController {

    @FXML
    private TableView clothesTableView;
    @FXML
    private TableColumn <ClothFx, Number> idColumn;
    @FXML
    private TableColumn <ClothFx, String> nameColumn;
    @FXML
    private TableColumn <ClothFx, String> typeColumn;
    @FXML
    private TableColumn <ClothFx, String> brandColumn;
    @FXML
    private TableColumn <ClothFx, BigDecimal> priceColumn;
    @FXML
    private TableColumn <ClothFx, Size> sizeColumn;
    @FXML
    private TableColumn <ClothFx, Number> quantityColumn;

    @FXML
    private ComboBox typeComboBox;
    @FXML
    private ComboBox brandComboBox;

    private ListClothesModel listClothesModel;
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
    }

    public void filterOnActionComboBox() {
        this.listClothesModel.filterClothesList();
    }

    public void clearTypeComboBox(ActionEvent actionEvent) {
        this.typeComboBox.getSelectionModel().clearSelection();
    }

    public void clearBrandComboBox(ActionEvent actionEvent) {
        this.brandComboBox.getSelectionModel().clearSelection();
    }
}
