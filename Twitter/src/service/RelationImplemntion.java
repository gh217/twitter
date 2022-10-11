package service;

import dao.RelationDao;
import model.UserModel;

public class RelationImplemntion {

	RelationDao relationDao= new RelationDao();
	
	public Boolean follow(UserModel userModel1 , UserModel userModel2) {
		try {
			relationDao.follow(userModel1, userModel2);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
