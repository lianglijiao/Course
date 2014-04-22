package com.lijiao.servlet;
import com.lijiao.entity.Course;
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


@WebServlet(name = "FilterCourseServlet", urlPatterns = {"/FilterCourseServlet"})
public class FilterCourseServlet extends HttpServlet {

    
    @EJB
    private CourseService courseService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String category=request.getParameter("category");
        List<Course> courses=courseService.listCoursesByCategory(category);
        String[] categorys=new String[]{"M1","B1","B2","B3","All"};              
        request.setAttribute("courses",courses);
        request.setAttribute("authen", true);
        request.setAttribute("categorys", categorys);
        request.setAttribute("user",request.getSession().getAttribute("user"));
        request.getRequestDispatcher("./listcourses.jsp").forward(request, response);
        
    }

   
}
