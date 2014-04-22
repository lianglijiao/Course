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


@WebServlet(name = "AddQuestionServlet", urlPatterns = {"/AddQuestionServlet"})
public class AddQuestionServlet extends HttpServlet {

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
        String question=request.getParameter("questioncontent");
        
        if(question==""){
        
           
                 request.setAttribute("questions", questionService.showAllQuestions());
                 request.getRequestDispatcher("./adminpage.jsp").forward(request, response);
        }
        else{
        
             Question q=new Question();
        q.setQuescontent(question);
        questionService.addQuesiton(q);
        
       
        
         request.setAttribute("questions", questionService.showAllQuestions());
         request.getRequestDispatcher("./adminpage.jsp").forward(request, response);
        }
       
        
    }

}
