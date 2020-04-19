<%-- 
    Document   : cart
    Created on : Mar 14, 2020, 2:59:08 PM
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
       
        <h2 style="text-align: center;color: red;
            letter-spacing: 2px;
            height: 25px;margin-top: 10px;
            font-size: 40px;"><s:property value="%{#session.NAME}"/>'S CART </h2>
        <s:a href="index.jsp" cssStyle="text-decoration:none;" >HOME</s:a>

        <s:set var="shop" value="%{#session.CART}"/>
        <s:form action="ListCarAction" method="POST">
            <s:submit value="CAR"/>
        </s:form>
        <s:if test="%{#shop!=null}">
            <s:iterator value="#shop.cart" status="counter">
                <s:property value="%{#counter.count}"/> </br>
                Product Name:   <s:property  value="value.name"/> </br>
                Category : <s:property value="value.category"/> </br>
                Price: <s:property value="value.price"/> </br>
                Amount: <s:property value="value.price*value.quantityCart"/> </br>
                <s:form name="formUpdate" action="UpdateCartAction" method="POST" onsubmit="return validateQuantity()">
                    <s:textfield type="number" name="quantity" value="%{value.quantityCart}"/> 
                    <s:textfield type="hidden" name="id" value="%{value.id}"/> 
                    <s:textfield type="hidden" name="quantityReal" value="%{value.quantity}"/> 
                    <s:submit value="Update"/>
                </s:form>

                <s:form action="DeleteCartAction" method="POST" onSubmit="return confirm('Do you want to submit?')">
                    <s:textfield type="hidden" name="id" value="%{value.id}"/> </br>

                    <s:submit value="Delete"/>
                </s:form>
            </s:iterator>
            Total :    <s:property value="%{#shop.total}"/> 
            <s:form action="InsertCodeAction" method="POST" >
                <s:textfield  name="code" label=" Discount code" value="%{code}"/> 
                <s:submit value="Apply"/>
            </s:form>
            <s:form name="formConfirm" action="InsertCartAction" method="POST" onsubmit="return validateDates()">
                <s:textfield type="date" label=" Rental date" name="rentalDate" /> 
                <s:textfield type="date" label=" Return date" name="returnDate" /> 
                <s:textfield type="hidden" name="code" value="%{code}"/> 
                <s:textfield type="hidden" name="user" value="%{#session.EMAIL}"/> 
                <s:submit value="Confirm"/>
            </s:form>
        </s:if>
        <script src="function.js" ></script>

    </body>
</html>
