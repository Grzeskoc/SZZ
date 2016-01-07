/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.szz.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Grzeskoc
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "User.findByLogin",query = "Select u from User u where u.nick=:nick and u.password=:password"),
    @NamedQuery(name = "User.findByLoginRegistration",query = "Select u from User u where u.nick=:nick")
        })
public class User implements Serializable{
    @Id
    @SequenceGenerator(name = "seqUser", sequenceName = "SEQ_USER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUser")
    protected Long id;
    @Column(unique = true)
    protected String nick;
    protected String firstName;
    protected String lastName;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date reg_date;
    protected String password;
    @ManyToOne(targetEntity = Task.class)
    protected Task task;
     @ManyToOne(targetEntity = Position.class)
    protected Position position;

     
     
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

     
     
     
    public Task getTask() {
        return task;
    }

    public void setTask(Task Task) {
        this.task = task;
    }




    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

     @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
