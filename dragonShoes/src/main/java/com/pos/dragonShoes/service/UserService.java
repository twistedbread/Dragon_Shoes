package com.pos.dragonShoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pos.dragonShoes.entity.User;
import com.pos.dragonShoes.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder passEnd;
	
	@Autowired
	private UserRepository userRep;
	
	public User checkMember(String email, String password) {
		User user = userRep.findByEmail(email).get();
		if (user != null) {
			if (passEnd.matches(password, user.getPassword())) {
				password = userRep.findByEmail(email).get().getPassword();
				
				user = userRep.findByEmailAndPassword(email, password).get();
				return user;
			} else {
				return null;
			}
		}
		return null;
	}

	public User checkAdmin(String email, String password) {
		User user = userRep.findByEmail(email).get();
		if (user != null) {
			if (passEnd.matches(password, user.getPassword())) {
				password = userRep.findByEmail(email).get().getPassword();
//				System.out.println(password+"pppp");
				user = userRep.findByEmailAndPassword(email, password).get();
				
					return user;
			} else
			{
				 
				return null;
			}
		}
		return null;
	}
	public String encodePass(String pass) {
		return passEnd.encode(pass);
	}

	public void saveUser(User user) {
		try {
			user.setPassword(encodePass(user.getPassword()));
//			user.setProfilePic("default2.jpg");
			userRep.save(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	public Optional<User> findById(long id){
		return userRep.findById(id);
	}
	public List<User> findAll(){
		return (List<User>) userRep.findAll();
	}
	public List<User> findAllUsers(){
		return userRep.findAllUsers();
	}
	public void updateUser(long id, User user) {
		user.setId(id);
		User oldUser = userRep.findById(id).get();
		user.setEmail(oldUser.getEmail());
		user.setPassword(oldUser.getPassword());
		user.setRole(oldUser.getRole());
		if(user.getProfilePic().isEmpty()) {
			user.setProfilePic(oldUser.getProfilePic());
		}
		userRep.save(user);
	}
	public void updateUserPassword(long id, User user, String pass) {
		user.setId(id);
		User oldUser = userRep.findById(id).get();
		user.setFirstName(oldUser.getFirstName());
		user.setLastName(oldUser.getLastName());
		user.setEmail(oldUser.getEmail());
		user.setProfilePic(oldUser.getProfilePic());
		user.setRole(oldUser.getRole());
		user.setPassword(passEnd.encode(pass));
		userRep.save(user);
	}
	
	public List<User> searchData(String data){
		List<User> listUser = new ArrayList<User>();
		for(User user: userRep.findAll()) {
		if(user.getId().toString().equalsIgnoreCase(data) ||user.getEmail().equalsIgnoreCase(data) 
					|| user.getRole().getRoleName().equalsIgnoreCase(data) || user.getFirstName().equalsIgnoreCase(data) 
					|| user.getLastName().equalsIgnoreCase(data)) 
				listUser.add(user);
		}
		return listUser;
	}
	public void deleteUser(User user) {
		try {
			userRep.deleteById(user.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
