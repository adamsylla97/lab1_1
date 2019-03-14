package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

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
}
