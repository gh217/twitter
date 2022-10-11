package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class UserModel {
	
	@SequenceGenerator(name = "userId", sequenceName = "USER_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId")
	@Id
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,unique = true)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "userfollower")
	private Collection<RelationshipsModel> follower=new ArrayList<>();
	
	@OneToMany(mappedBy = "userfollowed")
	private Collection<RelationshipsModel> followed=new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private Collection<TweetModel> tweet=new ArrayList<>();
	
	//**************************************************************
	public UserModel(){}
	
	public UserModel( String name, String userName, String password) {
		this.name = name;
		this.userName = userName;
		this.password = password;
	}
	//**************************************************************
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<RelationshipsModel> getFollower() {
		return follower;
	}

	public void setFollower(Collection<RelationshipsModel> follower) {
		this.follower = follower;
	}
	
	public Collection<RelationshipsModel> getFollowed() {
		return followed;
	}
	
	public void setFollowed(Collection<RelationshipsModel> followed) {
		this.followed = followed;
	}

	public Collection<TweetModel> getTweet() {
		return tweet;
	}

	public void setTweet(Collection<TweetModel> tweet) {
		this.tweet = tweet;
	}
	
}
