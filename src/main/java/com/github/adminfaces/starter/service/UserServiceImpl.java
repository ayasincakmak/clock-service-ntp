package com.github.adminfaces.starter.service;


import com.github.adminfaces.starter.model.Packet;
import com.github.adminfaces.starter.model.User;
import com.github.adminfaces.starter.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	private final static Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public void saveUser(User user) {

		userRepository.save(user);
	}


	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Set<Packet> getUserPacketList(Integer id) {
		User userFromDb = userRepository.findById(id);
		return  userFromDb.getPackets();
	}

	@Override
	public boolean updateServiceCreditCount(User user) {
		User userFromDb = userRepository.findById(user.getId());
		userFromDb.setServiceRightCount(user.getServiceRightCount());
		userRepository.save(userFromDb);
		return true;
	}


	@Override
	public boolean deleteUser(User user) {
		 userRepository.delete(user);
		 return  true;
	}

	@Override
	public boolean update(User user) {
		User userFromDb = userRepository.findById(user.getId());
		userFromDb.setServiceRightCount(user.getServiceRightCount());
		userFromDb.setPacketId(user.getPacketId());
		userRepository.save(userFromDb);
		return true;
	}




}