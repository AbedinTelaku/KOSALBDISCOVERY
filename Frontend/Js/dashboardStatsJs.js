window.onload = function WindowLoad(event) {

    getBusinessNumber()
    getTouristsNumber()
    getAllUsersNumber()
}

var totalUsersNumber = 0;


//show businesses number
var businessesNumberP = document.getElementById("businessesNumberP");

function showBusinessesNum(num) {
    var businessesNumber = document.createTextNode(num);
    businessesNumberP.appendChild(businessesNumber);
}

function getBusinessNumber() {
    $.ajax({
        url: "http://localhost:8080/api/business/get/businesses/number",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        dataType: "JSON",
        //data: JSON.stringify(user),
        success: function (data) {
            var businessesNumber = JSON.parse(JSON.stringify(data));

            showBusinessesNum(businessesNumber)
        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    });

}

//show tourists number

var touristsNumberP = document.getElementById("touristsNumberP");

function showTouristsNum(num) {
    var touristsNumber = document.createTextNode(num);
    touristsNumberP.appendChild(touristsNumber);
}

function getTouristsNumber() {
    $.ajax({
        url: "http://localhost:8080/api/tourist/get/tourists/number",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        dataType: "JSON",
        //data: JSON.stringify(user),
        success: function (data) {
            var touristsNumber = JSON.parse(JSON.stringify(data));


            showTouristsNum(touristsNumber)

        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    });

}


//get all users numer
var totalUsersNumberP = document.getElementById("totalUsersNumberP");

function showAllUsersNumber(num) {
    var totalUsersNum = document.createTextNode(num);
    totalUsersNumberP.appendChild(totalUsersNum);
}

function getAllUsersNumber() {
    $.ajax({
        url: "http://localhost:8080/api/user/get/users/number",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        dataType: "JSON",
        //data: JSON.stringify(user),
        success: function (data) {
            var usersNumber = JSON.parse(JSON.stringify(data));

            showAllUsersNumber(usersNumber)

        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    });

}



 