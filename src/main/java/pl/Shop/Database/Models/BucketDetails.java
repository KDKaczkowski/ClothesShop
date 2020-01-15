package pl.Shop.Database.Models;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "BucketDetails")
public class BucketDetails {

    public BucketDetails() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    @NotNull
    private int amountBought;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bucket_id")
    private Bucket bucket;


    @ManyToOne(optional = false)
    @JoinColumn(name = "cloth_id")
    private Cloth cloth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountBought() {
        return amountBought;
    }

    public void setAmountBought(int amountBought) {
        this.amountBought = amountBought;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }
}
