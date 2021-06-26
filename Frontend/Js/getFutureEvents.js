
$("#futureEventsButton").click(function(){
    getFutureBusinesses()
});




function getFutureBusinesses() {

    $.ajax({
        url: "http://localhost:8000/api/event/get/happening/events",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        dataType: "JSON",
        //data: JSON.stringify(user),
        success: function (data) {
            var eventsF = JSON.parse(JSON.stringify(data));

            console.log(eventsF)
            showFutureEvents(eventsF)

        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    });

}

function  showFutureEvents(eventsF){
    if(isexecuted==true){


        var allEventsDiv = document.getElementById("futureEventsDiv");

        for(i in eventsF){
            var event = eventsF[i];

            var eventDiv = document.createElement("div");
            eventDiv.classList.add("event");


            //img div
            var imgDiv = document.createElement("div");//
            imgDiv.classList.add("eventImg");

            var img = document.createElement("img");
            img.src=event.photoPath;

            imgDiv.appendChild(img);
            //
            var nameDateDiv = document.createElement("div");//
            nameDateDiv.classList.add("nameAndDate");

            var nameDiv = document.createElement("div");
            nameDiv.classList.add("eventName");

            var nameH3=document.createElement("h4");
            var name = document.createTextNode(event.name)

            nameH3.appendChild(name)
            nameDiv.appendChild(nameH3)
            //date
            var dateDiv = document.createElement("div");
            dateDiv.classList.add("eventDate");

            var dateH3=document.createElement("h4");
            var date = document.createTextNode("Start: "+event.startDate+"."+"     Time: "+ event.startTime)

            dateH3.appendChild(date)
            dateDiv.appendChild(dateH3)

            nameDateDiv.appendChild(nameDiv)
            nameDateDiv.appendChild(dateDiv)

            //description
            var descriptionDiv=document.createElement("div");
            descriptionDiv.classList.add("eventDescription");

            //  var descriptionH4 = document.createElement("h4");
            //  var descriptionTitle = document.createTextNode("Description");
            // descriptionH4.appendChild(descriptionTitle);

            var descriptionP=document.createElement("p");
            var description=document.createTextNode(event.description);
            descriptionP.appendChild(description);

            //  descriptionDiv.appendChild(descriptionH4)
            descriptionDiv.appendChild(descriptionP)

            ////
            eventDiv.appendChild(imgDiv)
            eventDiv.appendChild(nameDateDiv)
            eventDiv.appendChild(descriptionDiv)

            allEventsDiv.appendChild(eventDiv)
        }

    }
}