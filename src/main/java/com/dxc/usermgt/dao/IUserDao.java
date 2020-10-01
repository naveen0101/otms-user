package com.dxc.usermgt.dao;

import java.util.List;

import com.dxc.usermgt.entities.User;

public interface IUserDao {
	User  adduser(User user);

     List<User> reterive();


    public void deleteuser(int id);

	  User  update(User user);
	
	  User findById (int id);
	

}
