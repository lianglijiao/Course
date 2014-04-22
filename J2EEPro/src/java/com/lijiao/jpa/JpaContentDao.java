/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.jpa;

import com.lijiao.dao.ContentDao;
import com.lijiao.entity.Content;
import com.lijiao.entity.Content_;

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
public class JpaContentDao  implements ContentDao{

   @PersistenceContext
   private EntityManager em;
   
    @Override
    public void addContent(Content content) {
       em.persist(content);
    }

    @Override
    public List<Content> findContent(Long userid, Long courseid) {
          CriteriaBuilder cb = em.getCriteriaBuilder();
          CriteriaQuery<Content> query = cb.createQuery(Content.class);
          Root<Content> contentroot = query.from(Content.class);
         
          List<Predicate> predicates = new ArrayList<Predicate>();

          predicates.add(cb.equal(contentroot.get(Content_.userid), userid));
          predicates.add(cb.equal(contentroot.get(Content_.courseid), courseid));
          
          query.where(predicates.toArray(new Predicate[predicates.size()]));
          return em.createQuery(query).getResultList();      
    }

    @Override
    public void updateContent(Content content) {
       em.merge(content);
    }

    @Override
    public List<Content> findContentByUserId(Long userid) {
      return em.createQuery("Select t from Content t where t.userid='"+userid+"'").getResultList();
    }
    
}
