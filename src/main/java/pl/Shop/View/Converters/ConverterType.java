package pl.Shop.View.Converters;

import pl.Shop.Database.Models.Type;
import pl.Shop.View.FxModels.TypeFx;

public class ConverterType {

    public static Type convertToType(TypeFx typeFx){
        Type type = new Type();
        type.setName( typeFx.getName() );

        return type;
    }

    public static TypeFx convertToTypeFx(Type type){
        TypeFx typeFx = new TypeFx();
        typeFx.setName( type.getName() );

        return typeFx;
    }
}
