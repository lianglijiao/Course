/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.service;

import com.lijiao.dao.CourseDao;
import com.lijiao.entity.Course;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class CourseService {
    
    
    @EJB
    private CourseDao courseDao;
    
    public List<Course> listCourses(){
    
        return courseDao.listCourses();
    }
    
    public List<Course> listCoursesByCategory(String category){
       
        return courseDao.listCoursesByCategory(category);
    }
    
   public void addCourse(Course course){
   
       courseDao.addCourse(course);
   }
    
    public Course findCourseByid(Long id){
    
        return courseDao.findCourseById(id);
    }
}
