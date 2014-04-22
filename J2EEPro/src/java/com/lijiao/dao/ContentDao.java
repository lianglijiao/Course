/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lijiao.dao;

import com.lijiao.entity.Content;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ContentDao {
    
    void addContent(Content content);
    
    List<Content> findContent(Long userid,Long courseid);
    
    void updateContent(Content content);
    
    
    List<Content> findContentByUserId(Long userid);
}
