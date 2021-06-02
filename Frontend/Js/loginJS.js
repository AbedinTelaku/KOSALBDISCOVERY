function loginValidate(){
    if(document.myForm.username.value == ""){
        alert("Email is required");
        document.myForm.username.focus();
        return false;
    }
    if(document.myForm.username.value.length < 6){
        alert("Username should contain at least 6 characters");
        document.myForm.username.focus();
        return false;
    }
    if(document.myForm.password.value == "" ){
        alert("Password is required");
        document.myForm.password.focus();
        return false;
    }
    if(document.myForm.password.value.length < 6){
        alert("Password should contain at least 6 characters");
        document.myForm.password.focus();
        return false;
    }
}
