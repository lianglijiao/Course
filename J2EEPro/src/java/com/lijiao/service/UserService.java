/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.service;

import com.lijiao.dao.UserDao;
import com.lijiao.entity.User;
import com.lijiao.md5.MD5;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class UserService {
    
    @EJB
    private UserDao userDao;
    
    public void addUser(User user) {
      userDao.addUser(user);
    }


    public void removeUser(User user) {
       userDao.removeUser(user);
    }


    public User findUserById(Long userId) {
       return userDao.findUserById(userId);
    }

    public List<User> findUserByName(String name) {
          return  userDao.findUserByName(name);

    }

    public List<User> getAllUsers() {
          return userDao.getAllUsers();
    }
    
    
}
