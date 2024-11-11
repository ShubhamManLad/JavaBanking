import Models.Account;
import Models.Transaction;
import Models.User;
import Services.DisplayServices;
import Services.UserServices;

import java.util.Scanner;

import static Services.DisplayServices.displayAccountsMenu;
import static Services.DisplayServices.displayMainMenu;

public class Application {
    public static void loadHomePage(UserServices userService, User currentUser){
        displayMainMenu();

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        switch (option){
            case 1:
                currentUser = loadLogInPage(userService);
                loadUserPage(userService, currentUser);
                break;
            case 2:
                currentUser = loadSignUpPage(userService);
                loadUserPage(userService, currentUser);
                break;
            default:
                loadHomePage(userService, currentUser);
                break;
        }

    }

    public static User loadLogInPage(UserServices userService){
        Scanner sc = new Scanner(System.in);

        System.out.println("Login User");

        System.out.print("Enter your UserName: ");
        String username = sc.next();

        System.out.print("Enter your Password: ");
        String password = sc.next();

        User currentUser = userService.loginUser(username, password);
        if(currentUser == null){
            System.out.println("Invalid Credentials, Try Again");
            currentUser = loadLogInPage(userService);
            return currentUser;
        }

        System.out.println("Logged In Successfully \nWelcome "+currentUser.getName());

        return currentUser;

    }

    public static User loadSignUpPage(UserServices userService){

        Scanner sc = new Scanner(System.in);

        System.out.println("Create new User");

        System.out.print("Enter your Name: ");
        String name = sc.next();

        String userName;
        do{
            System.out.print("Create UserName: ");
            userName = sc.next();
        }while(!userService.validateUserName(userName));

        System.out.print("Create Password: ");
        String password = sc.next();

        User currentUser = userService.createUser(new User(name, userName, password));

        System.out.println("Logged In Successfully \nWelcome "+currentUser.getName());

        return currentUser;
    }

    public static void loadUserPage(UserServices userService, User currentUser){
        Scanner sc = new Scanner(System.in);
        String keyBoardInput = "";

        while(true){
            DisplayServices.displayUserMenu();
            keyBoardInput = sc.next();
            switch (keyBoardInput){
                case "1":
                    // Create an account
                    currentUser = addAccountPage(userService, currentUser);
                    break;
                case "2":
                    // Show accounts
                    currentUser = showAccountsPage(userService, currentUser);
                    break;
                case "3":
                    // Logout
                    currentUser = null;
                    loadHomePage(userService, currentUser);
                    break;
                case "Exit":
                    System.out.println("Exiting Application");
                default:
                    break;
            }

        }
    }

    public static User addAccountPage(UserServices userService, User currentUser){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating new account");

        System.out.print("Enter deposit amount: ");
        int deposit = sc.nextInt();

        System.out.print("Enter 1 for Savings account, 2 for Checking account: ");
        int type = sc.nextInt();
        boolean isSavings = (type == 1)? true: false;

        Account account = new Account(currentUser.getUserName(), isSavings, deposit);
        currentUser.addAccount(account);

        System.out.println("New Account: "+account.getAccountNumber()+" created");

        return currentUser;

    }

    public static User showAccountsPage(UserServices userService, User currentUser){
        System.out.println("Enter the Sr. No. of account you want to select");
        int i = 1;
        System.out.println("Sr. No.     Account ID      Current Balance     Account Type");
        for(Account account: currentUser.getAccounts()){
            System.out.println(i++ +"          "+account.getAccountNumber()+"       "+ account.getBalance()+"            "+ (account.isSavings()?"Savings":"Current"));
        }
        Scanner sc = new Scanner(System.in);
        int acc = sc.nextInt();
        i = 1;
        Account currentAccount = new Account();
        for(Account account: currentUser.getAccounts()){
            if(i==acc){
                currentAccount = account;
                break;
            }
            i++;
        }

        accountsOptionsPage(userService, currentUser, currentAccount);

        return currentUser;
    }

    public static User accountsOptionsPage(UserServices userService, User currentUser, Account account){
        System.out.println("Selected Account : " + account.getAccountNumber());
        System.out.println("Available Balance : "+ account.getBalance());

        displayAccountsMenu();

        Scanner sc = new Scanner(System.in);
        int keyBoardInput = sc.nextInt();

        int amount = 0;
        Transaction transaction;

        switch (keyBoardInput){
            case 1:
                // Deposit
                System.out.print("Enter amount to be deposited: ");
                amount = sc.nextInt();
                transaction = new Transaction(account.getAccountNumber(), amount, "23/07/2024", true);
                account.executeTransaction(transaction);
                break;
            case 2:
                // Withdraw
                System.out.print("Enter amount to be withdrawn: ");
                amount = sc.nextInt();
                transaction = new Transaction(account.getAccountNumber(), amount, "23/07/2024", false);
                account.executeTransaction(transaction);
                break;
            case 3:
                // Transaction History
                System.out.println(account.getTransactions().size());
                for(Transaction t: account.getTransactions()){
                    System.out.println(t);
                }
                break;
            default:
//                loadHomePage(userService);
                break;
        }


        return currentUser;
    }
}
