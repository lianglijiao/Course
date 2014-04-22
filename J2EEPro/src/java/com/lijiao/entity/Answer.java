/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String anscontent;

    @Column
    private boolean isright;
    
    
    @ManyToOne @JoinColumn(name="question_id")
   private Question question;

    public boolean isIsright() {
        return isright;
    }

    public void setIsright(boolean isright) {
        this.isright = isright;
    }
    
    

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public String getAnscontent() {
        return anscontent;
    }

    public void setAnscontent(String anscontent) {
        this.anscontent = anscontent;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    
}
