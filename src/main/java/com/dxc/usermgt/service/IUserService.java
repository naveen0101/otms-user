package com.dxc.usermgt.service;

import java.util.List;

import com.dxc.usermgt.entities.User;

public interface IUserService {
	
	User adduser(User user);

	 List<User> reterive();

       User findById(int userId);

	public Boolean deleteuser(int userId);

	User update(int userId,User user);

}
