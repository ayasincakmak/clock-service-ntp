package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.Packet;
import com.github.adminfaces.starter.service.PacketService;
import com.github.adminfaces.template.exception.BusinessException;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

/**
 * Created by rmpestano on 12/02/17.
 */
@Named
@ViewScoped
public class PacketListMB implements Serializable {

    @Inject
    PacketService packetService;

    Integer id;

    List<Packet> packets;

    Filter<Packet> filter = new Filter<Packet>(new Packet());

    List<Packet> selectedPackets; //cars selected in checkbox column

    List<Packet> filteredValue;// datatable filteredValue attribute (column filters)

    @PostConstruct
    public void initDataModel() {
        packets = packetService.getAllPacket();
    }

    public void clear() {
        filter = new Filter<Packet>(new Packet());
    }



    public void findUserById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide Car ID to load");
        }
        selectedPackets.add(packetService.findById(id));
    }

    public void delete() {
        int numCars = 0;
        for (Packet selectedPacket : selectedPackets) {
            numCars++;
            //packetService.deleteUser(selectedUser);
        }
        //selectedUsers.clear();
       // addDetailMessage(numCars + " user deleted successfully!");
    }

    public List<Packet> getSelectedPackets() {
        return selectedPackets;
    }

    public List<Packet> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Packet> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public void setSelectedPackets(List<Packet> selectedPackets) {
        this.selectedPackets = selectedPackets;
    }

    public List<Packet> getPackets() {
        return packets;
    }

    public void setPackets(List<Packet> packets) {
        this.packets = packets;
    }

    public Filter<Packet> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Packet> filter) {
        this.filter = filter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
