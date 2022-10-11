package service;


import java.util.List;

import dao.UserDao;
import model.UserModel;

public class UserImplemention implements UserInterface{

	private UserDao dao = new UserDao();
	
	public Boolean Regiester(UserModel userModel ) throws Exception{
		try {
			 return dao.Regiester(userModel);
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean changePassword(UserModel userModel ) throws Exception{
		return dao.changePassword(userModel);
	}

	public UserModel logIn(UserModel userModel) throws Exception{
		return dao.logIn(userModel);
	}

	
	public List allUser() throws Exception {
		
		return dao.allUser();
	}
	
}
