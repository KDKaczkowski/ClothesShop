package pl.Shop.View.Converters;

import pl.Shop.Database.Models.User;
import pl.Shop.View.FxModels.UserFx;


/**
 * Klasa przetrzymujaca funkcje konwertujace obiekty JavaFX na obiekty Java i odwrotnie.
 * Dotyczy uzytkownika
 */
public class ConverterUser {

    /**
     * funkcja konwertujaca klase z JavyFX do klasy Javy
     * @return
     */
    public static User converToUser(UserFx userFx){
        User user = new User();
        user.setName( userFx.getName() );
        //user.setPassword( userFx.getPassword() );
        user.setAdmin( userFx.getAdmin() );
        user.setBalance( userFx.getBalance() );
        user.setLogged( userFx.getLogged() );
        //user.setBaskets( userFx.getBaskets() );

        return user;
    }

    /**
     * funkcja konwertujaca klase z Javy do klasy JavyFx
     * @return
     */
    public static  UserFx convertToUserFx(User user){
        UserFx userFx = new UserFx();
        userFx.setName( user.getName() );
        //userFx.setPassword( user.getPassword() );
        userFx.setAdmin( user.getAdmin() );
        userFx.setBalance( user.getBalance() );
        userFx.setLogged( user.getLogged() );
        //userFx.setBaskets( user.getBaskets() );

        return userFx;
    }
}
