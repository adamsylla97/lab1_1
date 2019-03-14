package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private String cause;
    private Money ammount;

    public Discount(String cause, Money ammount) {
        this.cause = cause;
        this.ammount = ammount;
    }

    public String getCause() {
        return cause;
    }

    public Money getAmmount() {
        return ammount;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setAmmount(Money ammount) {
        this.ammount = ammount;
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
        Discount other = (Discount) obj;
        return Objects.equals(cause, other.getCause())
               && Objects.equals(ammount, other.getAmmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cause, ammount);
    }
}
