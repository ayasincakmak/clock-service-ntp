package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.Machine;
import com.github.adminfaces.starter.model.User;
import com.github.adminfaces.starter.service.MachineService;
import com.github.adminfaces.starter.service.UserService;
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
public class MachineListMB implements Serializable {

    @Inject
    MachineService machineService;

    Integer id;

    List<Machine> machines;

    Filter<Machine> filter = new Filter<Machine>(new Machine());

    List<Machine> selectedMachines; //cars selected in checkbox column

    List<Machine> filteredValue;// datatable filteredValue attribute (column filters)

    @PostConstruct
    public void initDataModel() {
        machines = machineService.getAllMachines();
    }

    public void clear() {
        filter = new Filter<Machine>(new Machine());
    }



    public void findMachineById(Integer id) {
        if (id == null) {
            throw new BusinessException("Provide Machine ID to load");
        }
        selectedMachines.add(machineService.findById(id));
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

    public List<Machine> getSelectedMachines() {
        return selectedMachines;
    }

    public List<Machine> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Machine> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public void setSelectedMachines(List<Machine> selectedMachines) {
        this.selectedMachines = selectedMachines;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public Filter<Machine> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Machine> filter) {
        this.filter = filter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
