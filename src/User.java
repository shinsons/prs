import java.util.*;
import java.lang.Exception;

import org.json.simple.JSONObject;
import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Transient;

@Entity
public class User {
   
    @Id
    private ObjectId id;
 
    private String username, first_name, last_name, password;

	@Embedded	
	private Address address;
	@Embedded
    private Set<String> roles = new HashSet<String>();
     
    @Transient    
    private static List<String> all_roles = new LinkedList<String>(
        Arrays.asList(
        	"Site Administrator",
        	"Event Manager",
			"Reviewer",
			"Submitter"
        )
    );

    public void setFullName(String first, String last) {
        first_name = first;
        last_name = last;
    }
    
    public String getFullName() {
		return first_name += ' ' + last_name;
    }

    public void setPassword(String pass) {
		password = pass;
    }

    public boolean checkPassword(String pass) {
		return password.equals(pass);
    }

    public String getUsername() {
		return username;
    }

    public void setUsername(String user) {
        username = user;
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address addr) {
		address = addr;
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

