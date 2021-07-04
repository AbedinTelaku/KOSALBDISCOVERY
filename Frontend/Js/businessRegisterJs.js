// function validateForm() {
//     var fullname = document.myForm.fullname.value;
//     var email = document.myForm.email.value;
//     var businessPassword = document.myForm("password").value;
//     var businessUsername = document.myForm("user_name").value;
//     var businessPhoneNumber = document.myForm("phonenumber").value;
//     var businessOwnerId = document.myForm("ownerid").value;
//     var businessFiscalNumber = document.myForm("fiscalnumber").value;
//     var businessNum = document.myForm("businessnumber").value;
//     var businessActi = document.myForm("businessactivity").value;
//     var statuss = "activ"
//     var rolee = "business";
//
//
//     function printError(elemId, hintMsg) {
//         document.getElementById(elemId).innerHTML = hintMsg;
//     }
//
//     var nameErr = emailErr  = true;
//
//     // Validate name
//     if(fullname == "") {
//         printError("nameErr", "Please enter your name");
//     } else {
//         var regex = /^[a-zA-Z\s]+$/;
//         if(regex.test(fullname) === false) {
//             printError("nameErr", "Please enter a valid name");
//         } else {
//             printError("nameErr", "");
//             nameErr = false;
//         }
//     }
//
//     // Validate email address
//     if(email == "") {
//         printError("emailErr", "Please enter your email address");
//     } else {
//         // Regular expression for basic email validation
//         var regex = /^\S+@\S+\.\S+$/;
//         if(regex.test(email) === false) {
//             printError("emailErr", "Please enter a valid email address");
//         } else{
//             printError("emailErr", "");
//             emailErr = false;
//         }
//     }
//
//
//     else{
//         business = {
//             name: businessName,
//             email: businessEmail,
//             password: businessPassword,
//             username: businessUsername,
//             tel_Number: businessPhoneNumber,
//             owner_ID: businessOwnerId,
//             fiscal_Number: businessFiscalNumber,
//             business_Number: businessNum,
//             business_Activity: businessActi,
//             status: statuss,
//             role: rolee
//
//         }
//         console.log(business)
//
//         registerBusiness(business);
//     }
// });
//
//
// function registerBusiness(business) {
//
//
//     $.ajax({
//         url: "http://localhost:8080/api/business/create/business",
//         type: 'post',
//         contentType: "application/json; charset=utf-8",
//         // dataType: "json",
//         data: JSON.stringify(business),
//         success: function (res) {
//             // localStorage.setItem('kuizi', JSON.stringify(res))
//
//             console.log(business)
//
//
//         },
//         error: function (request, status, error) {
//             console.log(error);
//             console.log(status);
//         }
//     })
// }
//
//
// var business = {
//     name: "",
//     email: "",
//     password: "",
//     username: "",
//     tel_Number: "",
//     owner_ID: "",
//     fiscal_Number: "",
//     business_Number: "",
//     business_Activity: "",
//     status: "",
//     role: ""
// }
