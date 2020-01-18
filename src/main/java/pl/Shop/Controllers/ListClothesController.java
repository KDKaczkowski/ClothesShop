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
    public TableColumn <ClothFx, ClothFx> buyClothColumn;

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
        this.buyClothColumn.setCellValueFactory(s -> new SimpleObjectProperty<>(s.getValue()));

        this.buyClothColumn.setCellFactory(s -> new TableCell<ClothFx, ClothFx>(){
            Button button = createBuyClothButton();
            @Override
            protected void updateItem(ClothFx clothFx, boolean b) {
                super.updateItem(clothFx, b);

                if(!b){
                    setGraphic(button);
                }
            }
        });

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
