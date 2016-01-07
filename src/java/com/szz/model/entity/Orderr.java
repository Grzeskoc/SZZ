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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Grzeskoc
 */
@Entity
public class Orderr implements Serializable{
    @Id
    @SequenceGenerator(name = "seqOrder", sequenceName = "SEQ_ORDER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrder")
    protected Long id_order;
    @OneToMany(targetEntity=Task.class)
    private Collection<MainTask> mainTask;
    protected String description;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date admission_Time;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date end_Time;

    
    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public Collection<MainTask> getMainTask() {
        return mainTask;
    }

    public void setMainTask(Collection<MainTask> mainTask) {
        this.mainTask = mainTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAdmission_Time() {
        return admission_Time;
    }

    public void setAdmission_Time(Date admission_Time) {
        this.admission_Time = admission_Time;
    }

    public Date getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(Date end_Time) {
        this.end_Time = end_Time;
    }
    
    
}
