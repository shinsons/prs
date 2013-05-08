import java.util.*;

import org.json.simple.JSONObject;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public class Address{

    private String address_line_1, address_line_2, city;
    private String us_state, province, country, phone;
    private String zip_code, postal_code, email;
    private boolean is_international;

    public boolean isInternational() {
        return is_international;
    }

    public String getAddressLine1(){
		return address_line_1;
    }
    
    public String getAddressLine2(){
		return address_line_2;
    }
    
    public String getCity(){
		return city;
    }
    
    public String getEmail(){
		return email;
    }
    
    public String getState(){
		return us_state;
    }

    public String getZipCode(){
		return zip_code;
    }

    public String getProvince(){
		return province;
    }

    public String getPostalCode(){
		return postal_code;
    }

    public void setAddressLine1(String update){
		address_line_1 = update;
    }
    
    public void setAddressLine2(String update){
		address_line_2 = update;
    }
    
    public void setCity(String update){
		city = update;
    }
    
    public void setEmail(String update){
		email = update;
    }
    
    public void setState(String update){
		us_state = update;
    }

    public void setZipCode(String update){
		zip_code = update;
    }

    public void setProvince(String update){
		province = update;
    }

    public void setPostalCode(String update){
		postal_code = update;
    }

    public JSONObject toJSONObject(){
		JSONObject obj = new JSONObject();
		obj.put("address_line_1", getAddressLine1()); 	
		obj.put("address_line_2", getAddressLine2()); 	
    	obj.put("city", getCity());
    	obj.put("email", getEmail());
    	obj.put("state", getState());
    	obj.put("zip_code", getZipCode());
    	obj.put("province", getProvince());
    	obj.put("postal_code", getPostalCode());
    	obj.put("is_international", isInternational());
		return obj;
    }

} 
