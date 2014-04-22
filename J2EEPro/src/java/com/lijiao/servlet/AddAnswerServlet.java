/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.servlet;

import com.lijiao.entity.Answer;
import com.lijiao.entity.Question;
import com.lijiao.service.AnswerService;
import com.lijiao.service.QuestionService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddAnswerServlet", urlPatterns = {"/AddAnswerServlet"})
public class AddAnswerServlet extends HttpServlet {

    @EJB
   private AnswerService answerService;
   
   @EJB
   private QuestionService questionService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        PrintWriter out=response.getWriter();
        
        Question question=questionService.findQuestionById(Long.valueOf(request.getParameter("questiondada").toString()));
        String rightc= request.getParameter("rightanswer");
        String wrongc=request.getParameter("wronganswer");
        if(rightc==""||wrongc==""){
        
                 request.setAttribute("questions", questionService.showAllQuestions());
                 request.getRequestDispatcher("./adminpage.jsp").forward(request, response);
             
        }
        Answer rightanswer=new Answer();
        rightanswer.setQuestion(question);
        rightanswer.setIsright(true);
        rightanswer.setAnscontent(rightc);
        answerService.addAnswer(rightanswer);
        
        
        Answer wronganswer=new Answer();
        wronganswer.setQuestion(question);
        wronganswer.setIsright(false);
        wronganswer.setAnscontent(wrongc);
        answerService.addAnswer(wronganswer);
        
        List<Answer> answers=new ArrayList<Answer>();
        answers.add(wronganswer);
        answers.add(rightanswer);
        question.setAnswers(answers);
        
        questionService.updateQuestion(question);
        
        
          request.setAttribute("questions", questionService.showAllQuestions());
         request.getRequestDispatcher("./adminpage.jsp").forward(request, response);
    }

}
