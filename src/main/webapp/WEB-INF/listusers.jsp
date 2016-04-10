<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Last News</title>
    <%@include file="stylesheet.jspf"%>
</head>
<body>

<%@ include file="header.jspf" %>

<div class="contentwrap">
    <div class="contentheader">
        <h4>List of registered users</h4>
        <hr/>

    </div>
    <div class="contentfeed">
        <ul>
            <c:forEach var="user" items="${sessionScope.listusers}">
                <li>
                    Name:${user.name},
                    Login:${user.login}.
                    Password:${user.password}.
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<%@include file="footer.jspf" %>

</body>
</html>
