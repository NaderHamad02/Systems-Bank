package com.example.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Bank {
    static Bank bk;
    Admin admin;
    hashtable<String,Account> accounts;

    Queue<Loan> loanQueue;

    ArrayList<Transfer> transfers;

    Account current;
    databaseAccess db;


    public static  Bank getInstance() throws IOException {
        if(bk==null)
        {
            bk=new Bank();
            bk.ReadFile();

        }
        return bk;
    }
    private Bank()
    {
        admin=new Admin();
        admin.setUsername("Admin");
        admin.setPassword("1234");
        accounts=new hashtable<String,Account>();
        transfers=new ArrayList<Transfer>();
        loanQueue = new LinkedList<Loan>();
        db=new databaseAccess();
        current=null;

    }
    public void ReadFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\admin.txt"));
        String line;
        int i=0;
        while ((line = br.readLine()) != null)   //returns a Boolean value
        {
            if(i==0)
            {
                admin.setUsername(line);// use comma as separator
                System.out.println(line);
            i++;
            }
            else {
                admin.setPassword(line);
                System.out.println(line);
            }

        }
        br.close();
        br = new BufferedReader(new FileReader("src\\main\\resources\\transfers.txt"));
        line = br.readLine();

        while ((line = br.readLine()) != null)   //returns a Boolean value
        {
            String[] obj = line.split(",");    // use comma as separator

            Transfer obj1=new Transfer(Float.parseFloat(obj[0]),obj[1],obj[2]);
            transfers.add(obj1);
            transfers.get(transfers.size()-1).Print();

        }
        br.close();

        br = new BufferedReader(new FileReader("src\\main\\resources\\accounts.txt"));
        line = br.readLine();

        while ((line = br.readLine()) != null)   //returns a Boolean value
        {
            String[] obj = line.split(",");    // use comma as separator
            Account obj1=new Account(obj[0],obj[1],obj[2],Float.parseFloat(obj[3]));
            accounts.add(obj1.account_number,obj1);


        }
        br.close();

    }
    public Account SearchAccounts(String username, String account_number)
    {
        Account res = null;
        res=accounts.get(account_number);
        if(res!=null && res.name.equals(username))
        {

            return res;

        }

        return null;
    }
    public Account getAccount( String account_number)
    {
        Account res = null;
        res=accounts.get(account_number);
        if(res!=null )
        {

            return res;

        }

        return null;
    }
    void merge(ArrayList<Transfer> trans, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        ArrayList<Transfer> L = new ArrayList<Transfer>();
        ArrayList<Transfer> R = new ArrayList<Transfer>();
        //int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            Transfer obj = new Transfer(trans.get(l + i));
            L.add(obj);
        }
        for (int j = 0; j < n2; ++j) {
            Transfer obj = new Transfer(trans.get(m+1+j));
            R.add(obj);

        }
            //R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i).amount <= R.get(i).amount) {
                trans.set(k, L.get(i));
                i++;
            }
            else {
                trans.set(k, R.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            trans.set(k,L.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            trans.set(k,R.get(j));
            //arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(ArrayList<Transfer> trans, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(trans, l, m);
            sort(trans, m + 1, r);

            // Merge the sorted halves
            merge(trans, l, m, r);
        }
    }
    public void saveLogs(int acc_id, int key, String log)
    {
        db.setlogs(acc_id,key,log);
        //db.setlogs();
    }

    public ArrayList<String>returnTransactionsList()
    {
        ArrayList<String> result = null;
        return result;
    }
    public ArrayList<String>returnAccountsList()
    {

        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Account> acc=accounts.getValue();
        for(int i=0 ; i<acc.size() ;i++)
        {
            result.add(acc.get(i).getAccountLog());
        }
        return result;

    }
    public void addTransfer(Transfer tf)
    {
        transfers.add(tf);
    }
    public void SortTransfers()
    {
        sort(transfers,0,transfers.size()-1);
    }

}
