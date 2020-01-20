package pl.Shop.Database.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * klasa tworzaca model koszyka w programie, wykorzystywany do tworzenia bazy danych
 */
@Entity
@Table(name = "Basket")
public class Basket {

    /**
     * id uzytkownika
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
     * czy koszyk jest aktywny
     */
    @Column(name = "isActive")
    private boolean isActive;

    /**
     * laczna kwota do zaplaty za koszyk
     */
    @Column(name = "summaryPrice")
    private BigDecimal summaryPrice;

    /**
     * uzytkownik do ktorego koszyk nalezy
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * lista pojedynczych zamowien w koszyku
     */
    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketDetails> basketDetails = new ArrayList<>();

    /*public Basket() {

    }*/

    public Basket(){
        this.isActive = true;
        this.summaryPrice = new BigDecimal(0.00);
    }

    public Basket(boolean isActive, BigDecimal summaryPrice) {
        this.isActive = isActive;
        this.summaryPrice = summaryPrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public BigDecimal getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(BigDecimal summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BasketDetails> getBasketDetails() {
        return basketDetails;
    }

    public void setBasketDetails(List<BasketDetails> basketDetails) {
        this.basketDetails = basketDetails;
    }
}
