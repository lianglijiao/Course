/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.metamodel;

import com.lijiao.entity.Mark;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Mark.class)
public class Mark_ {
      public static volatile SingularAttribute<Mark, Long> id;
     public static volatile SingularAttribute<Mark, Long> userid;
     public static volatile SingularAttribute<Mark, Long> courseid;
}
