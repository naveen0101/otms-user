package com.dxc.usermgt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.usermgt.dao.UserDaoImpl;
import com.dxc.usermgt.entities.User;
import com.dxc.usermgt.exceptions.NoUserFoundException;
import com.dxc.usermgt.exceptions.UserIdNotFoundException;

@Transactional 
@Service
public class UserService implements IUserService{
	
	@Autowired
	UserDaoImpl userdao;
	
	//Add user
	@Override
	public User adduser(User user) {
		userdao.adduser(user);
		return user;
	}

	//For User details
	@Override
	public List<User> reterive() {
		if(userdao.reterive().size()>0) {
		List<User> list=userdao.reterive();
		return list;
		}
		throw new NoUserFoundException("No USer is Available");
	}
	
	
	//Find by Id
	@Override
	public User findById(int id) {
		User user=userdao.findById(id);
		if(user==null)
		{
			throw new UserIdNotFoundException("User ID not found , please entera valid Id");
		}
		return user;
	}
	
	//Delete user
	@Override
	public Boolean deleteuser(int id) {
		userdao.deleteuser(id);
		return null;
		
	}
	
	
	//Update user
	@Override
	public User update(int userId,User user) {
		User updatedUser=userdao.findById(userId);
		updatedUser.setName(user.getName());
		updatedUser.setPassword(user.getPassword());
	
		
		userdao.update(updatedUser);
		
		return user;
		
	}
	
}
