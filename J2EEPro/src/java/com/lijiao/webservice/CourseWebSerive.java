/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.webservice;

import com.lijiao.entity.Content;
import com.lijiao.entity.Course;
import com.lijiao.entity.User;
import com.lijiao.service.ContentService;
import com.lijiao.service.CourseService;
import com.lijiao.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "CourseWebSerive")
public class CourseWebSerive {

   
    @EJB
    private CourseService courseService;
    
    @EJB
    private UserService  userService;
    
     @EJB
    private ContentService  contentService;
    
    @WebMethod(operationName = "ListCourses")
    public List<Course> getAllCourses(){
    
        return courseService.listCourses();
    }
    
    @WebMethod(operationName = "GetCourseById")
    public Course getCourseById(@WebParam(partName = "Courseid")Long courseid){
        
        return courseService.findCourseByid(courseid);
    }
    
    @WebMethod(operationName = "GetTakenCourses")
    public List<Course> getTakenCourses(@WebParam(partName = "username")String username){
     
        User user= userService.findUserByName(username).get(0);
        List<Content> contents=contentService.findContentByUserId(user.getId());
        
        List<Course> takenCourses=new ArrayList<Course>();
        for(int i=0;i<contents.size();i++){
            
            takenCourses.add(courseService.findCourseByid(contents.get(i).getCourseid()));
        }
        return takenCourses; 
    }
}
