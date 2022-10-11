package dao;

import org.hibernate.Session;

import model.TweetModel;
import model.UserModel;

public class TweetDao {

	public static Session session;
	
	public boolean addTweet(UserModel userModel,TweetModel tweetModel) {
		
		try {
			if(userModel==null) {
				System.out.println("userModel");
			}
			
			if(tweetModel==null) {
				System.out.println("tweetModel");
			}
			userModel.getTweet().add(tweetModel);
			tweetModel.setUser(userModel);
		    
			session.save(userModel);
			session.save(tweetModel);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
}
