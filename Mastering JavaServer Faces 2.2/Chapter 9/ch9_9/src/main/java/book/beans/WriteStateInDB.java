package book.beans;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.bson.types.ObjectId;

/**
 *
 * @author Leonard
 */
public class WriteStateInDB {

    private DBCollection dbCollection;

    public WriteStateInDB() throws UnknownHostException {
        Mongo mongo = new Mongo("127.0.0.1", 27017);
        DB db = mongo.getDB("jsf_db");
        dbCollection = db.getCollection(("jsf"));
    }

    protected String writeStateDB(String state) {

        //TTL Index        
        BasicDBObject index = new BasicDBObject("date", 1);
        BasicDBObject options = new BasicDBObject("expireAfterSeconds", TimeUnit.MINUTES.toSeconds(1));
        dbCollection.ensureIndex(index, options);

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.append("date", new Date());
        basicDBObject.append("state", state);

        dbCollection.insert(basicDBObject);

        ObjectId id = (ObjectId) basicDBObject.get("_id");

        return String.valueOf(id);

    }

    protected String readStateDB(String id) {

        BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
        DBObject dbObj = dbCollection.findOne(query);
        if (dbObj != null) {
            return dbObj.get("state").toString();
        }
        return null;

    }
}
