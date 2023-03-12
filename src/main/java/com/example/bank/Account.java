package com.example.bank;

public class Account {
String name;
String address;
String account_number;

Logs logs;
float credit;
 public Account(String n,String add,String account_num,Logs log,float cre)
 {
     name=n;
     address=add;
     account_number=account_num;
     logs=log;
     credit=cre;

 }
    public Account(String n,String add,String account_num,float cre)
    {
        name=n;
        address=add;
        account_number=account_num;
        logs=new Logs();
        credit=cre;

    }
    public String getAccountLog()
    {
        String val="";
        val+=name+" "+address+" "+account_number+" credit: "+credit;
        return val;
    }
    public Account() {
       
        logs = new Logs();
       

    }
        public void makeTransaction(float amount,String description)
 {

 }
 public void makeTransfer(float amount, Account toAccountHolder,String description)
 {

 }
    public void setName(String name) {
        this.name = name;
    }

    public void setAddrrss(String addrrss) {
        this.address = addrrss;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public void setLogs(Logs logs) {
        this.logs = logs;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public String getAddrrss() {
        return address;
    }

    public String getAccount_number() {
        return account_number;
    }

    public Logs getLogs(){return logs;
        }
    public void deduct(float amount)
    {
       credit-=amount;
    }
    public void add(float amount)
    {
         credit+=amount;
    }

    public float getCredit() {
        return credit;
    }
    //support funnction to see output on terminal and not on gui
    public void Print()
    {

    }
    public boolean Authenticate(String username,String acc)
    {
        return true;
    }
    //support funnction to see output on terminal and not on gui
    public void ViewLogs()
    {


    }
}
