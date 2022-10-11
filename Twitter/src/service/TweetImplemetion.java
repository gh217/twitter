package service;

import dao.TweetDao;
import model.TweetModel;
import model.UserModel;

public class TweetImplemetion implements TweetInterface{

	private TweetDao twwetDao = new TweetDao();
	
	public boolean addTweet(UserModel userModel, TweetModel tweetModel) {
		return twwetDao.addTweet(userModel, tweetModel);
	}

	
}
