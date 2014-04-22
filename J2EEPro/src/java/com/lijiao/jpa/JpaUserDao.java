/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.jpa;

import com.lijiao.dao.UserDao;
import com.lijiao.entity.User;
import com.lijiao.md5.MD5;
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
public class JpaUserDao implements UserDao{

    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addUser(User user) {
       em.persist(user);
    }

    @Override
    public void removeUser(User user) {
        em.remove(user);
    }

    @Override
    public User findUserById(Long userId) {
     return em.find(User.class,userId);
    }

    @Override
    public List<User> findUserByName(String name) {
        
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<User> query=cb.createQuery(User.class);
        Root<User> userroot=query.from(User.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(cb.equal(userroot.<String>get("username"),name));
         query.where(predicates.toArray(new Predicate[predicates.size()]));
         return em.createQuery(query).getResultList();
          //return  em.createQuery("SELECT t FROM User t where t.username='"+name+"'").getResultList();

    }

    @Override
    public List<User> getAllUsers() {
          return  em.createQuery("SELECT t FROM User t").getResultList();     
    }



}
