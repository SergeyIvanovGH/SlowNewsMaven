<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <%! int numberNews = 0; %>
    <c:forEach var="news" items="${news}">
        <% numberNews++; %>
        <%--<form id="news-form" action="content/news" method="POST">--%>
            <li class="message_li">
                <div class="message_wrap">
                    <img class="message_image" src="${news.enclosule.url}" alt="Image" />
                    <div class="message_title">${news.title}</div>
                    <div class="message_pubdate">
                        ${news.pubDate}
                        <c:if test="${!empty sessionScope.username}">
                            <button id=<%=numberNews%> class="message_link" title="${news.guid}">Save</button>
                            <%--<input class="message_link" id=<%=numberNews%> type="submit" value="Save"/>--%>
                        </c:if>
                    </div>
                </div>
                <input type="text" name="newsid" style="display: none" value="${news.guid}"/>
            </li>
        <%--</form>--%>
    </c:forEach>
</ul>

<script type="text/javascript">
    $("#btnSearch").click(function() {
        var searchedText = $('#txtSearch').val();
        var theRegEx = new RegExp("("+searchedText+")", "igm");

        $(".message_title").each(function (i, elem) {
            var pageText = $(elem).text().replace("<span class='content_err'>","").replace("</span>");
            var newHtml = pageText.replace(theRegEx ,"<span class='content_err'>$1</span>");
            $(elem).html(newHtml);
        });
    });

    $(".message_link").click(function() {
        var stringPOST = "newsid="+$(this).attr("title");
//        var newsId = $(this).attr("id");
        $.post("content/news", stringPOST)
                .done(function() {/* $(newsId).html("Saved");*/
                    alert("News saved !");
                })
                .fail(function() {
                    alert("Error saving news !");
                });
    });
</script>
