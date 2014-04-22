/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.dao;

import com.lijiao.entity.Course;
import java.util.List;
import javax.ejb.Local;


@Local
public interface CourseDao {
    
    List<Course> listCourses();
    
    Course findCourseById(Long id);
    
    List<Course> listCoursesByCategory(String category);
    
    void addCourse(Course course);
    
}
