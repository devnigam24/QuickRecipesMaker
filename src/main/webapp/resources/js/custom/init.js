function aa(log){
	console.log(log.trim());
}
(function($){
  $(function(){

    //$('.button-collapse').sideNav();

  }); // end of document ready
})(jQuery); // end of jQuery name space
$(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal-trigger').leanModal();
  });
$("#dropdowntimer").click(function(){
    
  var time1 = $('#dropdowntimer option:selected').text();
    alert("clicked "+time1 );
});

$("#dropdowncalorie").click(function(){
    alert("clicked.");
});

$('.chips').material_chip();
  
$('.chips-placeholder').material_chip({
    placeholder: 'Enter a Ingredient',
   
  });
  
 var chip = {
    tag: 'chip content'
  };
 
 function submitForm(idName){
	$("#"+idName.trim()).sumbit();
 }