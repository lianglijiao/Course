/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.service;

import com.lijiao.dao.QuestionDao;
import com.lijiao.entity.Question;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class QuestionService {
    
    @EJB
    private QuestionDao questionDao;
    
    public void addQuesiton(Question question){
    
        questionDao.addQuestion(question);
    }
    
    public void removeQuestion(Question question){
    
        questionDao.removeQuestion(question);
    }
    
    public List<Question> showAllQuestions(){
    
        return questionDao.showAllQuestions();
    }
    
    public Question findQuestionById(Long id){
    
        return questionDao.findQuestionById(id);
    }
    
    public void updateQuestion(Question question){
    
        questionDao.UpdateQuestion(question);
    }
    

}
