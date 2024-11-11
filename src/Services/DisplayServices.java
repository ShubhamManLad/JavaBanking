package Services;

import Models.Account;
import Models.Transaction;
import Models.User;

import java.util.Scanner;

public class DisplayServices {

    public static void displayMainMenu(){
        System.out.println("To login to existing account        : Enter 1");
        System.out.println("To create a new account             : Enter 2");
    }

    public static void displayUserMenu(){
        System.out.println("To create new account       : Enter 1");
        System.out.println("To view existing accounts   : Enter 2");
        System.out.println("To logOut                   : Enter 3");
        System.out.println("To exit application         : Type Exit");
    }

    public static void displayAccountsMenu(){
        System.out.println("To deposit money                : Enter 1");
        System.out.println("To withdraw money               : Enter 2");
        System.out.println("To view transaction history     : Enter 3");
    }



}
