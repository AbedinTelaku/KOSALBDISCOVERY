var statsDiv = document.getElementById("bodyContentMain");
var allBusinessesDiv = document.getElementById("allBusinessesTable");
var allUsersDiv = document.getElementById("allUsersTable");
var allAdminsDiv = document.getElementById("allAdminsTable");
var blockedUsersDiv = document.getElementById("blockedUsersTable");


$("#businessesButton").click( function(event){
    allBusinessesDiv.classList.remove("hide");

    statsDiv.classList.add("hide");
    allUsersDiv.classList.add("hide");
    allAdminsDiv.classList.add("hide");
    blockedUsersDiv.classList.add("hide");
    
});