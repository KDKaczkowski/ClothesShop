package pl.Shop.Database.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Cloth")
public class Cloth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    @NotNull
    private String brand;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "size")
    @NotNull
    private String size;

    @Column(name = "quantity")
    @NotNull
    private int quantity;

    @OneToMany(mappedBy = "cloth", cascade = CascadeType.ALL)
    private List<BucketDetails> bucketDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
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

    public List<BucketDetails> getBucketDetails() {
        return bucketDetails;
    }

    public void setBucketDetails(List<BucketDetails> bucketDetails) {
        this.bucketDetails = bucketDetails;
    }
}
