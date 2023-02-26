package com.example.bank;

import java.util.Date;

public class Loan {
    float amount;
    Date date;
    Account acc;
    String description;

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Account getAcc() {
        return acc;
    }

    public String getDescription() {
        return description;
    }
}
