import java.util.*;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property

@Entity
public class User {
    
    private String username;
    private String first_name;
    private String last_name;
    private String password;
    private List roles;

    public User(String username, String first_name, 
	String last_name, String password) {
        
        username = username;
        first_name = first_name;
        last_name = last_name;
        password = password;
        List<String> roles = new LinkedList<String>();
        List<String> all_roles = new LinkedList<String>(
	    Arrays.asList(
                "Site Administrator",
                "Event Manager",
		"Reviewer",
		"Submitter"
            )
        );

    }

    public void setFullName(String first_name, String last_name) {
        first_name = first_name;
        last_name = last_name;
    }
    

    public String getFullName(){
	return first_name += ' ' + last_name;
    }

    public void setPassword(String pass){
	password = pass;
    }

    public String getUsername(){
	return username;
    }

    public void setUsername(String username){
        username = username;
    }

    public boolean isSubmitter(){
        return roles.contains("Submitter");
    } 
    
    public boolean isReviewer(){
        return roles.contains("Reviewer");
    } 
    
    public boolean isEventManager(){
        return roles.contains("Event Manager");
    } 
    
    public boolean isSiteAdministrator(){
        return roles.contains("Site Administrator");
    } 
}

