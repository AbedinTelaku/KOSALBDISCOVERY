
$("#addNewTouristPlaceButton").click(function(){
    getCities();
});




function getCities() {

    $.ajax({
        url: "http://localhost:8080/api/city/get/all/cities",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        dataType: "JSON",
        //data: JSON.stringify(user),
        success: function (data) {
            var cities = JSON.parse(JSON.stringify(data));
            console.log(cities)
            showCities(cities)
           
        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    });

}


function showCities(cities){
    var touristCitiesList = document.getElementById("newTouristPlaceCity");

    for( i in cities){
       var city = cities[i];

       var cityname=city.name;

       var cityNameText = document.createTextNode(cityname);

       var option = document.createElement("option");
       option.appendChild(cityNameText);
       option.value=cityNameText;

       touristCitiesList.appendChild(option);
       
    }
}

