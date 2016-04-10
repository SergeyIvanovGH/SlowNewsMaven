<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <%@include file="stylesheet.jspf"%>
</head>
<body>

    <%@include file="header.jspf" %>

    <div class="contentwrap">
        <div class="contentheader">
            <h4>Login</h4>
            <hr/>
        </div>
        <div class="contentfeed">
            <div class="content_err">
                <c:if test="${!empty error_message}">
                    ${error_message}
                </c:if>
            </div>
            <p>Enter your registration data:</p>
            <form name="loginform" action="login" method="POST">
                <label for="login">E-Mail:</label>
                <div>
                    <input id="login" name="login" type="email"/>
                </div>
                <label for="passwd">Password:</label>
                <div>
                    <input id="passwd" name="passwd" type="password">
                </div>
                <p><input value="Login" id="btnSubmit" type="submit"></p>
            </form>
            <a href="listusers">List users</a>
        </div>
    </div>

    <%@include file="footer.jspf" %>

</body>
</html>
