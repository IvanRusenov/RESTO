package com.business.business;

public class ChangeResponse {
    private Double changeAmount;
    private String changeCurrency;
    private String message;
    private boolean success;

    public ChangeResponse() {}

    public ChangeResponse(Double changeAmount, String changeCurrency,
                          String message, boolean success) {
        this.changeAmount = changeAmount;
        this.changeCurrency = changeCurrency;
        this.message = message;
        this.success = success;
    }

    public Double getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(Double changeAmount) {
        this.changeAmount = changeAmount;
    }

    public String getChangeCurrency() {
        return changeCurrency;
    }

    public void setChangeCurrency(String changeCurrency) {
        this.changeCurrency = changeCurrency;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
