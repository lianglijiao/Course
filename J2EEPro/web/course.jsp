<%-- 
    Document   : course
    Created on : 2014-3-2, 10:55:50
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script language="javascript">
            function nextfunction(){
             var pagenumber=document.getElementById("page").value;
             pagenumber++;
             document.getElementById("page").value=pagenumber;
            }
            
            function prefunction(){
                
             var pagenumber=document.getElementById("page").value;
             if(pagenumber<=1){return;}
             pagenumber--;
             document.getElementById("page").value=pagenumber;
            }
        </script>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course page</title>
    </head>
    <body>
    <center>
        <b>Welcome to the course page.Work hard!</b><br/>
        
        Last time,you have learned page <b><c:out value="${pagenumber}"/> </b>
        
        
        <form name="formcourse" method="Post" action="CourseServlet">
            <input  name="pre"type="button" value="<<"  onclick="prefunction();">
            <input style="width: 50px" type="text" name="page" id="page" value="${pagenumber}"/>
            <input type="button" value=">>" name="next" onclick="nextfunction()"/>
            <input type="submit" value="Leave" />
        </form>
         <br/>
          <br/>
          <br/>
               Copyright © 1996 - 2014 Supinfo Corporation, All Rights Reserved
    </center>
    </body>
</html>
