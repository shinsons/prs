import java.util.*;
import java.lang.Exception;
import java.text.SimpleDateFormat;

import org.json.simple.JSONObject;
import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Transient;

@Entity
public class Event {
   
    @Id
    private ObjectId id;
 
    private String name, location;

	private Date start;

	private Date end;

	private Date submission_enddate;

	@Transient
	private static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

	private Date created;

    public String getName() {
		return name;
    }

    public void setName(String n) {
		name = n;
		created = new Date();
    }
    
    public String getLocation() {
		return location;
    }

    public void setLocation(String l) {
		location = l;
    }

    public String getStartDate() {
		if(start == null) {
			return "";
		}
		return sdf.format(start);
    }

    public void setStartDate(String dt) {
		if(dt != null) {
			start = sdf.parse(dt);
		}
    }

    public String getEndDate() {
		if(end == null) {
			return "";
		}
		return sdf.format(end);
    }

    public void setEndDate(String dt) {
		if(dt != null) {
			end = sdf.parse(dt);
		}
    }
    
    public void getSubmissionEndDate(String dt) {
		if(submission_enddate == null) {
			return "";
		}

		return sdf.format(submission_enddate);
    }

    public void setSubmissionEndDate(String dt) {
		if(dt != null) {
			submission_enddate = sdf.parse(dt);
		}
    }

	public Date getCreationDate() {
		return created;
	}
/*
    public JSONObject toJSONObject() {
		List<String> serializable_roles = new ArrayList<String>(getRoles());
		JSONObject obj = new JSONObject();

		obj.put("username", getUsername());
		obj.put("name", getFullName());
		obj.put("roles", serializable_roles);
		
		Address addr = getAddress();
		if(addr == null) {
			obj.put("address", new JSONObject());
		}
		else {
			obj.put("address", addr.toJSONObject());
		}

		obj.put("created", getCreationDate());
		return obj; 
    }
*/
}

