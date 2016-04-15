<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="contentheader">
    <h4>Archive news feed</h4>
    <hr/>
</div>
<ul class="message_ul">
    <c:forEach var="news" items="${news}">
        <%--<form id="news-form" action="archivenews" method="POST">--%>
            <li class="message_li">
                <div class="message_wrap">
                    <img class="message_image" src="${news.enclosule.url}" alt="Image" />
                    <div class="message_title">${news.title}</div>
                    <div class="message_pubdate">
                            ${news.pubDate}
                        <button class="message_link" title="${news.guid}">Delete</button>
                        <%--<input class="message_link" type="submit" value="Delete"/>--%>
                    </div>
                </div>
                <%--<input type="text" name="newsid" style="display: none" value="${news.guid}"/>--%>
            </li>
        <%--</form>--%>
    </c:forEach>
</ul>

<script type="text/javascript">
    $(".message_link").click(function() {
        var stringPOST = "newsid="+$(this).attr("title");
        $.post("content/archivenews", stringPOST)
                .done(function() {
                    $.get("content/archivenews")
                            .done(function (data) {
                                $(".content").html(data);
                            })
                            .fail(function (data) {
                                $(".content").html("Error load data from server ! Try again later !");
                            });
//                    alert("News deleted !");
                })
                .fail(function() {
                    alert("Error deleting news !");
                });
    });
</script>
