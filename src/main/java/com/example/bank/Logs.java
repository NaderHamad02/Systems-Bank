package com.example.bank;

import java.util.ArrayList;
import java.util.List;

public class Logs {
    BinarySearchTree logs;
    static int transferValue=10;
    static int loanValue=1000;
    public Logs()
    {
        logs=new BinarySearchTree();
    }
    public void Logs()
    {
        transferValue=10;
        loanValue=1000;
    }
    public void Logs(int tf, int lv)
    {
        transferValue=tf;
        loanValue=lv;
    }
    public void add(int key,String log)
    {
        System.out.println("log"+log);
         if(key==1)
         {

             //logs.add(log);
             logs.insert(transferValue,log);
             transferValue+=1;

         }
         else if(key==2)
         {
             //logs.add(log);
             logs.insert(loanValue,log);
             loanValue+=1;
         }
    }
    public int returnKey(int key)
    {
        if(key==1)
        {
            System.out.println("tffyfyt");
            System.out.println(transferValue);


            return  transferValue-1;

        }
        else if(key==2)
        {
            System.out.println("loan");
            System.out.println(loanValue);

            return loanValue-1;
        }
        return 0;
    }
    public ArrayList<String> getLogs()
    {
        return logs.inorderArray();
        //return logs.inorderArray();
    }
}
