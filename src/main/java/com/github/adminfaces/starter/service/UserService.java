package com.github.adminfaces.starter.service;


import com.github.adminfaces.starter.model.Packet;
import com.github.adminfaces.starter.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
	User findUserByEmail(String email);
	User findById (Integer id);
	void saveUser(User user);
	 boolean deleteUser(User user );
	 boolean update (User user);
	List<User> getAllUser();

	Set<Packet> getUserPacketList(Integer userId);
	boolean updateServiceCreditCount(User user) ;

}