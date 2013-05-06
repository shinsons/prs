import java.util.*;
import java.lang.Exception;

import org.json.simple.JSONObject;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Transient;

class InvalidRoleException extends Exception {
    InvalidRoleException(String s) {
      super(s);
    }
}

@Entity
public class User {
    
    private String username, first_name, last_name, password;
    private Set<String> roles;
     
    @Transient    
    private List all_roles;

    public User(String username, String first_name, 
	String last_name, String password) {
        
        username = username;
        first_name = first_name;
        last_name = last_name;
        password = password;
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
    

    public String getFullName() {
	return first_name += ' ' + last_name;
    }

    public void setPassword(String pass) {
	password = pass;
    }

    public boolean checkPassword(String pass) {
	return password == pass;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
        username = username;
    }

    public boolean isSubmitter() {
        return roles.contains("Submitter");
    } 
    
    public boolean isReviewer() {
        return roles.contains("Reviewer");
    } 
    
    public boolean isEventManager() {
        return roles.contains("Event Manager");
    } 
    
    public boolean isSiteAdministrator() {
        return roles.contains("Site Administrator");
    } 

    public void setRole(String role) throws InvalidRoleException {
        if(!all_roles.contains(role) || role == "Site Administrator"){
	    throw new InvalidRoleException(String.format("'%s' is not a valid role."));
        }
        // needn't care if role exists already or not.
        roles.add(role);
    }

    public void deleteRole(String role) {
        roles.remove(role);
    }

    public Set getRoles() {
	return roles;
    }

    public JSONObject toJSONObject() {
	List<String> serializable_roles = new ArrayList<String>(getRoles());
	JSONObject obj = new JSONObject();
        obj.put("username", getUsername());
        obj.put("name", getFullName());
        obj.put("roles", serializable_roles);
	return obj; 
    }
}

