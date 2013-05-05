import java.util.*;
import com.google.code.morphia.annotations.Entity;

@Entity
public class Address{
    
    private String address_line_1, address_line_2, city;
    private String us_state, province, country, phone;
    private String zip_code, postal_code, email;

    @Reference
    private User users;


    public Address(String address_line_1, String address_line_2, 
	String city) {

    }
    public boolean isInternational() {
        return zip_code == null;
    }

    public setAddress 
} 
