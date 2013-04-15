import java.io.*;
import com.mongodb.DBObject;

public class User extends DBObject {
    
    private String username;
    private String first_name;
    private String last_name;
    private String password;

    public User(String username, String first_name, 
	String last_name, String password) {
        
        username = username;
        first_name = first_name;
        last_name = last_name;
        password = password;
    }

    public void setFirstName(String val){

    }

    public void setFullName(String first_name, String last_name) {
        first_name = first_name;
        last_name = last_name;
    }
}

