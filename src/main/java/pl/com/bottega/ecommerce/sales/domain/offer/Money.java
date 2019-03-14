package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private BigDecimal value;
    private String currency;

    public Money(BigDecimal value){
        this(value,null);
    }

    public Money(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
        Money other = (Money) obj;
        return Objects.equals(currency, other.getCurrency())
               && Objects.equals(value, other.getValue());
    }
}
