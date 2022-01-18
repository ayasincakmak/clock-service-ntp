package com.github.adminfaces.starter.repository;


import com.github.adminfaces.starter.model.Machine;
import com.github.adminfaces.starter.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("clockServiceRepository")
public interface ClockServiceRepository extends JpaRepository<Service, Long> {
	 Service findById(Integer id);
}
