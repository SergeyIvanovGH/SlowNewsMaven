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
        <p>User registered.</p>
        <p>Name:${user.name}</p>
        <p>Login:${user.login}</p>
        <p>Password:${user.password}</p>
    </div>
</div>

<%@include file="footer.jspf" %>

</body>
</html>
