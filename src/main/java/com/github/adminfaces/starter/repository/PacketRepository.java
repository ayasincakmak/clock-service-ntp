package com.github.adminfaces.starter.repository;


import com.github.adminfaces.starter.model.Packet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("packetRepository")
public interface PacketRepository extends JpaRepository<Packet, Long> {

	 Packet findById(Integer id);
}
