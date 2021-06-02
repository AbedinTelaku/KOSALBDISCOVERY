var statsDiv = document.getElementById("bodyContentMain");
var allBusinessesDiv = document.getElementById("allBusinessesTable");
var allAdminsDiv = document.getElementById("allAdminsTable");
var allTouristsDiv = document.getElementById("allTouristsTable")
var blockedUsersDiv = document.getElementById("blockedUsersTable");

// show Businesses
$("#businessesButton").click( function(event){
    if(allBusinessesDiv.classList == "hide"){

       showAllBusinessesDiv()
    }else{ 
      showStatsDiv()
    }
});


//show Tourists
$("#touristsButton").click( function(event){
    if(allTouristsDiv.classList == "hide"){

        showAllTouristsDiv()
    }else{ 
      showStatsDiv()
    }
});


//show admins
$("#adminButton").click( function(event){
    if(allAdminsDiv.classList == "hide"){

        showAllAdminsDiv()
    }else{ 
      showStatsDiv()
    }
});


// show blocked users
$("#blockedUsersButton").click( function(event){
    if(blockedUsersDiv.classList == "hide"){

        showBlockedUsersDiv()
    }else{ 
      showStatsDiv()
    }
});

function showStatsDiv(){
    statsDiv.classList.remove("hide");

    hideAllBusinessesDiv()
    hideAllTouristsDiv()
    hideAllAdmins()
    hideBlockedUsersDiv()
}

function showAllBusinessesDiv(){
    allBusinessesDiv.classList.remove("hide");

    hideStats()
    hideAllTouristsDiv()
    hideAllAdmins()
    hideBlockedUsersDiv()
}

function showAllTouristsDiv(){
    allTouristsDiv.classList.remove("hide");

    hideStats()
    hideAllAdmins()
    hideAllBusinessesDiv()
    hideBlockedUsersDiv()
}

function showAllAdminsDiv(){
    allAdminsDiv.classList.remove("hide");

    hideStats()
    hideAllTouristsDiv()
    hideAllBusinessesDiv()
    hideBlockedUsersDiv()
}

function showBlockedUsersDiv(){
    blockedUsersDiv.classList.remove("hide");

    hideStats()
    hideAllTouristsDiv()
    hideAllBusinessesDiv()
    hideAllAdmins()
}


function hideStats(){
    statsDiv.classList.add("hide");
}

function hideAllBusinessesDiv(){
    allBusinessesDiv.classList.add("hide");
}
function hideAllAdmins(){
    allAdminsDiv.classList.add("hide");
}
function hideBlockedUsersDiv(){
    blockedUsersDiv.classList.add("hide");
}

function hideAllTouristsDiv(){
    allTouristsDiv.classList.add("hide");
}