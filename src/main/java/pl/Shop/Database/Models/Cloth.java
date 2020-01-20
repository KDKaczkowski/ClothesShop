package pl.Shop.Database.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * klasa tworzaca model ubrania w programie, wykorzystywany do tworzenia bazy danych
 */
@Entity
@Table(name = "Cloth")
public class Cloth {

    /**
     * id ubrania
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * nazwa ubrania
     */
    @Column(name = "name")
    @NotNull
    private String name;

    /**
     * typ ubrania
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private Type type;

    /**
     * marka ubrania
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    /**
     * cena ubrania
     */
    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    /**
     * rozmiar ubrania
     */
    @Column(name = "size")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Size size;

    /**
     * ilosc dostepnych ubran
     */
    @Column(name = "quantity")
    @NotNull
    private int quantity;

    /**
     * lista pojedynczych zamowien w ktorych jest dane ubranie
     */
    @OneToMany(mappedBy = "cloth", cascade = CascadeType.ALL)
    private List<BasketDetails> basketDetails = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
