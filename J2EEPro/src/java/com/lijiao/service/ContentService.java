/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.service;

import com.lijiao.dao.ContentDao;
import com.lijiao.entity.Content;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class ContentService {
    @EJB
    private ContentDao contentDao;
    
    public void addContent(Content content){
    
        contentDao.addContent(content);
    }
    
    public List<Content> findContent(Long userid,Long courseid){
    
        return contentDao.findContent(userid, courseid);
    }
    
    public void updateContent(Content content){
    
        contentDao.updateContent(content);
    }
    
    public List<Content> findContentByUserId(Long userid){
        return contentDao.findContentByUserId(userid);

    }
}
