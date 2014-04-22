/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.servlet;

import com.lijiao.entity.User;
import com.lijiao.md5.MD5;
import com.lijiao.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    @EJB
    private UserService userService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        boolean auth=true;

         MD5 md5= new MD5();
         String code=md5.GetMD5Code(password);
          
      if(username.equals("")||password.equals("")){
          
              out.print("<script>alert('You must complete the information!');window.location.href='./register.jsp';</script>");
          }
    
            User user=new User();
            user.setUsername(username);
            user.setPassword(code);
            user.setIsauthen(auth);
            userService.addUser(user);
            out.print("<script type='text/javascript'>alert('Register is Ok!');window.location.href='./index.jsp';</script>" );

    }

   
}
