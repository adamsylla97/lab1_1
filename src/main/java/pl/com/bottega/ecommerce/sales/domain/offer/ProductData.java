package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;
import java.util.Objects;

public class ProductData {

    private String id;
    private Money price;
    private String name;
    private Date snapshotDate;
    private String type;

    public ProductData(String id, Money price, String name, Date snapshotDate, String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSnapshotDate(Date snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ProductData other = (ProductData) obj;
        return Objects.equals(id, other.getId())
               && Objects.equals(price, other.getPrice())
               && Objects.equals(name, other.getName())
               && Objects.equals(snapshotDate, other.getSnapshotDate())
               && Objects.equals(type, other.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name, snapshotDate, type);
    }
}
