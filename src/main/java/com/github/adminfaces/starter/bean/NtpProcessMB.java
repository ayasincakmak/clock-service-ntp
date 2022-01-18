package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.infra.security.LogonMB;
import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.starter.model.Packet;
import com.github.adminfaces.starter.model.User;
import com.github.adminfaces.starter.service.CarService;
import com.github.adminfaces.starter.service.NTPClient;
import com.github.adminfaces.starter.service.PacketService;
import com.github.adminfaces.starter.service.UserService;
import com.github.adminfaces.template.exception.BusinessException;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

/**
 * Created by rmpestano on 12/02/17.
 */
@Named
@ViewScoped
public class NtpProcessMB implements Serializable {

    private String ntpHost;


    private String resultNtpClient;

    private Integer serviceRightCount;

    private boolean newpacketButton;

    private Double totalFee;


    @Inject
    UserService userService;

    @Inject
    PacketService packetService;

    public void setNtpHost(String ntpHost) {
        this.ntpHost = ntpHost;
    }

    public String getNtpHost() {
        return ntpHost;
    }


    @PostConstruct
    public void initDataModel() {

        if (LogonMB.userId != null) {
            User auser = userService.findById(LogonMB.userId);
            if (auser.getPackets().isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Paket alınız",
                        null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                this.newpacketButton = true;
            } else {
                if (auser.getServiceRightCount() > 0) {
                    this.serviceRightCount = auser.getServiceRightCount();
                } else {
                    this.serviceRightCount = 0;
                    this.newpacketButton = false;
                }
            }

            calculateFee();
        }


    }


    public void getNtpInfo() {
        resultNtpClient = "";
        NTPClient ntpClient = new NTPClient();
        if (isValidIPAddress(ntpHost)) {
            boolean serviceRightControl = updateUserService();
            if (serviceRightControl) {
                //resultNtpClient = ntpClient.getNtpInfo(ntpHost);
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Gecersiz IP adres",
                    null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    private boolean updateUserService() {
        if (LogonMB.userId != null) {
            User auser = userService.findById(LogonMB.userId);
            if (auser.getServiceRightCount() > 0) {
                auser.setServiceRightCount(auser.getServiceRightCount() - 1);
                userService.update(auser);
                this.serviceRightCount = auser.getServiceRightCount();
                this.newpacketButton = false;
                return true;
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Paket kullanım hakkı dolmuştur. Yeni Paket Satın alınız", null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                this.newpacketButton = true;

                return false;
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Kullanıcı Bulunmadı", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return false;
        }

    }

    public String getResultNtpClient() {
        return resultNtpClient;
    }

    public void setResultNtpClient(String resultNtpClient) {
        this.resultNtpClient = resultNtpClient;
    }

    public static boolean isValidIPAddress(String ip) {

        // Regex for digit from 0 to 255.
        String zeroTo255
                = "(\\d{1,2}|(0|1)\\"
                + "d{2}|2[0-4]\\d|25[0-5])";

        // Regex for a digit from 0 to 255 and
        // followed by a dot, repeat 4 times.
        // this is the regex to validate an IP address.
        String regex
                = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the IP address is empty
        // return false
        if (ip == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given IP address
        // and regular expression.
        Matcher m = p.matcher(ip);

        // Return if the IP address
        // matched the ReGex
        return m.matches();
    }

    public Integer getServiceRightCount() {
        return serviceRightCount;
    }

    public void setServiceRightCount(Integer serviceRightCount) {
        this.serviceRightCount = serviceRightCount;
    }

    public boolean isNewpacketButton() {
        return newpacketButton;
    }

    public void setNewpacketButton(boolean newpacketButton) {
        this.newpacketButton = newpacketButton;
    }

    public void calculateFee() {
        Set<Packet> packetList = userService.getUserPacketList(LogonMB.userId);
        Double totalFee = 0.0;
        if (packetList != null && !packetList.isEmpty()) {
            for (Packet packet : packetList) {
                Packet packetFromDB = packetService.findById(packet.getId());
                totalFee = totalFee + packetFromDB.getPrice();
            }
        }
        this.totalFee = totalFee;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }
}
