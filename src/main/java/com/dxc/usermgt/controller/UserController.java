package com.dxc.usermgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.dxc.usermgt.entities.User;
import com.dxc.usermgt.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userservice;
	
//Adding User
	
	@PostMapping("/add")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
        //showservice.addshow(show);;
		userservice.adduser(user);
        
		return new ResponseEntity<String>("User Added Successfully",HttpStatus.OK);
	}
	
	
	//Get user
	@GetMapping("/getuser")
    public ResponseEntity<List<User>> getuserlist() {
			List<User> list = userservice.reterive();
					//showservice.reterive();
			return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	
	
	// delete Id
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id)
	{
	
		userservice.deleteuser(id);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}
	
	
	// View id
	
	@GetMapping("/view/{id}")
	public ResponseEntity<User> viewUser(@PathVariable("id") int id)
	{
		User user = userservice.findById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	
		
	}
	
	
	//update id
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") int id,@RequestBody User user)
	{
		//showservice.update(id,show);
		userservice.update(id, user);
		return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
	}
}



