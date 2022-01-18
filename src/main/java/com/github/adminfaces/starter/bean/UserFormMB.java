package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.starter.model.User;
import com.github.adminfaces.starter.service.UserService;
import org.omnifaces.util.Faces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;

@Named
@ViewScoped
public class UserFormMB implements Serializable {

    @Inject
    private UserService userService;

    private Integer id;

    private User user;

    public void init() {
        if(Faces.isAjaxRequest()){
            return;
        }

            user = new User();

    }

    public void save() {
        String msg;

        userService.saveUser(user);
            msg = "User " + " created successfully";

        addDetailMessage(msg);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void clear() {
        user = new User();
        id = null;
    }

    public boolean isNew() {
        return user == null || user.getId() == null;
    }
}
