package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.security.LogonMB;
import com.github.adminfaces.starter.model.Packet;
import com.github.adminfaces.starter.model.User;
import com.github.adminfaces.starter.service.PacketService;
import com.github.adminfaces.starter.service.UserService;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

/**
 * Created by rmpestano on 12/02/17.
 */
@Named
@ViewScoped
public class PacketChooseMB implements Serializable {

    @Inject
    UserService userService;

    @Inject
    PacketService packetService;

    Integer id;

    List<User> users;

    Filter<User> filter = new Filter<User>(new User());


    @PostConstruct
    public void initDataModel() {
        users = userService.getAllUser();

        List<Packet> packetList= packetService.getAllPacket();
        if (packetList.isEmpty() || packetList==null ) {

            Packet packet = new Packet();
            packet.setPrice(100.0);
            packet.setServiceCount(5);
            packet.setId(1);
            packetService.savePacket(packet);

             packet = new Packet();
            packet.setPrice(200.0);
            packet.setServiceCount(10);
            packet.setId(2);
            packetService.savePacket(packet);


            packet = new Packet();
            packet.setPrice(300.0);
            packet.setServiceCount(5);
            packet.setId(3);
            packetService.savePacket(packet);

        }
    }

    public void clear() {
        filter = new Filter<User>(new User());
    }


    public void savePacket1() {
        //paket statik degil secilen degerler alınıp set edilecek.
        if (LogonMB.userId!=null) {
            User auser = userService.findById(LogonMB.userId);
            auser.setPacketId(1);
            auser.setServiceRightCount(5);
            Packet packet = packetService.findById(1);
            Set<Packet> packets;
            if (auser.getPackets()==null || auser.getPackets().isEmpty()) {
               packets = new HashSet<Packet>();
            }
            else {
                packets=auser.getPackets();
            }

            packets.add(packet);
            auser.setPackets(packets);
            userService.update(auser);
        }
    }

    public void savePacket2() {
        if (LogonMB.userId!=null) {
            User auser = userService.findById(LogonMB.userId);
            auser.setPacketId(2);
            auser.setServiceRightCount(10);
            Packet packet = packetService.findById(2);
            Set<Packet> packets;
            if (auser.getPackets()==null || auser.getPackets().isEmpty()) {
                packets = new HashSet<Packet>();
            }
            else {
                packets=auser.getPackets();
            }

            packets.add(packet);
            auser.setPackets(packets);
            userService.update(auser);
        }
    }

    public void savePacket3() {
        if (LogonMB.userId!=null) {
            User auser = userService.findById(LogonMB.userId);
            auser.setPacketId(3);
            auser.setServiceRightCount(30);
            Packet packet = packetService.findById(3);
            Set<Packet> packets;
            if (auser.getPackets()==null || auser.getPackets().isEmpty()) {
                packets = new HashSet<Packet>();
            }
            else {
                packets=auser.getPackets();
            }

            packets.add(packet);
            auser.setPackets(packets);
            userService.update(auser);
        }
    }

}
