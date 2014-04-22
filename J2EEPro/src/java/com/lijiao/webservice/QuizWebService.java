/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.webservice;

import com.lijiao.entity.Question;
import com.lijiao.service.QuestionService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "QuizWebService")
public class QuizWebService {

    /**
     * This is a sample web service operation
     */
    @EJB
    private QuestionService questionService;
    
    @WebMethod(operationName = "Quiz")
    public String showAllQuestions(){
        String quiz ="";
        List<Question> questions=questionService.showAllQuestions();
        for(int i=1;i<=questions.size();i++){
        
            quiz+= String.valueOf(i)+questions.get(i-1).getQuescontent()+" ";
           
        }
     
        return quiz;
        
        
    }
    
}
