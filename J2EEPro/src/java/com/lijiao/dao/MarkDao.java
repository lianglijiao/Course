/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.dao;

import com.lijiao.entity.Mark;
import java.util.List;
import javax.ejb.Local;



@Local
public interface MarkDao {
    
    List<Mark> findMark(Long userid,Long courseid);
    
    void addMark(Mark mark);
    
    void updateMark(Mark mark);
    
    List<Mark> getPassedmark(Long userid);
}
