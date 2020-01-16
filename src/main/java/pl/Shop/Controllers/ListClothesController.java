package pl.Shop.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.Shop.View.FxModels.ClothFx;
import pl.Shop.View.FxModels.ListClothesModel;

import java.math.BigDecimal;

public class ListClothesController {

    @FXML
    public TableView clothesTableView;
    @FXML
    public TableColumn <ClothFx, Number> idColumn;
    @FXML
    public TableColumn <ClothFx, String> nameColumn;
    @FXML
    public TableColumn <ClothFx, String> typeColumn;
    @FXML
    public TableColumn <ClothFx, String> brandColumn;
    @FXML
    public TableColumn <ClothFx, BigDecimal> priceColumn;
    @FXML
    public TableColumn <ClothFx, String> sizeColumn;
    @FXML
    public TableColumn <ClothFx, Number> quantityColumn;

    private ListClothesModel listClothesModel;
    @FXML
    private void initialize(){
        this.listClothesModel = new ListClothesModel();
        this.listClothesModel.init();

        this.clothesTableView.setItems( listClothesModel.getClothFxObservableList() );
        this.idColumn.setCellValueFactory(s -> s.getValue().idProperty());
        this.nameColumn.setCellValueFactory(s -> s.getValue().nameProperty());
        this.typeColumn.setCellValueFactory(s -> s.getValue().typeProperty());
        this.brandColumn.setCellValueFactory(s -> s.getValue().brandProperty());
        this.priceColumn.setCellValueFactory(s -> s.getValue().priceProperty());
        this.sizeColumn.setCellValueFactory(s -> s.getValue().sizeProperty());
        this.quantityColumn.setCellValueFactory(s -> s.getValue().quantityProperty());
    }
}
