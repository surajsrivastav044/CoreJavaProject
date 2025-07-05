import java.util.HashMap;
import java.util.Map;

public class UserService {

    Map<Integer,User> userMap=new HashMap<>();
    private User currentUser;

    public void registerUser(int userId, String fullName, String password, String contact){
        if(userMap.containsKey(userId)){
            System.out.println("UserID Already Exist Please register with other Id");
            return;
        }
        userMap.put(userId,new User(userId,fullName,password,contact));
        System.out.println("Registration Successful");
    }

    public boolean loginUser(int userId, String password){
        if(userMap.containsKey(userId)){
            User user=userMap.get(userId);
            if(user.getPassword().equalsIgnoreCase(password)){
                System.out.println("-----------------Welcome "+user.getFullName()+"------------------");
                currentUser=user;
                return true;
            }
            System.out.println("User password is incorrect please try again");
            return false;
        }
        System.out.println("userId: "+userId+" is incorrect please try again");
        return false;
    }

    public boolean logoutUser(){
        if(currentUser!=null){
            currentUser=null;
            System.out.println("Logout Successful");
            return true;
        }
        return false;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public boolean isUserLoggedIn(){
        return currentUser != null;
    }
}
