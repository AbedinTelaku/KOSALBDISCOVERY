$(function(){
    var $registerForm=$("#registration");
    if($registerForm.length){
        $registerForm.validate({
            rules:{
                fullname:{
                    required: true
                },
                surname:{
                    required: true
                },
                age:{
                    required: true
                },
                email:{
                    required:true
                },
                password:{
                    required:true
                },
                username:{
                    required:true
                }

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
                age:{
                    required:"Write your age"
                },
                fullname:{
                    required:"Write your name"
                },
                surname:{
                    required:"Write your surname"
                }

            }
        })
    }
})