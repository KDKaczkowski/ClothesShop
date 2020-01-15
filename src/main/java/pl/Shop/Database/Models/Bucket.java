package pl.Shop.Database.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Bucket")
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "summaryPrice")
    private BigDecimal summaryPrice;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "bucket", cascade = CascadeType.ALL)
    private List<BucketDetails> bucketDetails;

    public Bucket() {
    }

    public Bucket(boolean isActive, BigDecimal summaryPrice) {
        this.isActive = isActive;
        this.summaryPrice = summaryPrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public BigDecimal getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(BigDecimal summaryPrice) {
        this.summaryPrice = summaryPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
