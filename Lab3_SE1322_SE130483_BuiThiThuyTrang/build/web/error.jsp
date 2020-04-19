<%-- 
    Document   : error
    Created on : Mar 7, 2020, 3:58:43 PM
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
        <h2 style=" text-align: center;
            font-size: 30px;
            font-family: 'Times New Roman', Times, serif;
            font-weight: 700;
            letter-spacing: 2px;
            color: rgb(24, 141, 75);
            text-shadow: 1px 1px black;
            margin-bottom: 20px;"><s:property value="%{#request.ERROR}"/> </h2>
    </body>
</html>
