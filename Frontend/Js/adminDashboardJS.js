


var mainContent = document.getElementById("bodyContent");
var headerContent = document.getElementById("headerContent");

var darkModeCheck=document.getElementById("darkModeSwitchCheck");
var lightModeCheck=document.getElementById("lightModeSwitchCheck");

var allUsersStats = document.getElementById("allUsersStats");
var TouristsStats = document.getElementById("TouristsStats");
var BusinessesStats = document.getElementById("BusinessesStats");
var reservationsStatsChild = document.getElementById("reservationsStatsChild");
var eventsStatsChild = document.getElementById("eventsStatsChild");

$("#darkModeSwitchCheck").on('change', function () {
    if ($(this).is(':checked')) {
        mainContent.classList.add("dark-Mode-One");
        headerContent.classList.add("dark-Mode-Zero");
        allUsersStats.classList.add("dark-Mode-Zero");
        TouristsStats.classList.add("dark-Mode-Zero");
        BusinessesStats.classList.add("dark-Mode-Zero");
        reservationsStatsChild.classList.add("dark-Mode-Zero");
        eventsStatsChild.classList.add("dark-Mode-Zero");

        lightModeCheck.checked = false;

    }
    else {
        mainContent.classList.remove("dark-Mode-One");
        headerContent.classList.remove("dark-Mode-Zero");
        allUsersStats.classList.remove("dark-Mode-Zero");
        TouristsStats.classList.remove("dark-Mode-Zero");
        BusinessesStats.classList.remove("dark-Mode-Zero");
        reservationsStatsChild.classList.remove("dark-Mode-Zero");
        eventsStatsChild.classList.remove("dark-Mode-Zero");

        lightModeCheck.checked = true;
    }
});

$("#lightModeSwitchCheck").on('change', function () {
    if ($(this).is(':checked')) {
        mainContent.classList.remove("dark-Mode-One");
        headerContent.classList.remove("dark-Mode-Zero");
        allUsersStats.classList.remove("dark-Mode-Zero");
        TouristsStats.classList.remove("dark-Mode-Zero");
        BusinessesStats.classList.remove("dark-Mode-Zero");
        reservationsStatsChild.classList.remove("dark-Mode-Zero");
        eventsStatsChild.classList.remove("dark-Mode-Zero");

        darkModeCheck.checked = false;

    }
    else {
        mainContent.classList.add("dark-Mode-One");
        headerContent.classList.add("dark-Mode-Zero");
        allUsersStats.classList.add("dark-Mode-Zero");
        TouristsStats.classList.add("dark-Mode-Zero");
        BusinessesStats.classList.add("dark-Mode-Zero");
        reservationsStatsChild.classList.add("dark-Mode-Zero");
        eventsStatsChild.classList.add("dark-Mode-Zero");
        
        darkModeCheck.checked = true;
    }
});

