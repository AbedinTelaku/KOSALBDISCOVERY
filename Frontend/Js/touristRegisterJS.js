

$("#registerButton").click(function(event){

    var name = document.getElementById("name").value;
    var surname = document.getElementById("surname").value;
    var age = document.getElementById("age").value;
    var gender = document.getElementById("gender").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var username = document.getElementById("username").value;
    var rolee="tourist";

    tourist={
        name:name,
        surname:surname,
        age:age,
        gender:gender,
        email:email,
        password:password,
        username:username,
        role:rolee
    }

    console.log(tourist)

    registerTourist(tourist);

});





function registerTourist(tourist) {



    $.ajax({
        url: "http://localhost:8080/api/tourist/create/tourist",
        type: 'post',
        contentType: "application/json; charset=utf-8",
        // dataType: "json",
        data: JSON.stringify(tourist),
        success: function (res) {
            // localStorage.setItem('kuizi', JSON.stringify(res))

            console.log(tourist)




        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    })
}



var tourist={
    name:"",
    surname:"",
    age:"",
    gender:"",
    email:"",
    password:"",
    username:"",
    role:""
}