package com.github.adminfaces.starter.service;


import com.github.adminfaces.starter.model.Packet;

import java.util.List;

public interface PacketService {

	Packet findById (Integer id);
	void savePacket(Packet packet);
	List<Packet> getAllPacket();
}