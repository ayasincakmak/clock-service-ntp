package com.github.adminfaces.starter.service;


import com.github.adminfaces.starter.model.Machine;

import java.util.List;

public interface MachineService {
	Machine findById (Integer id);
	void saveMachine(Machine machine);
	List<Machine> getAllMachines();
}