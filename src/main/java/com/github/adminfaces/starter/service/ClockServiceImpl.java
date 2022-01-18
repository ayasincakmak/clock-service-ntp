package com.github.adminfaces.starter.service;


import com.github.adminfaces.starter.model.Machine;
import com.github.adminfaces.starter.repository.ClockServiceRepository;
import com.github.adminfaces.starter.repository.MachineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("clockServiceImpl")
public class ClockServiceImpl implements ClockService {
	
	private final static Logger logger = LoggerFactory
			.getLogger(ClockServiceImpl.class);

	@Autowired
	private ClockServiceRepository clockServiceRepository;


	@Override
	public com.github.adminfaces.starter.model.Service findById(Integer id) {
		return clockServiceRepository.findById(id);
	}



	@Override
	public List<com.github.adminfaces.starter.model.Service> getAllClockServices() {
		return clockServiceRepository.findAll();
	}

	@Override
	public void saveClockService(com.github.adminfaces.starter.model.Service service) {
		clockServiceRepository.save(service);
	}

}