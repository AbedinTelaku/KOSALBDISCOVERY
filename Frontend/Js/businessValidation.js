function loginValidate(){
    if(document.myForm.fullname.value == "" || document.myForm.fullname.value ==null){
        printError("Name is required");
        return false;
    }
    if(document.myForm.email.value == ""){
        alert("Email is required");
        document.myForm.email.focus();
        return false;
    }
    if(document.myForm.password.value == "" ){
        alert("Password is required");
        document.myForm.password.focus();
        return false;
    }
    if(document.myForm.password.value.length < 6){
        alert("Passowrd should contain at least 6 characters");
        document.myForm.password.focus();
        return false;
    }
    if(document.myForm.username.value == ""){
        alert("Username is required");
        document.myForm.username.focus();
        return false;
    }
    if(document.myForm.username.value.length < 6){
        alert("Username should contain at least 6 characters");
        document.myForm.username.focus();
        return false;
    }


    if(document.myForm.phonenumber.value == ""){
        alert("Phone number is required");
        document.myForm.phonenumber.focus();
        return false;
    }
    if(document.myForm.ownerid.value == "" ){
        alert("Owner id is required");
        document.myForm.ownerid.focus();
        return false;
    }
    if(document.myForm.fiscalnumber.value == ""){
        alert("Fiscal number is required");
        document.myForm.fiscalnumber.focus();
        return false;
    }
    if(document.myForm.businessnumber.value == ""){
        alert("Business number is required");
        document.myForm.businessnumber.focus();
        return false;
    }

}