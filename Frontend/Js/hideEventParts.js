var createEventDiv = document.getElementById("createEventDiv");
var allEventsDiv = document.getElementById("allEventsDiv");
var happeningEvents = document.getElementById("happeningEventsDiv");

$("#allEventsButton").click(function (event) {
  if (allEventsDiv.classList == "hide") {
    showAllEventsDiv();
  } else {
    allEventsDiv.classList.add("hide");
  }
});

$("#createEventButton").click(function (event) {
  showCreateEventDiv();
});
$("#happeningEventsButton").click(function (event) {
  if (happeningEvents.classList == "hide") {
    happeningEvents.classList.remove("hide");
    createEventDiv.classList.add("hide");
    allEventsDiv.classList.add("hide");
  } else {
    happeningEvents.classList.add("hide");
  }
});

function showCreateEventDiv() {
  createEventDiv.classList.remove("hide");
  happeningEvents.classList.add("hide");
  allEventsDiv.classList.add("hide");
}

function showAllEventsDiv() {
  allEventsDiv.classList.remove("hide");
  happeningEvents.classList.add("hide");
  createEventDiv.classList.add("hide");
}

function showHappeningEvents() {
  happeningEvents.classList.remove("hide");
  createEventDiv.classList.add("hide");
  allEventsDiv.classList.add("hide");
}
