package pl.Shop.Database.Models;

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
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "size")
    private String size;

    @Column(name = "numberOf")
    private int numberof;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(
            name = "clothes_orders",
            joinColumns = {
                    @JoinColumn(name = "cloth_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "order_id")
            }
    )
    Set< Order > projects = new HashSet< Order >();
}
