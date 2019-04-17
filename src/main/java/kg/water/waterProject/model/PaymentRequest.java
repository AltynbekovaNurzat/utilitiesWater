package kg.water.waterProject.model;

import java.math.BigDecimal;

public class PaymentRequest {
    private String lchet;
    private BigDecimal amount;

    public PaymentRequest() {
    }

    public PaymentRequest(String lchet, BigDecimal amount) {
        this.lchet = lchet;
        this.amount = amount;
    }

    public String getLchet() {
        return lchet;
    }

    public void setLchet(String lchet) {
        this.lchet = lchet;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
