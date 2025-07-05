import java.util.HashMap;
import java.util.Map;

public class UserService {
    //username -----> user
    private final Map<String,User> userMap= new HashMap<>();

    private User currentUser=null;

    public void registerUser(String userName, String password, String fullName, String contact){
        if(userMap.containsKey(userName)){
            System.out.println("userName already exist please register with other");
            return;
        }
        User user=new User(userName,password,fullName,contact);
        userMap.put(userName,user);
        System.out.println("Registration successful");
    }

    public boolean loginUser(String userName, String password){
        if(!userMap.containsKey(userName)){
            System.out.println("User not found with this name please try again");
            return false;
        }

        User user=userMap.get(userName);
        if(!user.getPassword().equals(password)){
            System.out.println("Incorrect password");
            return false;
        }

        currentUser=user;
        System.out.println("Welcome : "+currentUser.getFullName());
        return true;
    }

    public void logoutUser(){
        if(currentUser!=null) {
            System.out.println("Logout successful");
        }
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn(){
        return currentUser!=null;
    }

}
