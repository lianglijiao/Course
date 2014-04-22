<%-- 
    Document   : quiz
    Created on : 2014-2-25, 18:16:55
    
--%>

<%@page import="javax.ejb.EJB"%>
<%@page import="com.shenyu.service.QuestionService"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz page</title>
    </head>
    <body>
    <center>
         Welcome to the quiz page,I wish you have a good luck!
          <c:choose>
            <c:when test="${not empty questions}">
                <form method="Post" method="./QuizServlet">
                <table>                   
                 <c:set var="position" value="1"/>
                    <c:forEach items="${questions}" var="question" >
                        <tr style="text-align: left">
                            <td>Number:${position}</td>
                            <td><c:out value="${question.quescontent}" />
                                <input type="hidden" name="questionid${position}" value="${question.id}"/>
                            </td>     
                            <td>
                                <select id="answer" name="answerid${position}">
                                     <c:forEach items="${question.answers}" var="answer">
                                         <option value="${answer.id}">${answer.anscontent}</option>
                                     </c:forEach>
                                </select>
                            </td>  
                        </tr>  
                        <c:set var="position" value="${position+1}"/>
                     </c:forEach>
                        <tr>
                            <td>
                             <input type="submit" value="Submit"/>
                            </td>
                        </tr>
                            </table>
                    </form> 
                        <a href="./ListCourseServlet">Back</a>
                    <br/>
                    <br/>
                    <br/>
                      Copyright © 1996 - 2014 Supinfo Corporation, All Rights Reserved
            </c:when>
            <c:otherwise>
                    <p>No quiz in Database.</p>
            </c:otherwise>
            </c:choose>
    </center>
    
    </body>
</html>
