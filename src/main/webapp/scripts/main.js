$(document).ready(function() {

    $(".headermenu_a").each(function(index, element) {
        $(element).click(function (event) {
            var targetUrl = $(this).attr('href'),
                targetTitle = $(this).html();

            if (targetUrl !== "logout") {
                window.history.pushState({url: "" + targetUrl + ""}, targetTitle, targetUrl);
                document.title = targetTitle;

                $.get("content/" + targetUrl)
                    .done(function (data) {
                        $(".content").html(data);
                    })
                    .fail(function (data) {
                        $(".content").html("Error load data from server ! Try again !");
                    });
                //event.preventDefault();
                return false;
            }
        });
    });

    function httpRequestWeather() {
        //var req = new XMLHttpRequest();
        //req.open('GET', 'http://localhost:8080/SlowNewsMaven/weather', false);
        //req.send(null);
        //if(req.status == 200) {
        //    $(".headerweather").each(function (index, element) {
        //        $(element).html(req.responseText);
        //    });
        //}
        $.get("weather", function(data, status) {
            if (status === "success") {
                $(".headerweather").html(data);
            }
        });
    }

    if ($(".content").html() === "") {
        $("#news").click();
    }

    setTimeout(httpRequestWeather, 1000);
    setInterval(httpRequestWeather, 300000);
});
