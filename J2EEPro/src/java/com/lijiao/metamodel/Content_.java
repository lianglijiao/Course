/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.metamodel;

import com.lijiao.entity.Content;
import com.lijiao.entity.Course;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Content.class)
public class Content_ {
     public static volatile SingularAttribute<Content, Long> id;
     public static volatile SingularAttribute<Content, Long> userid;
     public static volatile SingularAttribute<Content, Long> courseid;
     public static volatile SingularAttribute<Content, Long> lastpage; 
}
