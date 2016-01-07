/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.szz.session;

import com.szz.model.dao.UserDAO;
import com.szz.model.entity.User;
import java.io.Serializable;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Grzeskoc
 */
@SessionScoped
public class UserSessionData implements Serializable {
    private User user;
    @Inject
    private UserDAO userDAO;
    
    public boolean loginUser(String nick, String password)
    {
        user = userDAO.findToLogin(nick, password);
        
        return user != null;
    }  

    public User getUser() {
        return user;
    }
    
    public void logoutUser()
    {
        user = null;
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public boolean isLogged()
    {
        return user != null;
    }
    
    
    public String showUserFullName()
    {
        return user.getFirstName()+ " " + user.getLastName();
    }
    
}
