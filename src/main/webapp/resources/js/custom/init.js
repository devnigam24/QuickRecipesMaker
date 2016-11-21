function aa(log){
	console.log(log.trim());
}
(function($){
  $(function(){

    $('.menuButton').sideNav();

  }); // end of document ready
})(jQuery); // end of jQuery name space
$(document).ready(function(){
    
    setDefautValues();
  });

function setDefautValues(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal-trigger').leanModal();
    
    $('.chips').material_chip();
    $('.chips-placeholder').material_chip({
        placeholder: '+ Ingredients',
        secondaryPlaceholder: '+ Tag',
    });

    var chip = {
        ingredient: 'chip content',
          id: 1,
    };
    $(".drag-target").trigger('click');
}
$("#dropdowntimer").click(function(){
    
  var time1 = $('#dropdowntimer option:selected').text();
    alert("clicked "+time1 );
});

$("#dropdowncalorie").click(function(){
    alert("clicked.");
});


 
 function submitForm(idName){
	$("#"+idName.trim()).sumbit();
 }

var url ="http://localhost:3000/Signup";




 // Signup
function signup() {
    var fname = document.getElementById("first_name").value;
    var lname = document.getElementById("last_name").value;
    var email = document.getElementById("email").value;
    var name = document.getElementById("username").value;
    var pwd = document.getElementById("password").value;
    var j = JSON.parse('{"username":"' + name + '","password":"' + pwd + '","firstname":"' + fname + '","lastname":"' + lname + '","email":"' + email + '"}');
    console.log(j);
    ajaxPosturl(url,j);
    $("#username").val("   ");
    $("#first_name").val("");
    $("#last_name").val("");
    $("#email").val("");
    $("#password").val("");

}


//Login
function login() {
    var name = document.getElementById("Username").value;
    var pwd = document.getElementById("Password").value;
    var j = JSON.parse('{"username":"' + name + '","password":"' + pwd + '"}');
    console.log(j);
    ajaxPosturl(url,j)
}


function updateUsrDetails(username) {
    var firstName = $("#fName").val();
    var lastName = $("#lName").val();
    var userName = $("#uNameTxt").val();
    var email = $("#eMail").val();
    var pwd = $("#pAssword").val();
    var abtMe = $("#aBoume").val();
    var fav = $("#fav").val();
    var obj = JSON.parse('{"firstname" : "' + firstName + '","lastname" : "' + lastName + '","aboutme" : "' + abtMe + '","Password" : "' + pwd + '","favourite" : "' + fav + '"}');
   ajaxPosturl(url,obj); 

}


