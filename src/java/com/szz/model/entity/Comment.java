/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.szz.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Grzeskoc
 */
@Entity
public class Comment {
    @Id
    @SequenceGenerator(name = "seqComment", sequenceName = "SEQ_COMMENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqComment")
    protected Long id_Comment;
    protected String text;
    
}
