<%-- 
    Document   : login
    Created on : Feb 5, 2020, 11:23:47 AM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hana Shop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    </head>
    <body>
        <form action="LoginController" method="POST">
            User ID:  <input class="form-control" type="text" name="txtUserID" value="${param.txtUserID}"/> 
            <c:if test="${requestScope.INVALID.userIdError != null}">
                <font color="red">
                ${requestScope.INVALID.userIdError}
                </font>
            </c:if> 


            <br/>
            Password: <input class="form-control" type="password" name="txtPassword"/> 
            <c:if test="${requestScope.INVALID.passwordError != null}">
                <font color="red">
                ${requestScope.INVALID.passwordError}
                </font>
            </c:if> 
            <br/>
            <input type="hidden" name="txtPage" value="1" />
            <input class="btn btn-primary" type="submit" name="action" value="Login" />
        </form>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/Lab2_SE1322_SE130483_BuiThiThuyTrang/AccessGoogleController/login-google&response_type=code
           &client_id=372445975027-a5t9predbmvj8ls3ji1dkbhp1cc4o53u.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
    </body>
</html>
