// function printError(elemId, hintMsg) {
//   document.getElementById(elemId).innerHTML = hintMsg;
// }
$("#registerButton").click(function () {
  alert("hello");
  var name = document.getElementById("name").value;
  var age = document.getElementById("age").value;
  var gender = document.getElementById("name").value;
  var email = document.getElementById("name").value;
  var password = document.getElementById("name").value;
  var username = document.getElementById("name").value;
  var rolee = "tourist";
  var statuus = "active";

  tourist = {
    name: name,
    age: age,
    gender: gender,
    email: email,
    password: password,
    username: username,
    role: rolee,
    status: statuus,
  };

  registerTourist(tourist);
});

function registerTourist(tourist) {
  $.ajax({
    url: "http://localhost:8080/api/tourist/create/tourist",
    type: "post",
    contentType: "application/json; charset=utf-8",
    // dataType: "json",
    data: JSON.stringify(tourist),
    success: function (res) {
      // localStorage.setItem('kuizi', JSON.stringify(res))

      console.log(tourist);
    },
    error: function (request, status, error) {
      console.log(error);
      console.log(status);
    },
  });
}

var tourist = {
  name: "",
  age: "",
  gender: "",
  email: "",
  password: "",
  username: "",
  role: "",
  status: "",
};
