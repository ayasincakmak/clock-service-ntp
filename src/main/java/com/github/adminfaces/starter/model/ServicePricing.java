package com.github.adminfaces.starter.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pricing")
public class ServicePricing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pricing_id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "machine_id")
    private Integer machineId;

    @Column(name = "service_id")
    private Integer serviceId;



    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
