/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.metamodel;

import com.lijiao.entity.Course;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Course.class)
public class Course_ {
     public static volatile SingularAttribute<Course, Long> id;
     public static volatile SingularAttribute<Course, String> category;
     public static volatile SingularAttribute<Course, String> coursename;
     public static volatile SingularAttribute<Course, String> description; 
     
}
