/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.dao;

import com.lijiao.entity.Answer;
import javax.ejb.Local;


@Local
public interface AnswerDao {
    
    Answer getAnswerById(Long answerid);
    
    void addAnswer(Answer answer);
}
