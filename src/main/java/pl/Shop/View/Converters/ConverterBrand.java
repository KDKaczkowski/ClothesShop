package pl.Shop.View.Converters;

import pl.Shop.Database.Models.Brand;
import pl.Shop.View.FxModels.BrandFx;

/**
 * Klasa przetrzymujaca funkcje konwertujace obiekty JavaFX na obiekty Java i odwrotnie.
 * Dotyczy marki ubrania
 */
public class ConverterBrand {

    /**
     * funkcja konwertujaca klase z JavyFX do klasy Javy
     * @return
     */
    public static Brand convertToBrand(BrandFx brandFx){
        Brand brand = new Brand();
        brand.setName( brandFx.getName() );

        return brand;
    }

    /**
     * funkcja konwertujaca klase z Javy do klasy JavyFx
     * @return
     */
    public static BrandFx convertToBrandFx(Brand brand){
        BrandFx brandFx = new BrandFx();
        brandFx.setName( brand.getName() );

        return brandFx;
    }
}
