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
import javax.persistence.JoinColumn;
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
public class MainTask implements Serializable{
    @Id
    @SequenceGenerator(name = "seqMainTask", sequenceName = "SEQ_MAINTASK")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMainTask")
    protected Long id_mainTask;
    @OneToMany(targetEntity=Task.class)
    private Collection<Task> Task;
    @ManyToOne(targetEntity = Orderr.class)
    protected Orderr order;
    protected String description;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date end_Time;

    public Orderr getOrder() {
        return order;
    }

    public void setOrder(Orderr order) {
        this.order = order;
    }

    public Long getId_mainTask() {
        return id_mainTask;
    }

    public void setId_mainTask(Long id_mainTask) {
        this.id_mainTask = id_mainTask;
    }

    public Collection<Task> getTask() {
        return Task;
    }

    public void setTask(Collection<Task> Task) {
        this.Task = Task;
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
