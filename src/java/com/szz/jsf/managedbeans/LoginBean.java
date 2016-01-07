package com.szz.jsf.managedbeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.szz.session.UserSessionData;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;




@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String nick;
    private String password;
        
    @Inject
    private UserSessionData userSessionData;

    
    public String login(){
        userSessionData.loginUser(nick, password);
        if(userSessionData.getUser()==null){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Błąd logowania", "Podano niepoprawne dane."));
            return "";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sukces", "Wykonano udane logowanie."));
        return "logged.xhtml";
    }
    
    public String getLogin() {
        return nick;
    }

    public void setLogin(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String logoutUser() {
        userSessionData.logoutUser();

        return "index.xhtml";
    }
    
    public void checkIfAlreadyLogged() {
        if (userSessionData.isLogged()) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("mainPage.xhtml?faces-redirect=true");
            } catch (IOException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String showFullName() {
        return userSessionData.showUserFullName();
    }
    

}
