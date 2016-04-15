<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<div class="contentheader">
    <h4>Registration user</h4>
    <hr/>
</div>
<div class="contentfeed">
    <div class="content_err">
    </div>
    <p>Enter your data:</p>
    <label>Name:</label>
    <div>
        <input name="name" id="name" type="text"/>
    </div>
    <label>Login(E-Mail):</label>
    <div>
        <input name="login" id="login" type="email"/>
    </div>
    <label>Password:</label>
    <div>
        <input name="passwd" id="passwd" type="password">
    </div>
    <p/>
    <input value="Submit" id="btnSubmit" type="button">
</div>

<script type="text/javascript">
    $("#btnSubmit").on("click", function() {
        var stringPOST = "name="+$("#name").val()+"&";
        stringPOST += "login="+$("#login").val()+"&";
        stringPOST += "passwd="+$("#passwd").val();
        $("#content_err").css("visibility", "hidden");

        $.post("content/registration", stringPOST)
                .done(function() { $(".content").html("User registered success !"); })
                .fail(function() {
                    $("#content_err").css("visibility", "visible").html("<p>Error registration user !</p>");
                });

//        $.ajax({
//            type: 'POST',
//            url: 'content/registration',
//            data: stringPOST,
//            success: function (responseText) {
//                $(".content").html("User registered success !");
//            },
//            error: function() {
//                $("#content_err").css("visibility", "visible");
//                $("#content_err").html("<p>Error registration user !</p>");
//            }
//        });
    });
</script>
