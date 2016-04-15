<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <c:if test="${!empty requestScope.pagetitle}">
            <title>${requestScope.pagetitle}</title>
        </c:if>
        <c:if test="${empty requestScope.pagetitle}">
            <title>News feed</title>
        </c:if>

        <%@include file="stylesheet.jspf"%>

        <script src="scripts/jquery-2.2.3.js"></script>
        <script src="scripts/main.js" type="text/javascript"></script>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div class="content"></div>
        <%@include file="footer.jspf"%>
    </body>
</html>
