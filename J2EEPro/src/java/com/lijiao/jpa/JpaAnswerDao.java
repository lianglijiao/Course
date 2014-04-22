/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.jpa;

import com.lijiao.dao.AnswerDao;
import com.lijiao.entity.Answer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class JpaAnswerDao implements AnswerDao{

    
    @PersistenceContext 
    private  EntityManager em;
            
    @Override
    public Answer getAnswerById(Long answerid) {
       return em.find(Answer.class, answerid);
    }

    @Override
    public void addAnswer(Answer answer) {
        em.persist(answer);
    }
    
}
