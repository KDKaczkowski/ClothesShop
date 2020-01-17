package pl.Shop.View.FxModels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.Shop.Database.Dao.BrandDao;
import pl.Shop.Database.Dao.ClothDao;
import pl.Shop.Database.Dao.TypeDao;
import pl.Shop.Database.Models.Brand;
import pl.Shop.Database.Models.Cloth;
import pl.Shop.Database.Models.Type;
import pl.Shop.View.Converters.ConverterBrand;
import pl.Shop.View.Converters.ConverterCloth;
import pl.Shop.View.Converters.ConverterType;

import java.util.List;

public class ListClothesModel {

    private ObservableList<ClothFx> clothFxObservableList = FXCollections.observableArrayList();
    private ObservableList<TypeFx> typeFxObservableList = FXCollections.observableArrayList();
    private ObservableList<BrandFx> brandFxObservableList = FXCollections.observableArrayList();

    private ObjectProperty<TypeFx> typeFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<BrandFx> brandFxObjectProperty = new SimpleObjectProperty<>();


    public void init(){
        ClothDao clothDao = new ClothDao();
        List< Cloth > cloths = clothDao.getAllClothes();
        cloths.forEach(s -> this.clothFxObservableList.add(ConverterCloth.convertToClothFx( s )));

        initTypes();
        initBrands();
    }

    private void initTypes() {
        TypeDao typeDao = new TypeDao();
        List<Type> types = typeDao.getAllTypes();
        types.forEach(s -> this.typeFxObservableList.add(ConverterType.convertToTypeFx( s )));
    }

    private void initBrands() {
        BrandDao brandDao = new BrandDao();
        List<Brand> brands = brandDao.getAllBrands();
        brands.forEach(s -> this.brandFxObservableList.add(ConverterBrand.convertToBrandFx( s )));
    }

    public ObservableList<ClothFx> getClothFxObservableList() {
        return clothFxObservableList;
    }

    public void setClothFxObservableList(ObservableList<ClothFx> clothFxObservableList) {
        this.clothFxObservableList = clothFxObservableList;
    }

    public ObservableList<TypeFx> getTypeFxObservableList() {
        return typeFxObservableList;
    }

    public void setTypeFxObservableList(ObservableList<TypeFx> typeFxObservableList) {
        this.typeFxObservableList = typeFxObservableList;
    }

    public ObservableList<BrandFx> getBrandFxObservableList() {
        return brandFxObservableList;
    }

    public void setBrandFxObservableList(ObservableList<BrandFx> brandFxObservableList) {
        this.brandFxObservableList = brandFxObservableList;
    }

    public TypeFx getTypeFxObjectProperty() {
        return typeFxObjectProperty.get();
    }

    public ObjectProperty<TypeFx> typeFxObjectPropertyProperty() {
        return typeFxObjectProperty;
    }

    public void setTypeFxObjectProperty(TypeFx typeFxObjectProperty) {
        this.typeFxObjectProperty.set(typeFxObjectProperty);
    }

    public BrandFx getBrandFxObjectProperty() {
        return brandFxObjectProperty.get();
    }

    public ObjectProperty<BrandFx> brandFxObjectPropertyProperty() {
        return brandFxObjectProperty;
    }

    public void setBrandFxObjectProperty(BrandFx brandFxObjectProperty) {
        this.brandFxObjectProperty.set(brandFxObjectProperty);
    }
}
