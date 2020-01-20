package pl.Shop.View.FxModels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.Shop.Database.Dao.*;
import pl.Shop.Database.Models.*;
import pl.Shop.View.Converters.ConverterBrand;
import pl.Shop.View.Converters.ConverterCloth;
import pl.Shop.View.Converters.ConverterType;

import java.util.List;


/**
 * klasa-model komunikująca zdarzenia na Obiektach JavaFx ubran z Dao
 */
public class ListClothesModel {

    private ObservableList<ClothFx> clothFxObservableList = FXCollections.observableArrayList();
    private ObservableList<TypeFx> typeFxObservableList = FXCollections.observableArrayList();
    private ObservableList<BrandFx> brandFxObservableList = FXCollections.observableArrayList();

    private ObjectProperty<TypeFx> typeFxObjectProperty = new SimpleObjectProperty<>();
    private ObjectProperty<BrandFx> brandFxObjectProperty = new SimpleObjectProperty<>();

    /**
     * inicjalizacja wszystkich list
     */
    public void init(){
        ClothDao clothDao = new ClothDao();
        List< Cloth > cloths = clothDao.getAllClothes();
        cloths.forEach(s -> this.clothFxObservableList.add(ConverterCloth.convertToClothFx( s )));

        initTypes();
        initBrands();
    }

    /**
     * inicjalizacja listy typów ubran
     */
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

    /**
     * funkcja filtrujaca liste ubran
     */
    public void filterClothesList(){
        if(getTypeFxObjectProperty() != null && getBrandFxObjectProperty() != null){ //Filter by type and brand
            filterClothesByTypeAndBrand();
        }
        else if (getTypeFxObjectProperty() != null){ //Filter by type
            filterClothesByType();
        }
        else if (getBrandFxObjectProperty() != null){ // filter by brand
            filterClothesByBrand();
        }
        else{ //No filter
            clothesNoFilter();
        }
    }

    /**
     * funkcja wyswietlajaca lste ubran bez filtra
     */
    private void clothesNoFilter(){
        ClothDao clothDao = new ClothDao();
        List< Cloth > cloths = clothDao.getAllClothes();
        this.clothFxObservableList.clear();
        cloths.forEach(s -> this.clothFxObservableList.add(ConverterCloth.convertToClothFx( s )));
    }

    /**
     * filtrowanie listy po typie
     */
    private void filterClothesByType(){
        ClothDao clothDao = new ClothDao();
        List< Cloth > cloths = clothDao.getClothesOfType( ConverterType.convertToType( getTypeFxObjectProperty() ) );
        this.clothFxObservableList.clear();
        cloths.forEach(s -> this.clothFxObservableList.add(ConverterCloth.convertToClothFx( s )));

    }

    /**
     * filtrowanie listy po marce
     */
    private void filterClothesByBrand(){
        ClothDao clothDao = new ClothDao();
        List< Cloth > cloths = clothDao.getClothesOfBrand( ConverterBrand.convertToBrand( getBrandFxObjectProperty() ) );
        this.clothFxObservableList.clear();
        cloths.forEach(s -> this.clothFxObservableList.add(ConverterCloth.convertToClothFx( s )));
    }

    /**
     * filtrowanie listy po typie i marce
     */
    private void filterClothesByTypeAndBrand(){
        ClothDao clothDao = new ClothDao();
        List< Cloth > cloths = clothDao.getClothesOfTypeAndBrand(
                ConverterType.convertToType( getTypeFxObjectProperty() ),
                ConverterBrand.convertToBrand( getBrandFxObjectProperty() )
                );
        this.clothFxObservableList.clear();
        cloths.forEach(s -> this.clothFxObservableList.add(ConverterCloth.convertToClothFx( s )));
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

    /**
     * funkcja odpowiadajaca za przekazanie zdarzenia dodania do koszyka dalej
     * @param clothFx
     */
    public void addToCart(ClothFx clothFx) {
        UserDao userDao = new UserDao();
        userDao.addClothToBasket( ConverterCloth.convertToCloth(clothFx) );
        BasketDao basketDao = new BasketDao();
        basketDao.printAllBaskets();
    }


}
