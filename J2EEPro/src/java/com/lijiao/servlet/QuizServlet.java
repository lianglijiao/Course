/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.servlet;

import com.lijiao.dao.MarkDao;
import com.lijiao.entity.Mark;
import com.lijiao.entity.Question;
import com.lijiao.service.AnswerService;
import com.lijiao.service.CourseService;
import com.lijiao.service.MarkService;
import com.lijiao.service.QuestionService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet(name = "QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {

    @EJB
    private QuestionService questionService;
    
    @EJB
    private AnswerService answerService;

    @EJB
    private MarkService markService;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Question> questions=questionService.showAllQuestions();
        //request.getSession().setAttribute("number", questionService.showAllQuestions().size());
        request.setAttribute("questions", questions);
        request.getSession().setAttribute("userid", request.getParameter("uid"));
        request.getSession().setAttribute("courseid", request.getParameter("cid"));
        request.getRequestDispatcher("/quiz.jsp").forward(request, response);
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out=response.getWriter();
        double mark=0;
        int questioncount=questionService.showAllQuestions().size();
        double permark=20/questioncount;
        
        for(int i=1;i<= questionService.showAllQuestions().size();i++){
              
            Long answerid=Long.valueOf(request.getParameter("answerid"+String.valueOf(i)).toString());
            if(answerService.getAnswerById(answerid).isIsright()==true){              
                mark=mark+permark;               
            } 
        }
        
            Long courseid=Long.valueOf(request.getSession().getAttribute("courseid").toString());
            Long userid=Long.valueOf(request.getSession().getAttribute("userid").toString());
            if(markService.findMark(userid, courseid).size()>0){
                
                Mark markentity=markService.findMark(userid, courseid).get(0);
                markentity.setMark(mark);
                 if(mark>=10){           
                         markentity.setIspassed(true);
                    }
                       else{
                         markentity.setIspassed(false);
                    }       
                
                 markService.updateMark(markentity);
                 doGet(request, response);
            }
            else{         
                    Mark markentity=new Mark();
                    markentity.setCourseid(courseid);
                    markentity.setUserid(userid);
                    markentity.setMark(mark);
                    if(mark>=10){           
                         markentity.setIspassed(true);
                    }
                       else{
                         markentity.setIspassed(false);
                    }          
                    markService.addMark(markentity);   
                    doGet(request, response);
            }
   
    }
}
