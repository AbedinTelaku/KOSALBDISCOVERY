$("#registerButton").click(function (event) {

    var name = document.getElementById("nameInput").value;
    var age = document.getElementById("ageInput").value;
    var gender = document.getElementById("genderInput").value;
    var email = document.getElementById("emailInput").value;
    var password = document.getElementById("passwordInput").value;
    var username = document.getElementById("usernameInput").value;
    var rolee = "tourist";
    var statuus = "active";

    tourist = {
        full_name: name,
        age: age,
        gender: gender,
        email: email,
        password: password,
        username: username,
        role: rolee,
        status:statuus
    }

    console.log(tourist)

    registerTourist(tourist);

});


function registerTourist(tourist) {


    $.ajax({
        url: "http://localhost:9000/api/tourist/create/tourist",
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


var tourist = {
    full_name: "",
    age: "",
    gender: "",
    email: "",
    password: "",
    username: "",
    role: "",
    status:""
}