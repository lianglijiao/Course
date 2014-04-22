/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.service;

import com.lijiao.entity.Course;
import com.lijiao.entity.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


@LocalBean
@Stateless
public class JMSService {
    
    
    
    public void PrintCertifications(List<Course> courses,User user) throws NamingException, JMSException{
    
        
         Context ctx = new InitialContext();

         ConnectionFactory connectionFactory =(ConnectionFactory) ctx.lookup("jms/Factory");
         Destination destination = (Destination) ctx.lookup("jms/Queue");
         
         Connection cnx = connectionFactory.createConnection();
         Session session =cnx.createSession(false, Session.AUTO_ACKNOWLEDGE);

         MessageProducer producer = session.createProducer(destination);

         TextMessage message = session.createTextMessage();
         String passedcourses="";
         for(int i=0;i<courses.size();i++){
           passedcourses=passedcourses+courses.get(i).getCoursename()+";";
         }
         Date d = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyMMddE HH:mm:ss");
         message.setText("Student name:"+user.getUsername()+"<br/>Course passed:"+passedcourses+"<br/>Date:"+sdf.format(d));
         producer.send(message);			    
         cnx.close();
        
    }
}
