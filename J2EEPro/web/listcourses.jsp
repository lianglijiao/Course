<%-- 
    Document   : listcourses
    Created on : 2014-2-25, 17:53:53
    
--%>

<%@page import="com.shenyu.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses page</title>
    </head>
    <body>
        
    <center>
        <c:if test="${authen==true}">
            Welcome to the courses page,dear student <b style="background-color: red"><c:out value="${user.username}"></c:out></b>
        </c:if>
       
        <a href="./LogoutServlet">Log out</a>
        <c:choose>
            <c:when test="${not empty courses}">
                <table>
                    <tr style="text-align: left">
                        <td>
                            <c:if test="${authen==true}">
                            <form id="form1" method="Post" action="FilterCourseServlet">
                                Category:  <select id="category" name="category">
                              <c:forEach items="${categorys}" var="categorys">
                                <option value="${categorys}">
                                  <c:out value="${categorys}"/>
                                </option>
                               </c:forEach>
                                </select>
                               <input type="submit" value="Filter"/>
                            </form>
                            </c:if>
                        </td> 
                    </tr>
                    <tr>
                        <th>Course</th>
                        <th>Description</th>
                    </tr>
                     <c:forEach items="${courses}" var="course">
                        <tr>       
                            <td><c:out value="${course.coursename}" /></td>
                            <td><c:out value="${course.description}" /></td>
                            <c:if test="${authen==true}">
                                <td>
                                    <a href="./CourseServlet?uid=${user.id}&cid=${course.id}">Take a course</a>
                                </td>
                                 <td>
                                    <a href="./QuizServlet?uid=${user.id}&cid=${course.id}">Quiz</a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>   
                         <c:if test="${authen==true}">
                        <tr>
                            <td><form id="form2" method="Post" action="PrintServlet?uid=${user.id}">
                                    <input type="submit" value="Print certications in console"/>
                                </form></td>
                                
                                <td><form id="form3" method="Post" action="ShowCertification?uid=${user.id}">
                                    <input type="submit" value="Show certification"/>
                                </form></td>
                        </tr>
                         </c:if>
                        <tr><td>  
                        <c:if test="${authen==false}">
                          <b> If you want to take the courses or pass quizzes,you should register in our site. </b>
                       </c:if>
                        </td></tr>
                </table>
            </c:when>
             <c:otherwise>
                <p>No Courses in Database.</p>
            </c:otherwise>           
        </c:choose>
                <br/>
                
                <br/>
                <br/>
                   Copyright © 1996 - 2014 Supinfo Corporation, All Rights Reserved
        
    </center>
    </body>
</html>
