package pl.Shop.View.Converters;

import pl.Shop.Database.Models.BasketDetails;
import pl.Shop.View.FxModels.BasketDetailsFx;

/**
 * Klasa przetrzymujaca funkcje konwertujace obiekty JavaFX na obiekty Java i odwrotnie.
 * Dotyczy pojedynczego zamowienia w koszyku
 */
public class ConverterBasketDetails {
    /**
     * funkcja konwertujaca klase z JavyFX do klasy Javy
     * @return
     */
    public static BasketDetails convertToBasketDetails(BasketDetailsFx basketDetailsFx){
        BasketDetails basketDetails = new BasketDetails();
        basketDetails.setId( basketDetailsFx.getId() );
        basketDetails.setAmountBought( basketDetailsFx.getAmountBought() );
        basketDetails.setCost( basketDetailsFx.getCost());
        basketDetails.setCloth( basketDetailsFx.getCloth() );
        basketDetails.setBasket( basketDetailsFx.getBasket());

        return basketDetails;
    }

    /**
     * funkcja konwertujaca klase z Javy do klasy JavyFx
     * @return
     */
    public static BasketDetailsFx convertToBasketDetailsFx(BasketDetails basketDetails){
        BasketDetailsFx basketDetailsFx = new BasketDetailsFx();
        basketDetailsFx.setId( basketDetails.getId() );
        basketDetailsFx.setAmountBought( basketDetails.getAmountBought());
        basketDetailsFx.setCost( basketDetails.getCost() );
        basketDetailsFx.setCloth( basketDetails.getCloth());
        basketDetailsFx.setBasket( basketDetails.getBasket());

        return basketDetailsFx;
    }
}
