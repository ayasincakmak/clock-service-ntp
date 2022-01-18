package com.github.adminfaces.starter.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "machine")
public class Machine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "machine_id")
    private Integer id;

    @Column(name = "machine_ip")
    private String machineIp;

    @Column(name="machine_name")
    private String machineName;

    public String getMachineIp() {
        return machineIp;
    }

    public void setMachineIp(String machineIp) {
        this.machineIp = machineIp;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Machine() {
        super();
    }

    public Machine(String machineIp, String machineName) {
        super();
        this.machineIp=machineIp;
        this.machineName=machineName;

    }
}
