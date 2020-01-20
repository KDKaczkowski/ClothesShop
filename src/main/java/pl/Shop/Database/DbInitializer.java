package pl.Shop.Database;

import pl.Shop.Database.Dao.*;
import pl.Shop.Database.Models.Size;

import java.math.BigDecimal;

/**
 * klasa inicjalizujaca dane w bazie danych
 */
public class DbInitializer {
    public  void init(){
        UserDao userDao = new UserDao();
        ClothDao clothDao = new ClothDao();
        BrandDao brandDao = new BrandDao();
        TypeDao typeDao = new TypeDao();
        BasketDao basketDao = new BasketDao();

        brandDao.createNewBrand("Reserved");
        brandDao.createNewBrand("Cropp");
        brandDao.createNewBrand("Adidas");
        brandDao.createNewBrand("House");
        brandDao.createNewBrand("The North Face");
        brandDao.createNewBrand("Nike");

        typeDao.createNewType("T-shirt");
        typeDao.createNewType("Shorts");
        typeDao.createNewType("Longsleeve");


        userDao.createNewUser("Kamil", "123", false, new BigDecimal("9.50") );
        userDao.createNewUser("234", "123", true, new BigDecimal("0.50") );


        clothDao.createNewCloth("X34G", typeDao.getTypeByName("T-shirt"), brandDao.getBrandByName("Reserved"), new BigDecimal(90.00), Size.XL, 70);
        clothDao.createNewCloth("B21124", typeDao.getTypeByName("Shorts"), brandDao.getBrandByName("Adidas"), new BigDecimal(45.00), Size.S, 0);
        clothDao.createNewCloth("asddd", typeDao.getTypeByName("Longsleeve"), brandDao.getBrandByName("The North Face"), new BigDecimal(50.00), Size.L, 23);
        clothDao.createNewCloth("adsadad", typeDao.getTypeByName("T-shirt"), brandDao.getBrandByName("Nike"), new BigDecimal(120.00), Size.M, 21);
    }
}
