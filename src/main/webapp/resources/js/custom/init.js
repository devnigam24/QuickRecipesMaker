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
    
    var pageFragmentToOpen = "${pageFragmentToOpen}";
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
    $('select').material_select();
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

//recipe search form trigger
$("#dropdowncalorie").change(function(){
	alert(this.id);
});

function updateProfile(){
	$('#fname').attr('disabled',false);
	$('#lname').attr('disabled',false);
	$('#emailid').attr('disabled',false);
	$('#aboutme').attr('disabled',false);
	$('#password').attr('disabled',false);
	$("#saveButton").removeClass("hide");
	$("#updateButton").addClass("hide");	
}

function saveProfile(formID){
	var dataToPopulate = $("#"+formID).serialize();
	dataToPopulate = dataToPopulate + "&userName=" +$("#username").val();
	ajaxJsonUrl($("#"+formID).attr('action'),dataToPopulate,$("#"+formID).attr('method'));
}

function searchRecipe(formID){
	var ingredientsList = $('.chips-placeholder').material_chip('data');
	var ingredientsListAsString = "";
	for(var i=0;i<ingredientsList.length;i++){
		ingredientsListAsString = ingredientsListAsString + ingredientsList[i].tag;
		if(i != ingredientsList.length - 1){
			ingredientsListAsString = ingredientsListAsString + ",";
		}		
	}
	
	var dataToPopulate = $("#"+formID).serialize();
	dataToPopulate = dataToPopulate + "&ingredientsList=" + ingredientsListAsString;
	ajaxJsonUrl($("#"+formID).attr('action'),dataToPopulate,$("#"+formID).attr('method'));
}
