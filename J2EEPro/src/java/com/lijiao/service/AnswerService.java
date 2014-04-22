/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.service;

import com.lijiao.dao.AnswerDao;
import com.lijiao.entity.Answer;
import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class AnswerService {
    
    @EJB
    private AnswerDao answerDao;
    
    public Answer getAnswerById(Long answerid){
    
        return answerDao.getAnswerById(answerid);
    }
    
    
    public void addAnswer(Answer answer){
    
         answerDao.addAnswer(answer);
    }
}
