$( document ).ready(function() {  
 let states = [false,false,false,false,false,false,false,false];
  $("#echo").click(function() {
      if (states[1] != false)
      {
          $("#0").hide();
          states[1] = false;
      }else{
          $("#0").show();
          states[1] = true;
      }
    });
    $("#varDump").click(function() {
      if (states[1] != false)
      {
          $("#1").hide();
          states[1] = false;
      }else{
          $("#1").show();
          states[1] = true;
      }
    });
  });