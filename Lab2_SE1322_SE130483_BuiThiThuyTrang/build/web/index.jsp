<%@page import="trangbtt.daos.RegistrationDAO"%>
<%@page import="trangbtt.dtos.RegistrationDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Hana Shop</title>
    </head>

    <body>
        <%@include file="header.jsp" %>
        <c:set var="mail" value="${sessionScope.USERID}"/>
        <h2 id="wel">WELCOME ${sessionScope.NAME} </h2>

        <div class="container-fluid" style="margin-top: 70px;text-align: center;">
            <div class="row">
                <div class="col-sm-2">
                    <p></p>

                </div>
                <div class="col-sm-4" >
                    <img src="images/1b.png" style=" height: 50%;border-radius: 45%;margin-bottom: 10%;"/>
                    <p>Great way to make your business appear trust and relevant</p>
                    <p>Great way to make your business appear trust and relevant</p>
                    <p>Great way to make your business appear trust and relevant</p>
                    <p>Great way to make your business appear trust and relevant</p>
                    <p>Great way to make your business appear trust and relevant</p>



                </div>
                <div class="col-sm-4">
                    <p>Great way to make your business appear trust and relevant</p>
                    <p>Great way to make your business appear trust and relevant</p>
                    <p>Great way to make your business appear trust and relevant</p>
                    <p>Great way to make your business appear trust and relevant</p>
                    <img src="images/2b.png" style="margin-top: 10%;height: 60%;border-radius: 45%;"/>

                </div>
                <div class="col-sm-2">
                    <p></p>

                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
