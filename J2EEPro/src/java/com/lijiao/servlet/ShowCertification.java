/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.servlet;

import com.lijiao.entity.Course;
import com.lijiao.entity.Mark;
import com.lijiao.entity.User;
import com.lijiao.service.CourseService;
import com.lijiao.service.JMSService;
import com.lijiao.service.MarkService;
import com.lijiao.service.UserService;
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


@WebServlet(name = "ShowCertification", urlPatterns = {"/ShowCertification"})
public class ShowCertification extends HttpServlet {

  
     @EJB
    private CourseService courseService;
    
    @EJB
    private JMSService jmsService;
    
    @EJB
    private MarkService markService;

    @EJB
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              //PrintWriter out=response.getWriter();
 
              
        List<Mark> passedMark=markService.getPassedMark(Long.valueOf(request.getParameter("uid").toString()));
        User user=userService.findUserById(Long.valueOf(request.getParameter("uid").toString()));

        List<Course> passedCourses=new ArrayList<Course>();
        for(int i=0;i<passedMark.size();i++){
        
            passedCourses.add(courseService.findCourseByid(passedMark.get(i).getCourseid()));
        }
        
        request.setAttribute("user", user);
        request.setAttribute("passedcourses", passedCourses);
        
        request.getRequestDispatcher("./certification.jsp").forward(request, response);

           
    }

}
