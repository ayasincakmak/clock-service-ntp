package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.model.Machine;
import com.github.adminfaces.starter.model.User;
import com.github.adminfaces.starter.service.MachineService;
import com.github.adminfaces.starter.service.UserService;
import org.omnifaces.util.Faces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

@Named
@ViewScoped
public class MachineFormMB implements Serializable {

    @Inject
    private MachineService machineService;

    private Integer id;

    private Machine machine;

    public void init() {
        if(Faces.isAjaxRequest()){
            return;
        }

            machine = new Machine();

    }

    public void save() {
        String msg;

        if (isValidIPAddress(machine.getMachineIp())) {
            machineService.saveMachine(machine);
            msg = "Machine " + " created successfully";
            addDetailMessage(msg);
        }
        else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Gecersiz IP adres", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public void clear() {
        machine = new Machine();
        id = null;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return machine == null || machine.getId() == null;
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

}
