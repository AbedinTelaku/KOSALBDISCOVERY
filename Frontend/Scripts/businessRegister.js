$(function(){
    var $registerForm=$("#registration");
    if($registerForm.length){
        $registerForm.validate({
            rules:{
                fullname:{
                    required: true
                },
                email:{
                    required: true
                },
                password:{
                    required: true
                },
                username:{
                    required:true
                },
                phonenumber:{
                    required:true
                },
                ownerid:{
                    required:true
                },
                fiscalnumber:{
                    required:true
                },
                businessnumber:{
                    required:true
                },


            },messages:{
                username:{
                    required: "Write username"
                },
                email:{
                    required: "Write an email"
                },
                password:{
                    required: "Write an password"
                },
                phonenumber:{
                    required:"Write your phone number"
                },
                fullname:{
                    required:"Write your name"
                },
                ownerid:{
                    required:"Write  Owner Id"
                },
                fiscalnumber:{
                    required:"Write fiscal number"
                },
                businessnumber:{
                    required:"Write business number"
                },


            }
        })
    }
})