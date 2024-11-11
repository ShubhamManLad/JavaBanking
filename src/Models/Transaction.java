package Models;

public class Transaction {

    private String accountId;
    private int amount;
    private String date;
    private boolean isDeposit;

    public Transaction(String accountId, int amount, String date, boolean isDeposit) {
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
        this.isDeposit = isDeposit;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public void setDeposit(boolean deposit) {
        isDeposit = deposit;
    }

    @Override
    public String toString() {
        return ((this.isDeposit)? "Deposit : $" : "Withdraw : $") + amount + " on " + date;
//        return "Transaction: " + "amount : " + this.amount +
//                ", date='" + this.date + '\'' +
//                ((this.isDeposit)?" Credit":" Debit");
    }
}
