package pl.Shop.Database.Models;
import com.sun.istack.NotNull;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.*;
import java.math.BigDecimal;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

/**
 * klasa tworzaca model uzytkownika w programie, wykorzystywany do tworzenia bazy danych
 */
@Entity
@Table(name = "User")
public class User {
    public User() {
    }

    public User(String name) {
        this.name = name;
    }


    /**
     * nazwa uzykownika
     */
    @Id
    @Column(name = "name")
    @NotNull
    private String name;

    /**
     * haslo uzytkownika
     */
    @Column(name = "pasword")
    @NotNull
    private String password;
    /**
     * wartosc czy jest adminem uzytkownik
     */
    @Column(name = "admin")
    @NotNull
    private boolean admin;

    /**
     * czy uzytkownik jest zalogowany
     */
    @Column(name = "logged")
    @NotNull
    private boolean logged;

    /**
     * stan konta uzytkownika
     */
    @Column(name = "balance")
    @NotNull
    private BigDecimal balance;

    /**
     * lista koszykow uzytkownika
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Basket> baskets = new ArrayList<>();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    /**
     * funkcja sprawdzajaca czy dany String jest haslem
     */
    public boolean ifStringIsAPassword(String example) {
        try {
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(example.getBytes());
            example = new String(encrypted);
            // decrypt the text

        }catch(Exception e){
            e.printStackTrace();
        }
        return this.password.equals( example );
    }

    /**
     * funkcja zapisujaca i szyfrujaca haslo
     */
    public void setPassword(String password){
        try {
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(password.getBytes());
            this.password = new String(encrypted);
            // decrypt the text

        }catch (Exception e){
            e.printStackTrace();
        }
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

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(ArrayList<Basket> baskets) {
        this.baskets = baskets;
    }

    public void addBasket(Basket basket){
        this.baskets.add(basket);
    }
}
