



$("#businessesButton").click( function(event){
    getBusinesses();
    
});


function getBusinesses() {

    $.ajax({
        url: "http://localhost:8080/api/business/get/all/businesses",
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        dataType: "JSON",
        //data: JSON.stringify(user),
        success: function (data) {
            var business = JSON.parse(JSON.stringify(data));
            
            showBusinesses(business);
        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    });

}

function showBusinesses(businesses){
    //var table = document.getElementById("table");
    var tableBody = document.getElementById("tableBody");

    for(i in businesses){
        var tableRow = document.createElement("tr");    
        var business = businesses[i];
       
        for(j in business){
            var tableData = document.createElement("td");           
            var text = document.createTextNode(business[j]);
            tableData.appendChild(text);
            tableRow.appendChild(tableData);            
        }
        tableBody.appendChild(tableRow);
    }
    
}


