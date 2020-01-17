package pl.Shop.View.Converters;

import pl.Shop.Database.Models.Cloth;
import pl.Shop.View.FxModels.ClothFx;

public class ConverterCloth {

    public static Cloth convertToCloth(ClothFx clothFx){
        Cloth cloth = new Cloth();
        cloth.setId( clothFx.getId() );
        cloth.setName( clothFx.getName() );
        cloth.setSize( clothFx.getSize() );
        cloth.setQuantity( clothFx.getQuantity() );
        cloth.setPrice( clothFx.getPrice() );
        cloth.setBrand( clothFx.getBrand() );
        cloth.setType( clothFx.getType() );
        //cloth.setBucketDetails( clothFx.getBucketDetails() );
        return cloth;
    }

    public static ClothFx convertToClothFx(Cloth cloth){
        ClothFx clothFx = new ClothFx();
        clothFx.setId( cloth.getId() );
        clothFx.setName( cloth.getName() );
        clothFx.setSize( cloth.getSize() );
        clothFx.setQuantity( cloth.getQuantity() );
        clothFx.setPrice( cloth.getPrice() );
        clothFx.setBrand( cloth.getBrand() );
        clothFx.setType( cloth.getType() );
        //clothFx.setBucketDetails( cloth.getBucketDetails() );
        return clothFx;
    }
}
