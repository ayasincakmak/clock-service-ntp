package com.github.adminfaces.starter.service;


import com.github.adminfaces.starter.model.Machine;
import com.github.adminfaces.starter.model.Service;

import java.util.List;

public interface ClockService {
	Service findById (Integer id);
	void saveClockService(Service service);
	List<Service> getAllClockServices();
}