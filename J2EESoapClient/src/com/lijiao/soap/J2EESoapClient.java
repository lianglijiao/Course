/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package com.lijiao.soap;

import com.lijiao.webservice.Course;
import com.lijiao.webservice.CourseWebSerive;
import com.lijiao.webservice.CourseWebSerive_Service;
import com.lijiao.webservice.QuizWebService;
import com.lijiao.webservice.QuizWebService_Service;
import com.lijiao.webservice.User;
import com.lijiao.webservice.UserWebService;
import com.lijiao.webservice.UserWebService_Service;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 申
 */
public class J2EESoapClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int token = 0;
        boolean b=true;
        String username = null;
        String password=null;
        UserWebService_Service userWebService=new UserWebService_Service();
        UserWebService userService=userWebService.getUserWebServicePort();
        
        CourseWebSerive_Service courseWebService=new CourseWebSerive_Service();
        CourseWebSerive courseService=courseWebService.getCourseWebSerivePort();
        
        
        QuizWebService_Service quizWebService=new QuizWebService_Service();
        QuizWebService quizService=quizWebService.getQuizWebServicePort();
        
        Scanner reader;
         System.out.println("--------Menu--------");
            System.out.println("1 - Authenticate");
            System.out.println("10 - Get a user");
            System.out.println("11 - List courses"); 
            System.out.println("12 - Get course");
            System.out.println("20 - Take a course");
            System.out.println("21 - Pass quiz");
            System.out.println("22 - Print cetification");
            System.out.println("40 - Exit");
           
            while(b){
            
            System.out.println("Plesae input a number:");
            reader = new Scanner(System.in);
            int n=reader.nextInt();
            switch(n){
                
                case 1:{

                    System.out.println("plesae input the username:");
                    username=reader.next();
                    System.out.println("plesae input the password:");
                    password=reader.next();
                    token=userService.getAuthenticate(username, password);
                    break;
                }

                case 10:{
                    if(token==1){
                        for(User u:userService.showAllUsers()){
                        
                             System.out.println("Userid:"+u.getId().toString());
                        }
                        System.out.println("plesae input the userid you want");
                        Long userid=reader.nextLong();
                        User user=userService.getUserById(userid);
                        System.out.println("Name:"+user.getUsername()+" password:"+user.getPassword());
                                             
                    }
                    else{
                      System.out.println("you should make a authentication first!");
                     }

                    break; 
                }
                case 11:{
                
                    List<Course> courses=courseService.listCourses();
                    for(Course c:courses){
                    
                          System.out.println("Course:"+c.getCoursename()+" description:"+c.getDescription()+" category:"+c.getCategory());
                    }
            
                   break;
                }
                    
                case 12:{
                    for(Course c:courseService.listCourses()){
                    
                        System.out.println("Courseid:"+c.getId().toString());
                    }
                    System.out.println("plesae input the courseid you want:");
                    Long courseid=reader.nextLong();
                    Course course=courseService.getCourseById(courseid);
                    System.out.println("Name:"+course.getCoursename()+" description:"+course.getDescription()+" category:"+course.getCategory());
                    break;
                }
                 
                case 20:{
                     if(token==1){
                     
                         System.out.println("Taken courses");
                         List<Course> takenCourses=courseService.getTakenCourses(username);
                         for(Course c:takenCourses){
                         
                             System.out.println("Name:"+c.getCoursename()+" description:"+c.getDescription()+" category:"+c.getCategory());
                         }
                         
                     }
                     else{
                      System.out.println("you should make a authentication first!");
                     }
                     break;                     
                }
                    
                case 21:{
                
                         if(token==1){

                             System.out.println(quizService.quiz());
                         
                     }
                     else{
                      System.out.println("you should make a authentication first!");
                     }
                         break;
                    
                }
                    
                case 22:{
                   
                        if(token==1){
                     
                     }
                     else{
                      System.out.println("you should make a authentication first!");
                     }
                        break;
                    
                }
                    
                
               case 40:{System.out.println("bye");b=false;break;}
               default:{
                   System.out.println("please input the correct number");break;}
               
            }
     
            }
           
        
    }
}
