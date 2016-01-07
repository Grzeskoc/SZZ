/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.szz.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Grzeskoc
 */
@Entity
public class Task implements Serializable{
    @Id
    @SequenceGenerator(name = "seqTask", sequenceName = "SEQ_TASK")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTask")
    protected Long id_task;
    @ManyToOne(targetEntity = MainTask.class)
    protected MainTask mainTask;
    @OneToMany(targetEntity=User.class)
    private Collection<User> userList;
    protected String description;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date end_Time;

    public Collection<User> getUserList() {
        return userList;
    }

    public void setUserList(Collection<User> userList) {
        this.userList = userList;
    }

    
    public Long getId_task() {
        return id_task;
    }

    public void setId_task(Long id_task) {
        this.id_task = id_task;
    }

    public MainTask getMainTask() {
        return mainTask;
    }

    public void setMainTask(MainTask mainTask) {
        this.mainTask = mainTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(Date end_Time) {
        this.end_Time = end_Time;
    }
    
    
}
