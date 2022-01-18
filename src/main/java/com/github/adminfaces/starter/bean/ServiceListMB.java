package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.Machine;
import com.github.adminfaces.starter.model.Service;
import com.github.adminfaces.starter.service.ClockService;
import com.github.adminfaces.starter.service.MachineService;
import com.github.adminfaces.template.exception.BusinessException;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.Clock;
import java.util.List;

/**
 * Created by rmpestano on 12/02/17.
 */
@Named
@ViewScoped
public class ServiceListMB implements Serializable {



    @Inject
    ClockService clockService;

    Integer id;


    List<Service> services;


    Filter<Service> filter = new Filter<Service>(new Service());

    List<Service> selectedServices; //clock services selected in checkbox column

    List<Service> filteredValue;// datatable filteredValue attribute (column filters)

    @PostConstruct
    public void initDataModel() {
        services = clockService.getAllClockServices();
    }

    public void clear() {
        filter = new Filter<Service>(new Service());
    }



    public void findServiceById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide Service ID to load");
        }
        selectedServices.add(clockService.findById(id));
    }

    public void delete() {
//        int numCars = 0;
//        for (User selectedUser : selectedUsers) {
//            numCars++;
//            userService.deleteUser(selectedUser);
//        }
//        selectedUsers.clear();
//        addDetailMessage(numCars + " user deleted successfully!");
    }

    public List<Service> getSelectedServices() {
        return selectedServices;
    }

    public List<Service> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Service> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public void setSelectedMachines(List<Service> selectedMachines) {
        this.selectedServices = selectedServices;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Filter<Service> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Service> filter) {
        this.filter = filter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
