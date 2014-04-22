/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.jpa;

import com.lijiao.dao.QuestionDao;
import com.lijiao.entity.Question;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class JpaQuestionDao implements QuestionDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addQuestion(Question question) {
       em.persist(question);
    }

    @Override
    public void removeQuestion(Question question) {
        em.remove(question);
    }

    @Override
    public List<Question> showAllQuestions() {
         return em.createQuery("select t from Question t").getResultList();
    }

    @Override
    public Question findQuestionById(Long id) {
       return  em.find(Question.class, id);
    }

    @Override
    public void UpdateQuestion(Question question) {
        em.merge(question);
    }


    
}
