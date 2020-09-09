package com.airtelpaymentbank.enach.emandate.jwt;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserLoginRepository;

@Service(value = "JwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserLoginRepository userService;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserModel> user = userService.findById(username);

		if (user.isPresent()) {
			//System.out.println(user.get().getLoginid());
			return new org.springframework.security.core.userdetails.User(user.get().getLoginid(),
					user.get().getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		/*
		 * Optional<JwtUserDetails> findFirst = inMemoryUserList.stream() .filter(user
		 * -> user.getUsername().equals(username)).findFirst();
		 * 
		 * if (!findFirst.isPresent()) { throw new
		 * UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username)); }
		 * 
		 * return findFirst.get();
		 */
	}

	public UserModel save(UserModel user) {
		UserModel newUser = new UserModel();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userService.save(newUser);
	}

}
