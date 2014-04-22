/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.service;

import com.lijiao.dao.MarkDao;
import com.lijiao.entity.Mark;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class MarkService {
    
    @EJB
    private MarkDao markDao;
    
    public void addMark(Mark mark){
    
        markDao.addMark(mark);
    }
    
    public void updateMark(Mark mark){
    
        markDao.updateMark(mark);
    }
    
    public List<Mark> findMark(Long uid,Long cid){
    
        return markDao.findMark(uid, cid);
    }
    
    public List<Mark> getPassedMark(Long userid){
    
        return markDao.getPassedmark(userid);
    }
}
