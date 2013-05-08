import org.bson.types.ObjectId;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class AddressDAO extends BasicDAO<Address, ObjectId> {
    public AddressDAO(Morphia morphia, Mongo mongo ) {
        super(mongo, morphia, "prsDB");
    }
}

