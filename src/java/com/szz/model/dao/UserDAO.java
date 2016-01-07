/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.szz.model.dao;

import com.szz.model.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Grzeskoc
 */

@Stateless
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;
    
    
    public User createUser(User user){
        try {
            entityManager.persist(user);
            return user;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public void updateUser(User user){
        entityManager.merge(user);
    }
    
    public void removeUser(User user){
        entityManager.remove(user);
    }
    
    public User findUser(Long id){
        return entityManager.find(User.class, id);
    }
    
    public User findUserRegister(String nick){
        Query query=entityManager.createNamedQuery("User.findByLoginRegistration",User.class);
        query.setParameter("nick", nick);
        try {
            return (User) query.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public User findToLogin(String nick,String password){
        Query query=entityManager.createNamedQuery("User.findByLogin",User.class);
        query.setParameter("nick", nick);
        query.setParameter("password", password);
        try {
            return (User) query.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public String userMenu(){
        return "user.xhtml";
    }
}
