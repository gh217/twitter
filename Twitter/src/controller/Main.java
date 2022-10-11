package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.RelationDao;
import dao.TweetDao;
import dao.UserDao;
import model.RelationshipsModel;
import model.TweetModel;
import model.UserModel;
import service.RelationImplemntion;
import service.TweetImplemetion;
import service.UserImplemention;


public class Main {

	static Scanner input = new Scanner (System.in);
	public static void main(String[] args) {


	  try {
        	
	    SessionFactory factory = new Configuration()
			.configure("config.xml")
			.addAnnotatedClass(UserModel.class)
			.addAnnotatedClass(RelationshipsModel.class)
			.addAnnotatedClass(TweetModel.class)
			.buildSessionFactory();
            
        Session session = factory.openSession();
        session.beginTransaction();
       	UserDao.session=session;
       	TweetDao.session=session;
       	RelationDao.session=session;
      //***************************************
       	
       	while (true) {
       		
       	 	UserModel user =new UserModel();
           	UserImplemention userImp = new UserImplemention();
           	
       		int start=startChoose();
           	input.nextLine();
           	// login
            if(start==1) {
            	logIn(user);
            	System.out.println(user.getUserName());
            	user=userImp.logIn(user);
            	if(user!=null) {
            		print(user);
            		session.getTransaction().commit();
            		session.beginTransaction();
            		
            		int option=option();
            		TweetImplemetion tweetImp=new TweetImplemetion();
            		if(option==1) {
            			TweetModel tweetModel=new TweetModel();
            			tweetModel.setContent(addTweet());
            			
            			System.out.println(
            					tweetImp.addTweet(user, tweetModel));
            			session.getTransaction().commit();
                		session.beginTransaction();
            		}else if(option==2) {
            			
            			Collection<TweetModel>list=
            					(Collection<TweetModel>) user.getTweet();
            			
            			if(list.size()>0)printTweet(list);
            			else System.out.println("No Tweet");
            			// show follower 
            		}else if(option==3) {

            			Collection<RelationshipsModel>listFollower=
            					(Collection<RelationshipsModel>) user.getFollower();
            		
            			for(RelationshipsModel relation : listFollower) {
            				System.out.println(relation.getUserfollowed().getId());
            			}
            		}//followed
            		else if(option==4) {
            			
            			Collection<RelationshipsModel>listFollowed=
            					(Collection<RelationshipsModel>) user.getFollowed();
            			        			
            			for(RelationshipsModel relation : listFollowed) {
            				System.out.println(relation.getUserfollower().getId());
            			}
            			
            		}// follow
            		else if(option==5) {
            			
            			RelationImplemntion relationImp=new RelationImplemntion();
            			
            			System.out.println("enter id to folloe it");
            			UserModel us=session.get(UserModel.class, input.nextInt());
            			relationImp.follow(user, us);
            			
            		}else {
            			continue;
            		}
            		
            		break;
            		
            	}else {
            		System.out.println("log in failed");
            	}
            	
            	// regiester
            }else if(start==2) {
            	
            	insertData(user);
            	if(userImp.Regiester(user)) {
            		System.out.println("insertDone");
            		session.getTransaction().commit();
            		session.beginTransaction();
            	}else {
            		System.out.println("Username Exist");
            		continue;
            	}
            // selsect all
            }else if(start==3) {
            	ArrayList<UserModel>list=(ArrayList<UserModel>) userImp.allUser();
            	if(list==null) {
            		System.out.println("No User");
            	}
            	for(UserModel userM : list) {
            		print(userM);
            	}
            }else if(start==5){
            	break;
            }else {
            	System.out.println("Enetr Right Rumber ");
            }
            
		}
 
      //***************************************
		session.getTransaction().commit();
        session.close();

		} catch (Exception e) {
			System.err.println("error main");
			System.out.println(e.getMessage());
		}
	  	System.out.println("end");
		
	}

	static int startChoose() {
		System.out.println("Login     1 :");
		System.out.println("Regiester 2 : ");
		System.out.println("All Usser 3 : ");
		return input.nextInt();
	}
	
	static void insertData(	UserModel user) throws Exception {
		
		System.out.print("Enter Name : ");
		String name=input.nextLine();
		
		System.out.print("Enter UserName : ");
		String userName=input.nextLine();
		
		System.out.print("Enter Password : ");
		String password=input.nextLine();
		
		user.setName(name);
		user.setUserName(userName);
		user.setPassword(password);
	}
	
	static void logIn(UserModel user)  throws Exception{
		System.out.print("Enter UserName : ");
		String userName=input.nextLine();
		
		System.out.print("Enter Password : ");
		String password=input.nextLine();
		
		user.setUserName(userName);
		user.setPassword(password);
	}
	
	static void print(UserModel user) {
		System.out.println("********************************************************");
		System.out.println("Id        : "+user.getId());
		System.out.println("Name      : "+user.getName());
		System.out.println("User Name : "+user.getUserName());
		System.out.println("********************************************************");
	}
	static int option() {
		System.out.println("Add Tweet   : 1");
		System.out.println("Show Tweets : 2");
		System.out.println("Follower    : 3");
		System.out.println("Followed    : 4");
		System.out.println("Follow :    : 5");
		return input.nextInt();
	}
	
	private static String addTweet() {
		System.out.println("Enter Tweete");
		return input.next();
		
	}
	
	static void printTweet(Collection<TweetModel>list) {
		System.out.println("*******************************");
		for(TweetModel tweet : list) {
			System.out.println("content : "+tweet.getContent());
			System.out.println("*******************************");	
		}
	}
}

