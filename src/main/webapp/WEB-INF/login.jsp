<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>

<div class="contentheader">
    <h4>Login</h4>
    <hr/>
</div>
<div class="contentfeed">
    <div class="content_err"></div>
    <p>Enter your registration data:</p>
    <label for="login">E-Mail:</label>
    <div>
        <input id="login" name="login" type="email" required="true"/>
    </div>
    <label for="passwd">Password:</label>
    <div>
        <input id="passwd" name="passwd" type="password" required="true">
    </div>
    <p/>
    <input value="Login" id="btnSubmit" type="button"">
    <a id="lu_a" href="listusers">List users</a>
    <div id="lu_d" style="visibility:hidden"></div>
</div>

<script type="text/javascript">
    $("#btnSubmit").on("click", function() {
        var stringPOST = "login="+$("#login").val()+"&";
        stringPOST += "passwd="+$("#passwd").val();
        $("#content_err").css("visibility", "hidden");

        $.post("content/login", stringPOST)
                .done(function(data) {
                    window.location.replace("news");
                })
                .fail(function(data) {
                    $("#content_err").css("visibility", "visible").html("<p>User not found !</p>");
                });

    });

    $("#lu_a").click(function() {
        $.get("listusers")
                .done(function (data) {
                    $("#lu_d").css("visibility", "visible").html(data);
                })
                .fail(function (data) {
                    $("#lu_d").css("visibility", "visible").html("<p>Error loaded list users !</p>");
                });
        return false;
    });
</script>
