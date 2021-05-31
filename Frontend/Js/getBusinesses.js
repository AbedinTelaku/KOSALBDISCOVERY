
$("#businessesButton").click( function(event){
    getBusinesses()
});

var businesses="";
function getBusinesses() {

    $.ajax({
        url: "http://localhost:8080/api/business/get/all/businesses",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        dataType: "JSON",
        //data: JSON.stringify(user),
        success: function (data) {
            var business = JSON.parse(JSON.stringify(data));
            // var kursi=kurset.data;
            //console.log("businesses: " + JSON.stringify(business))
            console.log(business)
            //console.log(JSON.parse(JSON.stringify(data)))
            businesses=business;
        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    });

}


function showBusinesses(){
    var table = document.getElementById("table");
    var tableBody = document.getElementById("tableBody");

    var thead = document.createElement("thead"); //cjild of table
    var headRow  =document.createElement("tr");
    thead.appendChild(headRow);
    var headHeads = document.createElement("th");

    document.write(
   
        )
}


