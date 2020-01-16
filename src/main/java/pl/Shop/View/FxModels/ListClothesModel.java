package pl.Shop.View.FxModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.Shop.Database.Dao.ClothDao;
import pl.Shop.Database.Models.Cloth;
import pl.Shop.View.Converters.ConverterCloth;

import java.util.List;

public class ListClothesModel {

    private ObservableList<ClothFx> clothFxObservableList = FXCollections.observableArrayList();

    public void init(){
        ClothDao clothDao = new ClothDao();
        List< Cloth > cloths = clothDao.getAllClothes();
        cloths.forEach(s -> this.clothFxObservableList.add(ConverterCloth.convertToClothFx( s )));
    }

    public ObservableList<ClothFx> getClothFxObservableList() {
        return clothFxObservableList;
    }

    public void setClothFxObservableList(ObservableList<ClothFx> clothFxObservableList) {
        this.clothFxObservableList = clothFxObservableList;
    }
}
