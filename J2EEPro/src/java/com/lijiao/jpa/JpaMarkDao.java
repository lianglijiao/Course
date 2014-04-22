/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.jpa;

import com.lijiao.dao.MarkDao;
import com.lijiao.entity.Course;
import com.lijiao.entity.Mark;
import com.lijiao.metamodel.Mark_;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Stateless
public class JpaMarkDao implements MarkDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addMark(Mark mark) {
       em.persist(mark);
    }

 

    @Override
    public void updateMark(Mark mark) {
        em.merge(mark);
    }

    @Override
    public List<Mark> findMark(Long userid, Long courseid) {
        
          CriteriaBuilder cb = em.getCriteriaBuilder();
          CriteriaQuery<Mark> query = cb.createQuery(Mark.class);
          Root<Mark> markroot = query.from(Mark.class);
         
          List<Predicate> predicates = new ArrayList<Predicate>();

          predicates.add(cb.equal(markroot.get(Mark_.userid), userid));
          predicates.add(cb.equal(markroot.get(Mark_.courseid), courseid));
          
          query.where(predicates.toArray(new Predicate[predicates.size()]));
          return em.createQuery(query).getResultList();      
    }

    @Override
    public List<Mark> getPassedmark(Long userid) {
        List<Mark> marks=em.createQuery("select t from Mark t where t.ispassed=true and t.userid='"+userid+"'").getResultList();
        return marks;
    }

}
