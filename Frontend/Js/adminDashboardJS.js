


var mainContent = document.getElementById("bodyContent");
var headerContent = document.getElementById("headerContent");

var darkModeCheck=document.getElementById("darkModeSwitchCheck");
var lightModeCheck=document.getElementById("lightModeSwitchCheck");

  
  $("#darkModeSwitchCheck").on('change', function() {
      if ($(this).is(':checked')) {
          mainContent.classList.add("dark-Mode-One");
          headerContent.classList.add("dark-Mode-Zero");
          lightModeCheck.checked=false;
         
      }
      else {
         mainContent.classList.remove("dark-Mode-One");
         headerContent.classList.remove("dark-Mode-Zero");
         lightModeCheck.checked=true;
      }
  });

  $("#lightModeSwitchCheck").on('change', function() {
    if ($(this).is(':checked')) {
        mainContent.classList.remove("dark-Mode-One");
        headerContent.classList.remove("dark-Mode-Zero");
        darkModeCheck.checked=false;
       
    }
    else {
       mainContent.classList.add("dark-Mode-One");
       headerContent.classList.add("dark-Mode-Zero");
       darkModeCheck.checked=true;
    }
});

