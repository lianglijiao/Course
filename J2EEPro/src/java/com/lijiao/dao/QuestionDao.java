/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.dao;

import com.lijiao.entity.Question;
import java.util.List;
import javax.ejb.Local;


@Local
public interface QuestionDao {
   
    void addQuestion(Question question);
    
    void removeQuestion(Question question);
    
    List<Question> showAllQuestions();
    
    Question findQuestionById(Long id);
    
    void UpdateQuestion(Question question);
    
}
