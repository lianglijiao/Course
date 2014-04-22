<%-- 
    Document   : adminpage
    Created on : 2014-2-28, 11:56:42
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
<script LANGUAGE="javascript"> 
function checkcourse() 
{ 
if(document.formcourse.coursename.value.length==0||document.formcourse.coursedes.value.length==0){ 
     alert("cant empty!"); 
     return false; 
    } 
  } 
  
  function checkquestion() 
{ 
if(document.formquestion.questioncontent.value.length==0){ 
     alert("cant empty!"); 
     return false; 
    } 
  }
  
    function checkanswer() 
{ 
if(document.formanswer.rightanswer.value.length==0||document.formanswer.wronganswer.value.length==0){ 
     alert("cant empty!"); 
     return false; 
    } 
  } 
</script> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    <center>
        <table style="width: 300px">
            ---------------Add a course---------------
         
         <form name="formcourse" method="Post" action="AddCourseServlet" onsubmit="return checkcourse()">
             <tr> Course name:<input type="text" name="coursename"/></tr>
             <tr>Course description:<input type="text" name="coursedes"/></tr>
             <tr>Course category:<select name="category">
                <option >M1</option>
                <option >B3</option>
                <option >B2</option>
                <option >B1</option>
            </select></tr>
            <tr><input type="submit" value="Add a course"/></tr>   
        </form>            
            <br/>
            </br>
        ----------------Add a question---------------
         
        <form name="formquestion" method="Post" action="AddQuestionServlet" onsubmit="return checkquestion()">
           <tr> Question:<textarea name="questioncontent" cols="40" rows="4"></textarea>  </tr>

         <tr><input type="submit" value="Add a question"/></tr>
        </form>
           <br/>
           </br>          
             ----------------Add a answer---------------
             <form name="formanswer" method="Post" action="AddAnswerServlet" onsubmit="return checkanswer()">
                Question:  <select  name="questiondada">
                        <c:forEach items="${questions}" var="question">
                               <option value="${question.id}">${question.quescontent}</option>
                        </c:forEach>
                  </select><br/>
                Right answer:<input type="text" name="rightanswer"/><br/>
                Wrong answer:<input type="text" name="wronganswer"/><br/>
                <input type="submit" value="Add a answer"/>
        </form>

        <a href="./index.jsp">Back</a>
        <br/>
        <br/>
        <br/>
          Copyright © 1996 - 2014 Supinfo Corporation, All Rights Reserved
           </table>
    </center>
    </body>
</html>
