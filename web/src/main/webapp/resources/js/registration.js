$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

function Validate(obj) {
    var name = document.getElementById("name").value;
    var nickname = document.getElementById("nickname").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if (name == null || name == "" ||
        nickname == null || nickname == "" ||
        username == null || username == "" ||
        password == null || password == ""
    ) {
        return false;
    }

}

function checkAfterChangeName() {
    var name = document.getElementById("name").value;
    if (name == null || name == "") {
        $("#nameAfterJavaScript").html("<div class='cross'></div>");
        document.getElementById("submitRegistration").disabled = true;
    } else {
        $("#nameAfterJavaScript").html("<div style='margin-left: 5px;'><i class='check'></i></div>");
        document.getElementById("submitRegistration").disabled = false;
    }
}

function checkAfterChangeNickName() {
    var nickname = document.getElementById("nickname").value;
    var reg = /^(?! )(?!.* $)(?!(?:.* ){1}).*$/;
    if (!reg.test(nickname) || nickname == null || nickname == "") {
        $("#nickNameAfterJavaScript").html("<div class='cross'></div>");
        document.getElementById("submitRegistration").disabled = true;
    } else {
        var userRequest = {};
        userRequest["username"] = $("#nickname").val();
        userRequest["password"] = $("#password").val();

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "checkNickname",
            data : JSON.stringify(userRequest),
            dataType : 'json',
            success : function(result) {
                if(result.message == "true") {
                    $("#nickNameAfterJavaScript").html("<div class='cross'></div>");
                    document.getElementById("submitRegistration").disabled = true;
                    //$("#submitRegistration").disabled = true;
                } else if(result.message == "false") {
                    $("#nickNameAfterJavaScript").html("<div style='margin-left: 5px;'><i class='check'></i></div>");
                    document.getElementById("submitRegistration").disabled = false;
                }
            }
        });
    }
}

function checkAfterChangeUsername() {
    var username = document.getElementById("username").value;
    var reg = /^\w+@\w+\.\w{2,4}$/i;
    if (!reg.test(username)) {
        $("#emailAfterJavaScript").html("<div class='cross'></div>");
        document.getElementById("submitRegistration").disabled = true;
    } else {
        var userRequest = {};
        userRequest["username"] = $("#username").val();
        userRequest["password"] = $("#password").val();

        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "getResponse",
            data : JSON.stringify(userRequest),
            dataType : 'json',
            success : function(result) {
                if(result.message == "true") {
                    $("#emailAfterJavaScript").html("<div class='cross'></div>");
                    document.getElementById("submitRegistration").disabled = true;
                    //$("#submitRegistration").disabled = true;
                } else if(result.message == "false") {
                    $("#emailAfterJavaScript").html("<div style='margin-left: 5px;'><i class='check'></i></div>");
                    document.getElementById("submitRegistration").disabled = false;
                }
            }
        });
    }
}

function checkAfterChangePassword() {
    var password = document.getElementById("password").value;
    if (password == null || password == "") {
        $("#passwordAfterJavaScript").html("<div class='cross'></div>");
        document.getElementById("submitRegistration").disabled = true;
    } else {
        $("#passwordAfterJavaScript").html("<div style='margin-left: 5px;'><i class='check'></i></div>");
        document.getElementById("submitRegistration").disabled = false;
    }
}



