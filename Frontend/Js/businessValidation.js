function myFunction() {
    var x;
    var text;


    x = document.getElementById("full_name").value;


    if (full_name=="") {
        text = "Input not valid";
    } else {
        text = "Input OK";
    }
    document.getElementById("demo").innerHTML = text;
}