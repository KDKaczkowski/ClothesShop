package pl.Shop.Database.Models;

import javax.persistence.*;

@Entity
@Table(name = "Type")
public class Type {

    @Id
    @Column(name = "name")
    private String name;

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
