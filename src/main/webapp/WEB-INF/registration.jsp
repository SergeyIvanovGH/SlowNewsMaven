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
            <h4>Registration user</h4>
            <hr/>
        </div>
        <div class="contentfeed">
            <p>Enter your data:</p>
            <form name="loginform" action="registration" method="POST">
                <label>Name:</label>
                <div>
                    <input name="name" type="text"/>
                </div>
                <label>Login(E-Mail):</label>
                <div>
                    <input name="login" type="email"/>
                </div>
                <label>Password:</label>
                <div>
                    <input name="passwd" type="password">
                </div>
                <p/>
                <input value="Submit" id="btnSubmit" type="submit">
            </form>
        </div>
    </div>

    <%@include file="footer.jspf" %>

</body>
</html>
