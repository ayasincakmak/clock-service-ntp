package com.github.adminfaces.starter.service;


import com.github.adminfaces.starter.model.Packet;
import com.github.adminfaces.starter.repository.PacketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("packetService")
public class PacketServiceImpl implements PacketService {
	
	private final static Logger logger = LoggerFactory
			.getLogger(PacketServiceImpl.class);

	@Autowired
	private PacketRepository packetRepository;


	@Override
	public Packet findById(Integer id) {
		return packetRepository.findById(id);
	}

	@Override
	public void savePacket(Packet packet) {
		packetRepository.save(packet);
	}

	@Override
	public List<Packet> getAllPacket() {
		return packetRepository.findAll();
	}

}