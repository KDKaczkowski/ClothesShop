package pl.Shop.Database.Models;

import javax.persistence.*;

/**
 * klasa tworzaca model typu ubrania w programie, wykorzystywany do tworzenia bazy danych
 */
@Entity
@Table(name = "Type")
public class Type {

    /**
     * nazwa typu ubrania
     */
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
