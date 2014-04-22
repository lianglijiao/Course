/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.webservice;

import com.lijiao.entity.User;
import com.lijiao.md5.MD5;
import com.lijiao.service.UserService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "UserWebService")
public class UserWebService {

 
    @EJB
    private UserService userService;
    
     @WebMethod(operationName = "GetUserById")
     public User GetUser(@WebParam(name="UserId") Long userid){
         
        return userService.findUserById(userid);
        
     }
        @WebMethod(operationName = "ShowAllUsers")
     public List<User> ShowAllUsers(){
         
        return userService.getAllUsers();
        
     }
     
      @WebMethod(operationName = "GetAuthenticate")
     public int GetAuthenticate(@WebParam(name="username") String username,@WebParam(name="password") String password){
          
        MD5 md5= new MD5();
        String pass=md5.GetMD5Code(password);
        
        if(userService.findUserByName(username).size()==0){
        
            return 0;
        }
        else{
        
            if(pass.equals(userService.findUserByName(username).get(0).getPassword())){
            
                return 1;
            }
            else return 2;
        }

     }
     
    
    @WebMethod(operationName = "GetUserById2")
    public String  GetUserById(@WebParam(name="UserId") Long userid){
    
        User user= userService.findUserById(userid);
        if(user!=null){
             if(user.isIsauthen()==true){
        
                return "id:"+user.getId().toString()+" username:"+user.getUsername()+" password:"+user.getPassword()+" isuthenticated:true";
          }
             else{
                 return "Sorry,you are not a authenticated user";
           }
        }
        else{
            return "Sorry,you should register in our site";
        }
    }
}
