/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.servlet;

import com.lijiao.entity.Course;
import com.lijiao.entity.User;
import com.lijiao.service.CourseService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListCourseServlet", urlPatterns = {"/ListCourseServlet"})
public class ListCourseServlet extends HttpServlet {


    @EJB
    private CourseService courseService;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
                    User user=(User) request.getSession().getAttribute("user");
                    String[] categorys=new String[]{"M1","B1","B2","B3","All"};
                    List<Course> courses=courseService.listCourses();
                    request.setAttribute("courses",courses);
                    request.setAttribute("user",user);
                    request.setAttribute("authen", true);
                    request.setAttribute("categorys", categorys);
                    request.getRequestDispatcher("./listcourses.jsp").forward(request, response);
                    
    }

}
