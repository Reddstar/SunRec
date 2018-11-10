package sunrec.com.sunrec.model;

/**
 * Created by Ricardo Silva on 10/11/2018.
 */
public class Profile {

    private String username;
    private String password;
    private User user;
    private static final Profile instance = new Profile();

    private Profile(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static Profile getInstance() {
        return instance;
    }
}
