/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.jpa;

import com.lijiao.dao.CourseDao;
import com.lijiao.entity.Course;
import com.lijiao.entity.Mark;
import com.lijiao.metamodel.Course_;
import com.lijiao.service.CourseService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Stateless
public class JpaCourseDao implements CourseDao{

    
    @PersistenceContext
    private EntityManager em;
    

    @Override
    public List<Course> listCourses() {
        return  em.createQuery("SELECT t FROM Course t").getResultList();     
    }

    @Override
    public List<Course> listCoursesByCategory(String category) {
        
        if(category.equals("All")){
        
            return  listCourses();
        }
        else{
          CriteriaBuilder cb = em.getCriteriaBuilder();
          CriteriaQuery<Course> query = cb.createQuery(Course.class);
          Root<Course> courseroot = query.from(Course.class);
         
          List<Predicate> predicates = new ArrayList<Predicate>();
          if(category!=null){
         
              predicates.add(cb.equal(courseroot.get(Course_.category), category));
              //predicates.add(cb.equal(courseroot.get("category").as(Course.class), category));
          }
          query.where(predicates.toArray(new Predicate[predicates.size()]));
          return em.createQuery(query).getResultList();          
        } 
    }

  

    @Override
    public Course findCourseById(Long id) {
      return  em.find(Course.class, id);
    }

    @Override
    public void addCourse(Course course) {
        em.persist(course);
    }
}
