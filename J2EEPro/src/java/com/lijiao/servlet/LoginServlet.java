/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.servlet;

import com.lijiao.entity.Course;
import com.lijiao.entity.User;
import com.lijiao.md5.MD5;
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


@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @EJB
    private UserService userService;
    
    @EJB
    private CourseService courseService;

    @EJB
    private QuestionService questionService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

          request.getRequestDispatcher("./register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          PrintWriter out=response.getWriter();
          String username = request.getParameter("username").toString();
          String password = request.getParameter("password").toString();
          boolean authen=true;
          
          MD5 md5= new MD5();
          String pass=md5.GetMD5Code(password);
       
          if(username.equals("")||password.equals("")){
          
              out.print("<script>alert('You must complete the information!');window.location.href='./index.jsp';</script>");
          }
          else if(username.equals("admin")&&password.equals("admin")){
          
               request.setAttribute("questions", questionService.showAllQuestions());
               request.getRequestDispatcher("./adminpage.jsp").forward(request, response);
          }
            else{
              
                User user = userService.findUserByName(username).get(0);
                if(pass.equals(user.getPassword())){               
                    String[] categorys=new String[]{"M1","B1","B2","B3","All"};
                    List<Course> courses=courseService.listCourses();
                    request.setAttribute("courses",courses);
                    request.setAttribute("user", user);
                    request.getSession().setAttribute("user", user);
                    request.setAttribute("categorys", categorys);
                    request.setAttribute("authen", authen);
                    request.getRequestDispatcher("./listcourses.jsp").forward(request, response);
                    
                }
                else{
                
                     out.print("<script type='text/javascript'>alert('The username or password is not right!');window.location.href='./index.jsp';</script>" );
                }
            } 
           
    }

}
