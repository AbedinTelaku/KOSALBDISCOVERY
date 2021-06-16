// function loginValidate() {
//     if (document.myForm.username.value == "") {
//         alert("Shenoni usernamin");
//         document.myForm.username.focus();
//         return false;
//     }
//     if (document.myForm.username.value.length < 6) {
//         alert("Username duhet te permbaje se paku 6 karaktere");
//         document.myForm.username.focus();
//         return false;
//     }
//     if (document.myForm.password.value == "") {
//         alert("Shenoni Fjalkalimin");
//         document.myForm.password.focus();
//         return false;
//     }
//     if (document.myForm.password.value.length < 6) {
//         alert("Fjalkalimi duhet te permbaje se paku 6 karaktere");
//         document.myForm.password.focus();
//         return false;
//     }
// }

$("#loginButton").click(function (event) {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var statuss = "activ"
    var rolee = "business";

    if (username == "") {

        var error_username = document.getElementById("error_username");

        var text_username = document.createTextNode("Please fill required data");

        error_username.appendChild(text_username);
    }
    if(password == ""){

        var error_password = document.getElementById("error_password");

        var text_password = document.createTextNode("Please fill required data");

        error_password.appendChild(text_password);
    }
});
