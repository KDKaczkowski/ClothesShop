package pl.Shop.Database.Models;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {
    public User() {
    }

    public User(String name) {
        this.name = name;
    }



    @Id
    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "pasword")
    @NotNull
    private String password;

    @Column(name = "admin")
    @NotNull
    private boolean admin;

    @Column(name = "logged")
    @NotNull
    private boolean logged;

    @Column(name = "balance")
    @NotNull
    private BigDecimal balance;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Bucket> buckets = new ArrayList<>();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Bucket> getBuckets() {
        return buckets;
    }

    public void setBuckets(ArrayList<Bucket> buckets) {
        this.buckets = buckets;
    }
}
