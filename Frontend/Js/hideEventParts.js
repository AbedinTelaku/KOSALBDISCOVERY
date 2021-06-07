var createEventDiv = document.getElementById("createEventDiv");
var allEventsDiv = document.getElementById("allEventsDiv");




$("#allEventsButton").click( function(event){

        showAllEventsDiv()
 
});

$("#createEventButton").click( function(event){

    showCreateEventDiv()

});


function showCreateEventDiv(){
    createEventDiv.classList.remove("hide");

    allEventsDiv.classList.add("hide");
}

function showAllEventsDiv(){
    allEventsDiv.classList.remove("hide");

    createEventDiv.classList.add("hide");
}