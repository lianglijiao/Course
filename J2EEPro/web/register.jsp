<%-- 
    Document   : register
    Created on : 2014-2-25, 14:47:52
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
            
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
    </head>
    <body>
    <center>
         <h2>You can register a user!</h2>
         <form name="form1" method="Post" action="RegisterServlet">
            Username:<input type="text" name="username"><br/>
            Password:<input type="password" name="password"><br/>
            <input type="submit" value="Register">
        </form>
         <a href="index.jsp">Back</a><br/><br/><br/>
           Copyright © 1996 - 2014 Supinfo Corporation, All Rights Reserved
    </center>
    </body>
</html>
