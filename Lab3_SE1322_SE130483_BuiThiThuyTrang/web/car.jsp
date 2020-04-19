<%-- 
    Document   : car
    Created on : Mar 10, 2020, 5:20:04 PM
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
            font-size: 40px;"> CAR</h1>
        <s:a href="index.jsp" cssStyle="text-decoration:none;" >HOME</s:a> </br>
        <s:form name="formConfirm"  action="SearchByNameAction" method="POST" onsubmit="return validateSearch()" >
            <s:textfield name="searchName" label="Search By Name Car" value="%{searchName}"/>
            <s:textfield  type="date" name="rentalDate" label="Rental Date" value="%{rentalDate}"/>
            <s:textfield type="date" name="returnDate" label="Return Date" value="%{returnDate}"/>
            <s:textfield name="quantityCar" label="Quantity car" value="%{quantityCar}"/>
            <s:submit value="Search"/>
        </s:form>
        <s:form name="formConfirmA"  action="SearchByCategoryAction" method="POST" onsubmit="return validateSearchCate()" >
            <s:textfield name="searchCate" label="Search By Name Category" value="%{searchCate}"/>
            <s:textfield  type="date" name="rentalDate1" label="Rental Date" value="%{rentalDate1}"/>
            <s:textfield type="date" name="returnDate1" label="Return Date" value="%{returnDate1}"/>
            <s:textfield name="quantityCar1" label="Quantity car" value="%{quantityCar1}"/>
            <s:submit value="Search Category"/>
        </s:form>
        <s:if test="%{#session.NAME!=null}">
            <s:if test="#session.CART!=null">
                <s:form action="cart.jsp" method="POST">
                    <s:textfield type="hidden" name="user" value="%{#session.NAME}"/>
                    <s:submit value="CART"/>
                </s:form>
            </s:if>
        </s:if>

        <s:if test="%{result!=null}" >
            <s:iterator value="result" var="dto" status="counter">
                No: <s:property value="%{#counter.count}"/> </br>
                Name Car:<s:property value="%{name}"/> </br>
                Color: <s:property value="%{color}"/> </br>
                Year: <s:property value="%{year}"/> </br>
                Price: <s:property value="%{price}"/> </br>
                Quantity: <s:property value="%{quantity}"/> </br>
                Category: <s:property value="%{cate}"/> </br>
                Rating:  <s:property value="%{rating}"/> </br>
                <s:if test="#session.NAME!=null">
                    <s:form action="OrderAction" method="POST">
                        <s:textfield type="hidden" name="id" value="%{id}"/>
                        <s:textfield type="hidden" name="name" value="%{name}"/> 
                        <s:textfield type="hidden" name="price" value="%{price}"/> 
                        <s:textfield type="hidden" name="quantity" value="%{quantity}"/> 
                        <s:textfield type="hidden" name="cate" value="%{cate}"/>
                        <s:textfield type="hidden" name="user" value="%{#session.NAME}"/>
                        <s:submit value="ADD" />
                    </s:form>
                </s:if>
                </br>
            </s:iterator>
        </s:if>
        <s:if test="%{resultSearchName!=null}" >
            <s:iterator value="resultSearchName" var="dto" status="counter">
                No: <s:property value="%{#counter.count}"/> </br>
                Name Car:<s:property value="%{name}"/> </br>
                Color: <s:property value="%{color}"/> </br>
                Year: <s:property value="%{year}"/> </br>
                Price: <s:property value="%{price}"/> </br>
                Quantity: <s:property value="%{quantity}"/> </br>
                Category: <s:property value="%{cate}"/> </br>
                Rating:  <s:property value="%{rating}"/> </br>
                Real Quantity: <s:property value="%{realQuantity}"/> </br>
                <s:if test="#session.NAME!=null">
                    <s:form action="OrderAction" method="POST">
                        <s:textfield type="hidden" name="id" value="%{id}"/>
                        <s:textfield type="hidden" name="name" value="%{name}"/> 
                        <s:textfield type="hidden" name="price" value="%{price}"/> 
                        <s:textfield type="hidden" name="quantity" value="%{quantity}"/> 
                        <s:textfield type="hidden" name="cate" value="%{cate}"/>
                        <s:textfield type="hidden" name="user" value="%{#session.NAME}"/>
                        <s:submit value="ADD" />
                    </s:form>
                </s:if>
            </s:iterator>
        </s:if>
        <script src="function.js" ></script>
    </body>
</html>
