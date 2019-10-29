package biz;

import bean.User;
import dao.userDao;
import dao.userDaoImpl;

import java.util.List;

public class userBizImpl implements userBiz{
	userDao user=new userDaoImpl();

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return user.getAll();
	}

	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return user.addUser(u);
	}
}
