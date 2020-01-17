package pl.Shop.View.Converters;

import pl.Shop.Database.Models.Brand;
import pl.Shop.View.FxModels.BrandFx;

public class ConverterBrand {

    public static Brand convertToBrand(BrandFx brandFx){
        Brand brand = new Brand();
        brand.setName( brandFx.getName() );

        return brand;
    }

    public static BrandFx convertToBrandFx(Brand brand){
        BrandFx brandFx = new BrandFx();
        brandFx.setName( brand.getName() );

        return brandFx;
    }
}
