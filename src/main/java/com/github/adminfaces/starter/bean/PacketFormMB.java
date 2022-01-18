package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.model.Packet;
import com.github.adminfaces.starter.service.PacketService;
import org.omnifaces.util.Faces;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

@Named
@ViewScoped
public class PacketFormMB implements Serializable {

    @Inject
    private PacketService packetService;

    private Integer id;

    private Packet packet;

    public void init() {
        if(Faces.isAjaxRequest()){
            return;
        }

            packet = new Packet();

    }

    public void save() {
        String msg;

        packetService.savePacket(packet);
            msg = "Packet " + " created successfully";

        addDetailMessage(msg);
    }

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public void clear() {
        packet = new Packet();
        id = null;
    }

    public boolean isNew() {
        return packet == null || packet.getId() == null;
    }
}
