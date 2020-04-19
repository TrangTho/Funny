<%-- 
    Document   : active
    Created on : Mar 10, 2020, 3:47:01 PM
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
        <h3>Check mail to verification account</h3>
        <s:form action="ActiveAction" method="POST">
            <s:textfield name="code" label="Code"/>
            <s:textfield type="hidden" name="email" value="%{email}"/>
            <s:submit value="Insert"/>
        </s:form>
    </body>
</html>
