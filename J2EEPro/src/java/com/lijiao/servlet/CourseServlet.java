/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.servlet;

import com.lijiao.entity.Content;
import com.lijiao.entity.Course;
import com.lijiao.entity.User;
import com.lijiao.service.ContentService;
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


@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {

    @EJB
    private ContentService contentService;
    
    
    @EJB
    private CourseService courseService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
       Long userid= Long.valueOf(request.getParameter("uid").toString());
       Long cid=Long.valueOf(request.getParameter("cid").toString());
       request.getSession().setAttribute("userid", request.getParameter("uid"));
       request.getSession().setAttribute("courseid", request.getParameter("cid"));
     
      if(contentService.findContent(userid,cid).size()<=0){
      
             request.setAttribute("pagenumber", 1);
             request.getRequestDispatcher("./course.jsp").forward(request, response);
      }
      else{
      
          request.setAttribute("pagenumber", contentService.findContent(userid, cid).get(0).getLastpage());
          request.getRequestDispatcher("./course.jsp").forward(request, response);
      }
      
      
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       Long lastpage=Long.valueOf(request.getParameter("page").toString());
       Long userid=Long.valueOf(request.getSession().getAttribute("userid").toString());
       Long courseid=Long.valueOf(request.getSession().getAttribute("courseid").toString());
       if(contentService.findContent(userid, courseid).size()>0){
       
           Content content=contentService.findContent(userid, courseid).get(0);
           content.setLastpage(lastpage);
           contentService.updateContent(content);
           
       }
       else{
       
           Content content=new Content();
           content.setCourseid(courseid);
           content.setUserid(userid);
           content.setLastpage(lastpage);
           contentService.addContent(content);
       }
                    User user=(User) request.getSession().getAttribute("user");
                    String[] categorys=new String[]{"M1","B1","B2","B3","All"};
                    List<Course> courses=courseService.listCourses();
                    request.setAttribute("courses",courses);
                    request.setAttribute("authen", true);
                    request.setAttribute("user",user);
                    request.setAttribute("categorys", categorys);
                    request.getRequestDispatcher("./listcourses.jsp").forward(request, response);
       
    }

  
}
