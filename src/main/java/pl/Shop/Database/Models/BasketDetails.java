package pl.Shop.Database.Models;


import
        com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * klasa tworzaca model pojedynczego zamowienia w koszyku w programie, wykorzystywany do tworzenia bazy danych
 */
@Entity
@Table(name = "BasketDetails")
public class BasketDetails {

    public BasketDetails() {
        this.amountBought = 0;
        this.cost = new BigDecimal(0);
    }

    /**
     * id pojedynczego zamowienia
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * ilosc zakupionych ubran
     */
    @Column
    @NotNull
    private int amountBought;

    /**
     * laczna cena pojedynczego zamowienia
     */
    @Column
    private BigDecimal cost;

    /**
     * koszyk w ktorym znajduje sie to pojedyncze zamowienie
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    /**
     * ubranie ktorej zostalo zamowione
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "cloth_id")
    private Cloth cloth;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountBought() {
        return amountBought;
    }

    public void setAmountBought(int amountBought) {
        this.amountBought = amountBought;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
