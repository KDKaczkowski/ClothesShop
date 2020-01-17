package pl.Shop.Database.Models;

import javax.persistence.*;


@Entity
@Table(name = "Brand")
public class Brand {

    @Id
    @Column(name = "name")
    private String name;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
