package pl.Shop.Database.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "clothes_bucket",
            joinColumns = {
                    @JoinColumn(name = "cloth_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "bucket_id")
            }
    )
    Set<Bucket> projects = new HashSet<Bucket>();

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

    public Set<Bucket> getProjects() {
        return projects;
    }

    public void setProjects(Set<Bucket> projects) {
        this.projects = projects;
    }
}
