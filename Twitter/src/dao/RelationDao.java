package dao;

import org.hibernate.Session;

import model.RelationshipsModel;
import model.UserModel;

public class RelationDao {

	public static Session session;
	
	public Boolean follow(UserModel userModel1 , UserModel userModel2){
		RelationshipsModel relation = new RelationshipsModel();
		
		relation.setUserfollower(userModel1);
		relation.setUserfollowed(userModel2);
		
		userModel1.getFollower().add(relation);
		userModel2.getFollowed().add(relation);
		
		session.save(relation);
		session.save(userModel1);
		session.save(userModel2);
		
		return null;
	}
}
