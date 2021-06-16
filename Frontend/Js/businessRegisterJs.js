$("#registerButton").click(function (event) {

    var businessName = document.getElementById("full_name").value;
    var businessEmail = document.getElementById("email").value;
    var businessPassword = document.getElementById("password").value;
    var businessUsername = document.getElementById("user_name").value;
    var businessPhoneNumber = document.getElementById("phonenumber").value;
    var businessOwnerId = document.getElementById("ownerid").value;
    var businessFiscalNumber = document.getElementById("fiscalnumber").value;
    var businessNum = document.getElementById("businessnumber").value;
    var businessActi = document.getElementById("businessactivity").value;
    var statuss = "activ"
    var rolee = "business";


    if (businessName == "" ){

    var errorname = document.getElementById("error_name");

    var text_name = document.createTextNode("Please fill required data");

    errorname.appendChild(text_name);

    }

    if (businessEmail == ""){

        var erroremail = document.getElementById("error_email");

        var text_email = document.createTextNode("Please fill required data");

        erroremail.appendChild(text_email);

    }

    if (businessPassword == ""){
        var errorpassword = document.getElementById("error_password");

        var text_password = document.createTextNode("Please fill required data");

        errorpassword.appendChild(text_password);

    }
    if (businessUsername == ""){
        var errorusername = document.getElementById("error_username");

        var text_username = document.createTextNode("Please fill required data");

        errorusername.appendChild(text_username);

    }
    if (businessPhoneNumber == ""){
        var errorphone = document.getElementById("error_number");

        var text_phone = document.createTextNode("Please fill required data");

        errorphone.appendChild(text_phone);

    }
    if (businessOwnerId == ""){
        var errorId = document.getElementById("error_id");

        var text_Id = document.createTextNode("Please fill required data");

        errorId.appendChild(text_Id);

    }
    if (businessFiscalNumber == ""){
        var errorfiscal = document.getElementById("error_fiscal");

        var text_fiscal = document.createTextNode("Please fill required data");

        errorfiscal.appendChild(text_fiscal);

    }
    if (businessNum == ""){
        var errorbusinessNR = document.getElementById("error_businessNR");

        var text_businessNR = document.createTextNode("Please fill required data");

        errorbusinessNR.appendChild(text_businessNR);

    }

    else{
        business = {
            name: businessName,
            email: businessEmail,
            password: businessPassword,
            username: businessUsername,
            tel_Number: businessPhoneNumber,
            owner_ID: businessOwnerId,
            fiscal_Number: businessFiscalNumber,
            business_Number: businessNum,
            business_Activity: businessActi,
            status: statuss,
            role: rolee
           
    }
    console.log(business)

    registerBusiness(business);
}
//{else{
           //i kontrollon me if secilin vec e vec
           // if(input==""){
        // label.write a qysh o metoda "name is required*"
           //}
//}
});


function registerBusiness(business) {


    $.ajax({
        url: "http://localhost:8080/api/business/create/business",
        type: 'post',
        contentType: "application/json; charset=utf-8",
        // dataType: "json",
        data: JSON.stringify(business),
        success: function (res) {
            // localStorage.setItem('kuizi', JSON.stringify(res))

            console.log(business)


        },
        error: function (request, status, error) {
            console.log(error);
            console.log(status);
        }
    })
}


var business = {
    name: "",
    email: "",
    password: "",
    username: "",
    tel_Number: "",
    owner_ID: "",
    fiscal_Number: "",
    business_Number: "",
    business_Activity: "",
    status: "",
    role: ""
}