function httpRequestWeather() {
    var req = new XMLHttpRequest();
    req.open('GET', 'http://localhost:8080/SlowNewsMaven/weather', false);
    req.send(null);
    if(req.status == 200) {
        $(".headerweather").each(function (index, element) {
           $(element).html(req.responseText);
        });
    }
}
