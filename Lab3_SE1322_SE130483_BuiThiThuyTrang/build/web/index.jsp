<%-- 
    Document   : index
    Created on : Mar 7, 2020, 2:34:52 PM
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
            font-size: 40px;">CAR SHOP</h1>
        <h2 style=" text-align: center;
    font-size: 30px;
    font-family: 'Times New Roman', Times, serif;
    font-weight: 700;
    letter-spacing: 2px;
    color: rgb(24, 141, 75);
    text-shadow: 1px 1px black;
    margin-bottom: 20px;">WELCOME <s:property value="%{#session.NAME}"/> </h2>


        <s:if test="%{#session.NAME==null}">
            <s:a href="signIn.jsp" cssStyle="text-decoration:none;margin-left:700px;"  >LOGIN</s:a>
        </s:if>
        <s:if test="%{#session.NAME!=null}">
            <s:url var="logoutLink" value="LogoutAction">

            </s:url>
            <s:a href="%{logoutLink}" cssStyle="text-decoration:none;margin-left:700px;">LOGOUT</s:a>
        </s:if>


        <s:form action="ListCarAction" method="POST" style="display:flex; justify-content: center;margin-top: 10px" >
            <s:submit value="CAR" style="width:150px;letter-spacing: 2px;"/>
        </s:form>
        <s:form action="HistotyAction" method="POST" style="display:flex; justify-content: center;margin-top: 10px">
            <s:textfield type="hidden" name="user" value="%{#session.EMAIL}"/> </br>
            <s:submit value="HISTORY" style="width:150px;letter-spacing: 2px;"/>
        </s:form>


    </body>
</html>
