/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.dao;

import com.lijiao.entity.User;
import java.util.List;
import javax.ejb.Local;


@Local
public interface UserDao {
    
    void addUser(User user);
    
    void removeUser(User user);
    
    User findUserById(Long userId);
    
    List<User> findUserByName(String name);
    
    List<User> getAllUsers();
    
   
}
