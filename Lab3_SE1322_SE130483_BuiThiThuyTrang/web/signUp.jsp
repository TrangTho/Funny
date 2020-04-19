<%-- 
    Document   : signUp
    Created on : Mar 7, 2020, 2:50:05 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Rental</title>
        <s:head/>

    </head>
    <body>
        <h1 style="text-align: center;color: red;
            letter-spacing: 2px;
            height: 25px;margin-top: 10px;
            font-size: 40px;">Sign up</h1>
        <s:form name="formSignUp" action="SignUpAction" method="POST" onsubmit="return validSign()">
            <s:textfield type="email" name="email" label="Email"/>
            <s:if test="%{exception.message.indexOf('duplicate') > -1}">
                <font color="red">
                <s:property value="email"/> is existed!
                </font>
            </s:if>
            <s:password type="password" name="password" label="Password"/>
            <s:password type="password" name="confirm" label="Confirm"/>
            <s:textfield name="name" label="Name"/>
            <s:textfield name="phone" label="Phone"/>
            <s:textfield name="address" label="address"/>
            <s:submit value="Insert"/>
        </s:form>
        <script src="function.js" ></script>

    </body>
</html>
