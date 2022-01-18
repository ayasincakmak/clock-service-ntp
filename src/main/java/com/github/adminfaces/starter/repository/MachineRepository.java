package com.github.adminfaces.starter.repository;


import com.github.adminfaces.starter.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("machineRepository")
public interface MachineRepository extends JpaRepository<Machine, Long> {
	 Machine findById(Integer id);
}
