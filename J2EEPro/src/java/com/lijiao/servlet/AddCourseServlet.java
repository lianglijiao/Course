/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.servlet;

import com.lijiao.entity.Course;
import com.lijiao.service.CourseService;
import com.lijiao.service.QuestionService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddCourseServlet", urlPatterns = {"/AddCourseServlet"})
public class AddCourseServlet extends HttpServlet {

    @EJB
    private CourseService courseService;
    
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
        String coursename=request.getParameter("coursename");
        String des=request.getParameter("coursedes");
        String category=request.getParameter("category");
        if(coursename==""||des==""){
        
          
                 request.setAttribute("questions", questionService.showAllQuestions());
                 request.getRequestDispatcher("./adminpage.jsp").forward(request, response);
        }
        
//        out.print("<script>alert('"+coursename+"');</script>");
//        out.print("<script>alert('"+des+"');</script>");

        Course course=new Course();
        course.setCoursename(coursename);
        course.setDescription(des);
        course.setCategory(category);
        
        courseService.addCourse(course);
        
        request.setAttribute("questions", questionService.showAllQuestions());
         request.getRequestDispatcher("./adminpage.jsp").forward(request, response);
    }

 
}
