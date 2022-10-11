package service;

import java.util.List;

import model.UserModel;

public interface UserInterface {

	public Boolean Regiester(UserModel userModel) throws Exception;
	public Boolean changePassword(UserModel userModel ) throws Exception;
	public UserModel logIn(UserModel userModel) throws Exception;
	public List allUser() throws Exception;
	
}
