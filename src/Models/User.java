package Models;

import java.util.ArrayList;

public class User {

    private String name;


    private String userName;
    private String password;
    private ArrayList <Account> accounts;

    public User(String name, String userName, String password){
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }



}
