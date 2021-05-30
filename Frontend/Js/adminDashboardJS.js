var editReservations = document.getElementById("editReservations");
var newReservation = document.getElementById("newReservation");
var reservationsButton = document.getElementById("reservationsButton");

$("#").click(function (event){
    if(editReservations.classList.value=="list-group-item hide"){

        reservationsButton.classList.add("active");
        editReservations.classList.remove("hide");
        newReservation.classList.remove("hide");

    }else{
        reservationsButton.classList.remove("active");
        editReservations.classList.add("hide");
        newReservation.classList.add("hide");
    }
})

var tourists = document.getElementById("tourists");
var businesses = document.getElementById("businesses");
var usersButton = document.getElementById("usersButton");

$("#").click(function (event){
    if(tourists.classList.value=="list-group-item hide"){

        usersButton.classList.add("active");
        tourists.classList.remove("hide");
        businesses.classList.remove("hide");
    }else{
        usersButton.classList.remove("active");
        tourists.classList.add("hide");
        businesses.classList.add("hide");
    }
})


var editEvents = document.getElementById("editEvents");
var newEvent = document.getElementById("newEvent");
var eventsButton = document.getElementById("eventsButton");


$("#").click(function (event) {
    if(editEvents.classList.value=="list-group-item hide"){

        eventsButton.classList.add("active");
        editEvents.classList.remove("hide");
        newEvent.classList.remove("hide");
    }else{
        eventsButton.classList.remove("active");
        editEvents.classList.add("hide");
        newEvent.classList.add("hide");
    }
})

