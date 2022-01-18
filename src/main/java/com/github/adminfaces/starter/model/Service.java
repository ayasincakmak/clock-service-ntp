package com.github.adminfaces.starter.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "service")
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id")
    private Integer id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name="service_fee")
    private Long serviceFee;

    @Column (name="host_name")
    private String hostName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Long serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Service() {
        super();
    }

    public Service (String serviceName, Long serviceFee,String hostName) {
        this.serviceFee=serviceFee;
        this.serviceName=serviceName;
        this.hostName=hostName;
    }
}
