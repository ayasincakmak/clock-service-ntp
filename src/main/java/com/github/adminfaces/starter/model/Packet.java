package com.github.adminfaces.starter.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "packet")
public class Packet implements Serializable {
	@Id
	@Column(name = "packet_id")
	private Integer id;

	@Column(name = "service_name")
	private String serviceName;

	@Column(name = "price")
	private Double price;


	@Column(name = "service_count")
	private Integer serviceCount;

	public Packet(Integer id, String serviceName, Double price, Integer serviceCount) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.price = price;
		this.serviceCount = serviceCount;
	}


	public Packet() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(Integer serviceCount) {
		this.serviceCount = serviceCount;
	}
}