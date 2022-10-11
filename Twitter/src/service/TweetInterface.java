package service;


import model.TweetModel;
import model.UserModel;

public interface TweetInterface {

	public boolean addTweet(UserModel userModel,TweetModel tweetModel);
	
}
