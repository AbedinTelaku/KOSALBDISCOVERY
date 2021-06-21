function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function validateForm() {
    var username = document.myForm.username.value;
    var password = document.myForm.password.value;

    var usernameErr = passwordErr = true;

    if(username == ""){
        printError("usernameErr", "Please enter your username");
    }else{
        var regex = /^[a-zA-Z\s]+$/;
        if(regex.test(username) === false){
            printError("usernameErr", "Please enter a valid username");
        }else{
            printError("usernameErr","");
            usernameErr = false;
        }
    }

    if(password == ""){
        printError("passwordErr","Please enter your password");
    }else{
        var regex = "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$";
        if(regex.test(password) === false){
            printError("passwordErr", "Please enter a valid password");
        }else{
            printError("passwordErr", "");
            passwordErr = false;
        }
    }

    if ((usernameErr || passwordErr) == true){
        return false;
    }else{
        var dataPreview = "You've entered the following details: \n" +
            "Username: " + username + "\n" +
            "Password: " + password + "\n";
        if(hobbies.length) {
            dataPreview += "Hobbies: " + hobbies.join(", ");
        }
        alert(dataPreview);
    }
};