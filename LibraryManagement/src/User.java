public class User {

    private int userId;
    private String fullName;
    private String password;
    private String contact;

    public User(int userId, String fullName, String password, String contact) {
        this.userId = userId;
        this.fullName = fullName;
        this.password = password;
        this.contact = contact;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString(){
        return "UserId: "+userId+", userFullName: "+fullName+", Contact"+contact;
    }
}
