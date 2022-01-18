package com.github.adminfaces.starter.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;

	@Column(name = "email")
	private String email;


	@Column(name = "name")
	@NotEmpty(message = "{NotEmpty.User.name}")
	private String name;

	@Column(name = "last_name")
	@NotEmpty(message = "{NotEmpty.User.last-name}")
	private String lastName;

	@Column(name = "active")
	private boolean active;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_packets", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "packet_id"))
	private Set<Packet> packets;

	@Column(name = "packet_id")
	private Integer packetId;

	@Column(name = "service_right_count")
	private Integer serviceRightCount;


	public User() {
		super();
	}

	public User(String email, String password, String name, String lastName, boolean active, Set<Packet> packets, Integer packetId, Integer serviceRightCount) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.packets=packets;
		this.packetId= packetId;
		this.serviceRightCount=serviceRightCount;

	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public Integer getPacketId() {
		return packetId;
	}

	public void setPacketId(Integer packetId) {
		this.packetId = packetId;
	}

	public Integer getServiceRightCount() {
		return serviceRightCount;
	}

	public void setServiceRightCount(Integer serviceRightCount) {
		this.serviceRightCount = serviceRightCount;
	}

	public Set<Packet> getPackets() {
		return packets;
	}

	public void setPackets(Set<Packet> packets) {
		this.packets = packets;
	}
}