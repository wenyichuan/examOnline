package dao;

import bean.User;

import java.util.List;

public interface userDao {
	
  public List<User> getAll();
  public int addUser(User u);				//Ôö¼Ó
}
