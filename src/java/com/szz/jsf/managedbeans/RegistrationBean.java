/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szz.jsf.managedbeans;


import com.szz.model.dao.UserDAO;
import com.szz.model.entity.User;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class RegistrationBean {
    private User user;
    
    @Inject
    private UserDAO userDAO;
    
    @PostConstruct
    private void init(){
        user=new User();
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String register(){
        if((userDAO.findUserRegister(user.getNick()))==null){
            userDAO.createUser(user);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sukces", "Poprawna rejestracja."));
            
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Błąd rejestracji", "Podano niepoprawne dane."));
        }        
        return "";
    }
}