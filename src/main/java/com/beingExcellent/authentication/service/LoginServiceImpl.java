package com.beingExcellent.authentication.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.beingExcellent.model.entity.UserRole;
import com.beingExcellent.repositories.rdbms.UserRepository;

@Service("loginService")
public class LoginServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	/**
	 * Method to load user details and authenticate
	 * */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		com.beingExcellent.model.entity.User user = userRepository.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		return buildUserForAuthentication(user, authorities);
	}

	/**
	 * Method to build user authentications
	 * @param user
	 * @param authorities
	 * @return
	 */
	private User buildUserForAuthentication(com.beingExcellent.model.entity.User user,
			List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
	}

	/**
	 * Method to grant authority for a user
	 * @param userRoles
	 * @return
	 */
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}

}
