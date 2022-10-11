package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import model.RelationshipsModel;
import model.UserModel;

public class UserDao {

	public static Session session;
	
	public Boolean Regiester(UserModel userModel ) {
		
		try {	
			if(isUnique(userModel.getUserName())) {
				System.out.println("regiester");
				session.save(userModel);
				return true;
			}
			return false;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	private boolean isUnique(String userName) throws Exception{
		String qu="FROM UserModel where userName=:name";
       	Query query =session.createQuery(qu);
       	query.setParameter("name",userName);    	
		return query.getResultList().size()==0;
	}

	public Boolean changePassword(UserModel userModel){
		try {
			session.update(userModel);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public UserModel logIn(UserModel userModel){
		
		try {
			String qu="FROM UserModel where userName=:name ";
	       	Query query =session.createQuery(qu);
	       	query.setParameter("name",userModel.getUserName());
	    	
	       	ArrayList<UserModel>list= (ArrayList<UserModel>) query.getResultList();
	       	if(list.size()==0)return null;
	       	UserModel result= list.get(0);
	       	
	       	return result.getPassword().equals(userModel.getPassword())?
	       			result:null;
	       	
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

	public List allUser() throws Exception {
		String qu="FROM UserModel";
		Query query =session.createQuery(qu);
		return query.getResultList();	
	}

}
