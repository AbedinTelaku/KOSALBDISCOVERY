function loginValidate(){
    if(document.myForm.username.value == ""){
        alert("Shenoni usernamin");
        document.myForm.username.focus();
        return false;
    }
    if(document.myForm.username.value.length < 6){
        alert("Username duhet te permbaje se paku 6 karaktere");
        document.myForm.username.focus();
        return false;
    }
    if(document.myForm.password.value == "" ){
        alert("Shenoni Fjalkalimin");
        document.myForm.password.focus();
        return false;
    }
    if(document.myForm.password.value.length < 6){
        alert("Fjalkalimi duhet te permbaje se paku 6 karaktere");
        document.myForm.password.focus();
        return false;
    }
}
