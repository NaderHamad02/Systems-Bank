package com.example.bank;

import java.util.Date;

public class Transfer {
    float amount;
    String description;
    String date;
    Account account;

    Account toAccount;

    public Transfer(Transfer tf)
    {
        amount=tf.amount;
        description=tf.description;
        date=tf.date;
        account=tf.account;
        toAccount=tf.toAccount;
    }
    public Transfer(float am,String des,String dat)
    {
        amount=am;
        description=des;
        date=dat;
        account=new Account();
        toAccount=new Account();
    }
    public void Print()
    {
        System.out.println("Amount: "+amount);
        System.out.println("Description: "+description);
        System.out.println("Date: "+date);
        System.out.println("Account: ");
        account.Print();
        System.out.println("Sent To: ");
        toAccount.Print();
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public float getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public Account getAccount() {
        return account;
    }

    public Account getToAccount() {
        return toAccount;
    }
    public String getLog()
    {
        String res="";
        res+=date+" "+"From: "+account.account_number+" TO: "+toAccount.account_number+" "+" Transfer amount: "+amount+"\n";
        return res;
    }

}
