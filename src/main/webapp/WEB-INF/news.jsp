<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>News feed</title>
        <%@include file="stylesheet.jspf"%>
    </head>
    <body>

    <%@ include file="header.jspf" %>

        <div>
            <div class="contentheader">
                <table>
                    <tr>
                        <td>
                            <h4>News feed</h4>
                        </td>
                        <td>
                            <input type="text" id="txtSearch" />
                            <input type="button" id="btnSearch" value="Find">
                        </td>
                        <!-- <td>
                            &#128269;
                        </td> -->
                    </tr>
                </table>
                <hr/>
            </div>
                <ul class="message_ul">
                    <c:forEach var="news" items="${news}">
                        <form id="news-form" action="news" method="POST">
                        <li class="message_li">
                            <div class="message_wrap">
                                <img class="message_image" src="${news.enclosule.url}" alt="Image" />
                                <div class="message_title">${news.title}</div>
                                <div class="message_pubdate">
                                    ${news.pubDate}
                                    <c:if test="${!empty sessionScope.username}">
                                        <input class="message_link" type="submit" value="Save"/>
                                    </c:if>
                                </div>
                            </div>
                            <input type="text" name="newsid" style="display: none" value="${news.guid}"/>
                        </li>
                        </form>
                    </c:forEach>
                </ul>
        </div>

        <%@include file="footer.jspf" %>

    </body>
</html>
