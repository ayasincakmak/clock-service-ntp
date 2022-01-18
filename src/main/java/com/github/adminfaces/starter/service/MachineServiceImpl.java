package com.github.adminfaces.starter.service;


import com.github.adminfaces.starter.model.Machine;
import com.github.adminfaces.starter.repository.MachineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("machineService")
public class MachineServiceImpl implements MachineService {
	
	private final static Logger logger = LoggerFactory
			.getLogger(MachineServiceImpl.class);

	@Autowired
	private MachineRepository machineRepository;


	@Override
	public Machine findById(Integer id) {
		return machineRepository.findById(id);
	}

	@Override
	public void saveMachine(Machine machine) {

		machineRepository.save(machine);
	}


	@Override
	public List<Machine> getAllMachines() {
		return machineRepository.findAll();
	}
}