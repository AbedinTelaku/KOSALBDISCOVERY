var cityName = document.getElementById("newCityName");
var cityZipCode = document.getElementById("newCityZip");

$("#citySaveChangesButton").click(function(){
    if(cityName.value=="" || cityZipCode.value == ""){
        alert("Please fill all the fields");
    }else{
        var cName=cityName.value;
        var czip=cityZipCode.value;
        city={
            name:cName,
            zipCode:czip
        }

        createCity(city);

        cityName.value="";
        cityZipCode.value="";
    }
    
});

function createCity(city){
    $.ajax({
        url:"http://localhost:8080/api/city/create",
        type:"post",
        contentType:"application/json; charset=utf-8",
        data: JSON.stringify(city),
        success: function(res){
            console.log(city)
        },
        error: function(request,error,status){
            console.log(error)
            console.log(status)
        }
    })
}

city={
    name:"",
    zipCode:""
}




// add new tourist place

var toursitPlaceName = document.getElementById("newTouristPlaceName");
var toursitPlaceCity = document.getElementById("newTouristPlaceCity");

$("#touristPlaceSaveChangesButton").click(function(){
    if(toursitPlaceCity.value == "" || toursitPlaceName.value == ""){
        alert("Plase fill all required fields.")
    }else{
        var tPName=toursitPlaceName.value;
        var tPCity=toursitPlaceCity.value;

        touristPlace={
            name:tPName,
            city:tPCity
        }
    }

});


function createCity(city){
    $.ajax({
        url:"http://localhost:8080/api/city/create",
        type:"post",
        contentType:"application/json; charset=utf-8",
        data: JSON.stringify(city),
        success: function(res){
            console.log(city)
        },
        error: function(request,error,status){
            console.log(error)
            console.log(status)
        }
    })
}

touristPlace={
    name:"",
    city:""
}
