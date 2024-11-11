import Models.User;
import Services.DisplayServices;
import Services.UserServices;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UserServices userService = new UserServices();
        User currentUser;

        System.out.println("Welcome to Java Banking Application");
        // Initially No users present : So create new user
        currentUser = Application.loadSignUpPage(userService);

        // Redirect to User Home Page
        Application.loadUserPage(userService, currentUser);

    }
}

/*
Application Flow

--> loadSignUpPage(userService) : User                                                          // No user present, Create new user
    --> loadUserPage(userService, currentUser) : void                                           // User Options -> Create Account, View Accounts, Logout
        --> addAccountPage (userService, currentUser) : User                                    // Enter initial deposit and account type
        --> showAccountsPage (userService, currentUser) : User                                  // Select account
            --> Deposit
            --> Withdraw
            --> Transaction History
        --> loadHomePage()                                                                      // Logout User, Redirect to Main Menu
            --> loadLogInPage()                                                                 // Enter valid username and password
                --> loadUserPage (userService, currentUser) : User
            --> loadSignUpPage()                                                                // Create new User
                --> loadUserPage (userService, currentUser) : User

*/