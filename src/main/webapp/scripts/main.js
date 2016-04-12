$(function() {

    $("#btnSearch").click(function() {
        var searchedText = $('#txtSearch').val();
        var theRegEx = new RegExp("("+searchedText+")", "igm");

        $(".message_title").each(function (i, elem) {
            var pageText = $(elem).text().replace("<span class='content_err'>","").replace("</span>");
            var newHtml = pageText.replace(theRegEx ,"<span class='content_err'>$1</span>");
            $(elem).html(newHtml);
        });
    });

    httpRequestWeather();
    setInterval(httpRequestWeather, 300000);
});