package pl.Shop.View.Converters;

import pl.Shop.Database.Models.Type;
import pl.Shop.View.FxModels.TypeFx;

/**
 * Klasa przetrzymujaca funkcje konwertujace obiekty JavaFX na obiekty Java i odwrotnie.
 * Dotyczy typu ubran
 */
public class ConverterType {

    /**
     * funkcja konwertujaca klase z JavyFX do klasy Javy
     * @return
     */
    public static Type convertToType(TypeFx typeFx){
        Type type = new Type();
        type.setName( typeFx.getName() );

        return type;
    }

    /**
     * funkcja konwertujaca klase z Javy do klasy JavyFx
     * @return
     */
    public static TypeFx convertToTypeFx(Type type){
        TypeFx typeFx = new TypeFx();
        typeFx.setName( type.getName() );

        return typeFx;
    }
}
