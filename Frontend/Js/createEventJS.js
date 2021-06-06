

$("#crEventSaveChangesButton").click(function(){

    var crEventName  =document.getElementById("crEventName").value;
    var crEventDescription  =document.getElementById("crEventDescription").value;
    var crEventStartDate  =document.getElementById("crEventStartDate").value;
    var crEventStartTime  =document.getElementById("crEventStartTime").value;
    var crEventEndDate  =document.getElementById("crEventEndDate").value;
    var crEventPhoto  =document.getElementById("crEventPhoto").value;
    var crEventCity  =document.getElementById("crEventCity").value;
    var crEventTouristPlace  =document.getElementById("crEventTouristPlace").value;

    eventt={
        name:crEventName,
        description:crEventDescription,
        startDate:crEventStartDate,
        endDate:crEventEndDate,
        startTime:crEventStartTime+":00",
        photoPath:crEventPhoto,
        cityName:crEventCity,
        touristPlaceName:crEventTouristPlace,
        username:"eltonboshnjaku",
        
    }
   
    console.log(eventt)
    createEvent(eventt)
})


function createEvent(event){
    $.ajax({
        url: "http://localhost:8000/api/event/create",
        type: 'post',
        contentType: "application/json; charset=utf-8",
        // dataType: "json",
        data: JSON.stringify(event),
        success: function (res) {
       

            console.log(event)


        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    })
}


eventt={
    name:"",
    description:"",
    startDate:"",
    endDate:"",
    startTime:"",
    photoPath:"",
    cityName:"",
    touristPlaceName:"",
    username:""
}