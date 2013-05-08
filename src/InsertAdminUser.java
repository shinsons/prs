import java.net.UnknownHostException;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class InsertAdminUser {
    
    public static void main(String[] args) {
		Morphia morphia = new Morphia();
		morphia.map(User.class);
		try{
			Mongo mongo = new Mongo();
			UserDAO user_ds = new UserDAO(morphia, mongo);
			User admin = new User();
			admin.setFullName("Nathen", "Hinson");
			admin.setPassword("b!nG0");
			admin.setUsername("admin");
			admin.setRole("Site Administrator");
			user_ds.save(admin);
			User new_admin = user_ds.findOne("first_name", "Nathen");
			System.out.println("New Admin Username: " + new_admin.getUsername());
			System.out.println("New Admin Name: " + new_admin.getFullName());
			System.out.println("New Admin Roles: " + new_admin.getRoles().toString());
		}
		catch (InvalidRoleException e){
			System.out.println("InvalidRoleException");
		}
		catch (UnknownHostException e){
			System.out.println("UnknownHostException");
		}
    }

}
