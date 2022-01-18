package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.model.Machine;
import com.github.adminfaces.starter.model.Service;
import com.github.adminfaces.starter.service.ClockService;
import com.github.adminfaces.starter.service.MachineService;
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
public class ServiceFormMB implements Serializable {

    @Inject
    private ClockService clockService;

    private Integer id;

    private Service service;

    public void init() {
        if(Faces.isAjaxRequest()){
            return;
        }

            service = new Service();

    }

    public void save() {
        String msg;


        clockService.saveClockService(service);
            msg = "Service " + " created successfully";
            addDetailMessage(msg);

    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void clear() {
        service = new Service();
        id = null;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return service == null || service.getId() == null;
    }


}
