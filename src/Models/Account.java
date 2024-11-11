package Models;

import java.util.*;

public class Account {

    private String userName;
    private String accountNumber;
    private boolean isSavings;
    private int balance;
    private ArrayList<Transaction> transactions;

    public Account() {
    }

    public Account (String userName, boolean isSavings, int balance){
        this.userName = userName;
        this.isSavings = isSavings;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.accountNumber = userName+"-"+UUID.randomUUID().toString().substring(0,8);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isSavings() {
        return isSavings;
    }

    public void setSavings(boolean savings) {
        isSavings = savings;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean executeTransaction(Transaction transaction){
        if(transaction.isDeposit()){
            this.balance+=transaction.getAmount();
            this.transactions.add(transaction);
            return true;
        }
        else{
            if(transaction.getAmount()<this.balance){
                this.balance-=transaction.getAmount();
                System.out.println(transaction.getAmount()+" withdrawn");
                System.out.println("New Balance : "+this.balance);
                this.transactions.add(transaction);
                return true;
            }
            else{
                System.out.println("Insufficient Balance");
                return false;
            }
        }
    }

}
