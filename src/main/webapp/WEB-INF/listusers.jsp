<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
