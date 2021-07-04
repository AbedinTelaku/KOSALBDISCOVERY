function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}
function validateForm() {
    var name = document.myForm.name.value;
    var age = document.myForm.age.value;
    var gender = document.myForm.gender.value;
    var email = document.myForm.email.value;
    var password = document.myForm.password.value;
    var username = document.myForm.username.value;
    var rolee = "tourist";
    var statuus = "active";

    var nameErr = ageErr = emailErr = passwordErr = usernameErr = true;

    if (name == "") {
        printError("nameErr", "Please enter your name");
    } else {
        var regex = /^[a-zA-Z\s]+$/;
        if (regex.test(name) === false) {
            printError("nameErr", "Please enter a valid name");
        } else {
            printError("nameErr", "");
            nameErr = false;
        }
    }

    if(age == ""){
        printError("ageErr", "Please enter your age");
}else{
        var regex = /^[1-9]\d{9}$/;
        if(regex.test(age) === false){
            printError("ageErr","Please enter a valid age");
        }else{
            printError("ageErr","");
            ageErr = false;
        }
    }

    if(email == ""){
        printError("emailErr", "Please enter your age");
    }else{
        var regex = /^\S+@\S+\.\S+$/;
        if(regex.test(email) === false){
            printError("emailErr","Please enter a valid your email address");
        }else{
            printError("emailErr","");
            emailErr = false;
        }
    }

    if(password == ""){
        printError("passwordErr", "Please enter your age");
    }else{
        var regex = "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$";
        if(regex.test(password) === false){
            printError("passwordErr","Please enter a valid your password");
        }else{
            printError("passwordErr","");
            passwordErr = false;
        }
    }

    if (username == "") {
        printError("usernameErr", "Please enter your username");
    } else {
        var regex = /^[a-zA-Z\s]+$/;
        if (regex.test(username) === false) {
            printError("usernameErr", "Please enter a valid username");
        } else {
            printError("usernameErr", "");
            usernameErr = false;
        }
    }

    if ((nameErr || ageErr || emailErr || passwordErr || usernameErr) == true) {
        return false;
    }else{
        var dataPreview = "You've entered the following details: \n" +
            "Full Name: " + name + "\n" +
            "Age : " + age + "\n" +
            "Email : " + email + "\n" +
            "Password : " + password + "\n";
        if(hobbies.length) {
            dataPreview += "Hobbies: " + hobbies.join(", ");
        }
        alert(dataPreview);
    }
};

//     tourist = {
//         name: name,
//         age: age,
//         gender: gender,
//         email: email,
//         password: password,
//         username: username,
//         role: rolee,
//         status:statuus
//     }
//
//     console.log(tourist)
//
//     registerTourist(tourist);
//
// });
//
//
// function registerTourist(tourist) {
//
//
//     $.ajax({
//         url: "http://localhost:8080/api/tourist/create/tourist",
//         type: 'post',
//         contentType: "application/json; charset=utf-8",
//         // dataType: "json",
//         data: JSON.stringify(tourist),
//         success: function (res) {
//             // localStorage.setItem('kuizi', JSON.stringify(res))
//
//             console.log(tourist)
//
//
//         },
//         error: function (request, status, error) {
//             console.log(error);
//             console.log(status);
//         }
//     })
// }
//
//
// var tourist = {
//     name: "",
//     age: "",
//     gender: "",
//     email: "",
//     password: "",
//     username: "",
//     role: "",
//     status:""
// }