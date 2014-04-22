/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.servlet;

import com.lijiao.entity.Course;
import com.lijiao.service.CourseService;
import com.lijiao.service.QuestionService;
import com.lijiao.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AnonymousLoginServlet", urlPatterns = {"/AnonymousLoginServlet"})
public class AnonymousLoginServlet extends HttpServlet {
  @EJB
    private UserService userService;
    
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
             
 
          boolean authen=false;
                    String[] categorys=new String[]{"M1","B1","B2","B3","All"};
                    List<Course> courses=courseService.listCourses();
                    request.setAttribute("courses",courses);
                    request.setAttribute("categorys", categorys);
                  
                    request.setAttribute("authen", authen);
                    request.getRequestDispatcher("./listcourses.jsp").forward(request, response);;
    }

  
}
