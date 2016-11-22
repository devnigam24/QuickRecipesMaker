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
    var dataToPopulate = $("#SignUpLoginController").serialize();
    ajaxJsonUrl("signUpThisUser",dataToPopulate,'POST');
}


//Login
function login() {
	var dataToPopulate = $("#LoginController").serialize();
	ajaxJsonUrl("loginThisUser",dataToPopulate,'POST');
}

//recipe search form trigger
$("#dropdowncalorie").change(function(){
	alert(this.id);
});


