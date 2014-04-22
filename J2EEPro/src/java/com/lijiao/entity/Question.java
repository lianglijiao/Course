/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String quescontent;
    

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    


    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    

    public String getQuescontent() {
        return quescontent;
    }

    public void setQuescontent(String quescontent) {
        this.quescontent = quescontent;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
    
}
