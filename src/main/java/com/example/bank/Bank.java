package com.example.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Bank {
    static Bank bk;
    Admin admin;
    hashtable accounts;

    Queue<Loan> loanQueue;

    ArrayList<Transfer> transfers;


    public static  Bank getInstance()
    {
        if(bk==null)
        {
            bk=new Bank();

        }
        return bk;
    }
    private Bank()
    {
        admin=new Admin();
        accounts=new hashtable();
        transfers=new ArrayList<Transfer>();
        loanQueue = new Queue<Loan>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Loan> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Loan loan) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Loan> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean offer(Loan loan) {
                return false;
            }

            @Override
            public Loan remove() {
                return null;
            }

            @Override
            public Loan poll() {
                return null;
            }

            @Override
            public Loan element() {
                return null;
            }

            @Override
            public Loan peek() {
                return null;
            }
        };


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

    }
    public boolean SearchAccounts(String username, String account_number)
    {

        return true;
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

    public ArrayList<String>returnTransactionsList()
    {
        ArrayList<String> result = null;
        return result;
    }
    public ArrayList<String>returnAccountsList()
    {

        ArrayList<String> result = null;
        return result;

    }
    public void SortTransfers()
    {
        sort(transfers,0,transfers.size()-1);
    }

}
