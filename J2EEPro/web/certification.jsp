<%-- 
    Document   : certification
    Created on : 2014-2-27, 20:52:20
   
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Certification page</title>
    </head>
    <body>
        
    <center>
        Dear student:<c:out value="${user.username}"></c:out>
        <br/>
       Your passed courses:<br/>
  <c:choose>
    <c:when test="${not empty passedcourses}">
        <c:forEach items="${passedcourses}" var="course">
            <table>
                <tr>
                    <td><c:out value="${course.coursename}"></c:out></td>
                </tr>
            </table>
        </c:forEach>
        Date:<%
                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd HH:mm:ss");
                    out.print(sdf.format(d));
            %></br>
            <b>Congratulations,keep efforts!</b>
    </c:when>
        <c:otherwise>
            <p>Sorry,you have no passed courses!</p>
        </c:otherwise>
  </c:choose>      
            <a href="./ListCourseServlet">Back</a>
             <br/>
                <br/>
                <br/>
               Copyright © 1996 - 2014 Supinfo Corporation, All Rights Reserved
    </center>
        
    </body>
</html>
