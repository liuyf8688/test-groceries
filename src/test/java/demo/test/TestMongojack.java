package demo.test;

import java.net.UnknownHostException;

import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import demo.pojos.UserPojo;

public class TestMongojack {

	public static void main(String[] args) throws JsonProcessingException {

		DBCollection dbCollection = getCollection();

		JacksonDBCollection<UserPojo, String> coll = JacksonDBCollection.wrap(dbCollection, UserPojo.class, String.class);
		
		UserPojo pojo = new UserPojo();
		pojo.setFirstName("FirstName");
		pojo.setLastName("LastName");
		
		WriteResult<UserPojo, String> result = coll.insert(pojo);
		UserPojo pojoOfResult = result.getSavedObject();
		System.out.println(pojoOfResult.getFirstName() + " ===>>> " + pojoOfResult.getLastName());
		
		UserPojo user = coll.findOne();
		System.out.println(user.getFirstName() + " ===>>> " + user.getLastName() + " ===>>> " + user.isMale());
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(user));
	}

	private static DBCollection getCollection() {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		DB db = mongoClient.getDB("mydb");
		DBCollection dbCollection = db.getCollection("testMongojack");
		return dbCollection;
	}
}
