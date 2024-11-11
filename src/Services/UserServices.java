package Services;

import Models.User;

import java.util.ArrayList;

public class UserServices {

    private ArrayList<User> users = new ArrayList<>();

    public UserServices(){
        users = new ArrayList<>();
    }

    public boolean validateUserName(String userName){
        for (User existingUser: this.users){
            if(userName.equals(existingUser.getUserName())){
                System.out.println("Username is taken");
                return false;
            }
        }
        return true;
    }

    public User createUser(User user){
        this.users.add(user);
        return user;
    }

    public User loginUser(String userName, String password){
        for (User existingUser: this.users) {
            if (userName.equals(existingUser.getUserName()) && password.equals(existingUser.getPassword())) {
                return existingUser;
            }
        }
        return null;

    }


}
