package pl.Shop.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListClothesController {

    @FXML
    public TableView clothesTableView;
    @FXML
    public TableColumn idColumn;
    @FXML
    public TableColumn nameColumn;
    @FXML
    public TableColumn typeColumn;
    @FXML
    public TableColumn brandColumn;
    @FXML
    public TableColumn priceColumn;
    @FXML
    public TableColumn sizeColumn;
    @FXML
    public TableColumn quantityColumn;

    @FXML
    private void initialize(){
        System.out.println("No elo");
    }
}
