<%-- 
    Document   : signIn
    Created on : Mar 7, 2020, 2:49:53 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car rental</title>
        <s:head/>
    </head>
    <body>
        <h1 style="text-align: center;color: red;
            letter-spacing: 2px;
            height: 25px;margin-top: 10px;
            font-size: 40px;">LOGIN</h1>
        <s:form action="LoginAction" method="POST">
            <s:textfield type="email" name="email" label="Email"/>
            <s:textfield type="password" name="password" label="Password"/>
            <s:submit value="Login"/>
        </s:form>
        <s:a href="signUp.jsp" cssStyle="text-decoration:none;">Create Account</s:a>
    </body>
</html>
