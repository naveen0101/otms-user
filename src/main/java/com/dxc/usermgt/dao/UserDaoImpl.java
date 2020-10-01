package com.dxc.usermgt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxc.usermgt.entities.User;
import com.dxc.usermgt.exceptions.NoUserFoundException;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@PersistenceContext
	private EntityManager entitymanager;
	

	
	
	// Adding user method
	
	@Override
	public User adduser (User user) {
		entitymanager.persist(user);
		return user;
	}
	
	//View user method
	
	@Override
	public List<User> reterive() {
		String Qstr="SELECT user from User user";
		TypedQuery<User> query=entitymanager.createQuery(Qstr,User.class);
		return query.getResultList();
	}
	
	
	
	
	//Delete User
	@Override
	public void deleteuser(int id) {
		User show=entitymanager.find(User.class, id);
		entitymanager.remove(show);
		
		
	}
	
	// Update user
	
	@Override
	public User update (User user) {
		entitymanager.persist(user);
		return user;
		
	}
	
	// Find by id
	
	public User findById(int id) {
		User user=entitymanager.find(User.class,id);
		if (user==null) {
			throw new NoUserFoundException("User not found for "+id);
		}
		
		return user;
	}
	
}


