package pl.Shop.View.FxModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.Shop.Database.Dao.*;
import pl.Shop.Database.Models.*;
import pl.Shop.View.Converters.ConverterBasketDetails;
import pl.Shop.View.Converters.ConverterBrand;
import pl.Shop.View.Converters.ConverterCloth;
import pl.Shop.View.Converters.ConverterType;

import java.util.List;

public class ListBasketsModel {

    private ObservableList<BasketDetailsFx> basketDetailsFxObservableList = FXCollections.observableArrayList();

    public void init(){
        initBasketDetailsFx();
        /*initTypeFx();
        initBrandFx();
        initClothFx();*/
    }

    /*public void initClothFx(){
        ClothDao clothDao = new ClothDao();
        List<Cloth> cloths = clothDao.getAllClothes();
        cloths.forEach(s -> this.clothFxObservableList.add(ConverterCloth.convertToClothFx( s )));
    }

    public void initTypeFx(){
        TypeDao typeDao = new TypeDao();
        List<Type> types = typeDao.getAllTypes();
        types.forEach(s -> this.typeFxObservableList.add(ConverterType.convertToTypeFx( s )));
    }

    public void initBrandFx(){
        BrandDao brandDao = new BrandDao();
        List<Brand> brands = brandDao.getAllBrands();
        brands.forEach(s -> this.brandFxObservableList.add(ConverterBrand.convertToBrandFx( s )));
    }*/

    public void initBasketDetailsFx(){
        BasketDetailsDao basketDetailsDao = new BasketDetailsDao();
        UserDao userDao = new UserDao();
        Basket basket = userDao.getActiveBasketOfLoggedUser();
        List<BasketDetails> basketDetails = basketDetailsDao.getBasketsDetailsForBucket(basket);
        basketDetails.forEach(s -> this.basketDetailsFxObservableList.add(ConverterBasketDetails.convertToBasketDetailsFx( s )));
    }

    public ObservableList<BasketDetailsFx> getBasketDetailsFxObservableList() {
        return basketDetailsFxObservableList;
    }

    public void setBasketDetailsFxObservableList(ObservableList<BasketDetailsFx> basketDetailsFxObservableList) {
        this.basketDetailsFxObservableList = basketDetailsFxObservableList;
    }

    public void deleteBasketDetail(BasketDetailsFx basketDetailsFx){
        BasketDetailsDao basketDetailsDao = new BasketDetailsDao();
        basketDetailsDao.deleteBasketDetail( ConverterBasketDetails.convertToBasketDetails( basketDetailsFx));
    }
}
