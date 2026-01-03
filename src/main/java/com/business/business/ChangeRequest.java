package com.business.business;

public class ChangeRequest {
    private Double price;
    private String priceCurrency;
    private Double given;
    private String givenCurrency;
    private String changeCurrency;

    public ChangeRequest() {}

    public ChangeRequest(Double price, String priceCurrency,
                         Double given, String givenCurrency,
                         String changeCurrency) {
        this.price = price;
        this.priceCurrency = priceCurrency;
        this.given = given;
        this.givenCurrency = givenCurrency;
        this.changeCurrency = changeCurrency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public Double getGiven() {
        return given;
    }

    public void setGiven(Double given) {
        this.given = given;
    }

    public String getGivenCurrency() {
        return givenCurrency;
    }

    public void setGivenCurrency(String givenCurrency) {
        this.givenCurrency = givenCurrency;
    }

    public String getChangeCurrency() {
        return changeCurrency;
    }

    public void setChangeCurrency(String changeCurrency) {
        this.changeCurrency = changeCurrency;
    }
}
