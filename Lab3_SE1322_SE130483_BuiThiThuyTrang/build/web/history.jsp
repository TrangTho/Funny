<%-- 
    Document   : history
    Created on : Mar 15, 2020, 9:43:42 PM
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
            font-size: 40px;">History</h1>
        <s:a href="index.jsp" cssStyle="text-decoration:none;display:flex; justify-content: center;" >HOME</s:a>
        <s:form action="HistotyAction" method="POST" style="display:flex; justify-content: center;margin-top: 10px">
            <s:textfield type="hidden" name="user" value="%{#session.EMAIL}"/> </br>
            <s:submit value="HISTORY" style="width:150px;letter-spacing: 2px;"/>
        </s:form>
        <s:form action="SearchByNameHistoryAction" method="POST" >
            <s:textfield type="hidden" name="user" value="%{#session.EMAIL}"/> 
            <s:textfield name="searchName" label="Search By Name Car" value="%{searchName}"/>
            <s:submit value="Search"/>
        </s:form>
        <s:form action="SearchByDateHistoryAction" method="POST" >
            <s:textfield type="hidden" name="user" value="%{#session.EMAIL}"/> 
            <s:textfield type="date" name="searchDate" label="Search By Order Date" value="%{searchDate}"/>
            <s:submit value="Search"/>
        </s:form>
        <s:if test="%{result!=null}" >
            <s:iterator value="result" var="dto" status="counter">
                NO: <s:property value="%{#counter.count}"/> </br>
                Email: <s:property value="%{email}"/> </br>
                Rental Date: <s:property value="%{rentalDate}"/> </br>
                Return Date: <s:property value="%{returnDate}"/> </br>
                Order Date: <s:property value="%{date}"/> 
                <s:form action="DeleteHistoryAction" method="POST" >
                    <s:textfield type="hidden" name="user" value="%{#session.EMAIL}"/> 
                    <s:textfield type="hidden" name="id" value="%{id}"/> 
                    <s:submit value="Delete"/>
                </s:form>
                <s:form action="DetailHistoryAction" method="POST" >
                    <s:textfield type="hidden" name="user" value="%{#session.EMAIL}"/> 
                    <s:textfield type="hidden" name="id" value="%{id}"/> 
                    <s:submit value="Detail"/>
                </s:form>
            </s:iterator>
        </s:if>
        <s:if test="%{resultDetail!=null}" >
            <s:iterator value="resultDetail" var="dto" status="counter">
                NO: <s:property value="%{#counter.count}"/> </br>
                Name Car: <s:property value="%{name}"/> </br>
                Price: <s:property value="%{price}"/> </br>
                Quantity: <s:property value="%{quantity}"/> </br>
                Order Date: <s:property value="%{date}"/> </br>
                Discount: <s:property value="%{code}"/>% 
                <s:form action="FeedbackAction" method="POST" >
                    <s:textfield type="hidden" name="user" value="%{#session.EMAIL}"/> 
                    <s:textfield type="hidden" name="id" value="%{id}"/> 
                    <s:textfield type="hidden" name="carID" value="%{carID}"/> 
                    <s:textfield name="rating" type="number" label="Feedback" value="1" min="1" max="10" />
                    <s:submit value="Send"/>
                </s:form>
            </s:iterator>
        </s:if>
        <s:if test="%{resultSearchName!=null}" >
            <s:iterator value="resultSearchName" var="dto" status="counter">
                NO: <s:property value="%{#counter.count}"/> </br>
                Name Car: <s:property value="%{name}"/> </br>
                Price: <s:property value="%{price}"/> </br>
                Quantity: <s:property value="%{quantity}"/> </br>
                Order Date: <s:property value="%{date}"/> </br>
                <s:form action="DeleteHistoryAction" method="POST" >
                    <s:textfield type="hidden" name="user" value="%{#session.EMAIL}"/> 
                    <s:textfield type="hidden" name="id" value="%{id}"/> </br>
                    <s:submit value="Delete"/>
                </s:form>
            </s:iterator>
        </s:if>
    </body>
</html>
