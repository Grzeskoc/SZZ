/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.szz.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Grzeskoc
 */
@Entity
public class Position implements Serializable{
    @Id
    @SequenceGenerator(name = "seqPosition", sequenceName = "SEQ_POSITION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPosition")
    protected Long id_poss;
    @OneToMany(targetEntity = User.class )
    protected Collection<User> userList;
    protected String name;

    public Long getId_poss() {
        return id_poss;
    }

    public void setId_poss(Long id_poss) {
        this.id_poss = id_poss;
    }

    public Collection<User> getUserList() {
        return userList;
    }

    public void setUserList(Collection<User> userList) {
        this.userList = userList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
