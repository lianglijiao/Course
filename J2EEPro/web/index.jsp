<%-- 
    Document   : index
    Created on : 2014-2-25, 13:02:57
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        </script>               
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index page</title>
    </head>
    <body>
        <center>
         <h2>Welcome to Supinfo's course-system!</h2>
         <form name="form1" method="Post" action="LoginServlet" >
            Username:<input type="text" name="username"><br/>
            Password:<input type="password" name="password"><br/>
            <input type="submit" value="Login" >
            
        </form>
         <form name="form2" method="Post" action="AnonymousLoginServlet">
             <input type="submit" value="Anonymous" >
         </form>
        <a href="./LoginServlet">Register User</a><br/><br/><br/>
        <b>You can login with admin/admin to manage the site!</b><br/>
           Copyright © 1996 - 2014 Supinfo Corporation, All Rights Reserved
    </center>
    </body>
</html>
