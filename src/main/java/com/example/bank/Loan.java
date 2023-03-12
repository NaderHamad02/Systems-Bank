package com.example.bank;

import java.util.Date;

public class Loan {
    float amount;
    String date;
    Account acc;
    String description;

    public Loan(float amount,String description,String date , Account acc)
    {
        this.amount=amount;
        this.description=description;
        this.date=date;
        this.acc=acc;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
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

    public String getDate() {
        return date;
    }

    public Account getAcc() {
        return acc;
    }

    public String getDescription() {
        return description;
    }
    public String getLog()
    {
        String res="";
        res+=date+" "+"By: "+acc.account_number+" "+"Loan Amount Granted: "+amount+"\n";
        return res;
    }
}
