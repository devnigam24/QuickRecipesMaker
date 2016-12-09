function aa(log){
	console.log(log.trim());
}
(function($){
  $(function(){

    $('.menuButton').sideNav();

  });
})(jQuery);
$(document).ready(function(){    
    setDefautValues();    
    var pageFragmentToOpen = "${pageFragmentToOpen}";
  });

function setDefautValues(){
    $('.modal-trigger').leanModal();
    
    $('.chips').each(function(){
    	$("#"+this.id).material_chip();
    });
 
	$("#ingredientsListChips").material_chip({
        placeholder: '+ Ingredients',
        secondaryPlaceholder: '+ Tag',
	});
	$("#dietLabelsListChips").material_chip({
		placeholder: '+ Diets Labels',
		secondaryPlaceholder: '+ Tag',
	});
	$("#healthLabelsListChips").material_chip({
		placeholder: '+ Health Labels',
		secondaryPlaceholder: '+ Tag',
	});
	
    $(".drag-target").trigger('click');
    $('select').material_select();
    
    $('.chip').each(function(){
    	this.remove();
    });
    
    $('.chips').each(function(){
	$(this).on('chip.add', function(e, chip){
	    $("label[for="+this.id+"]").hide();
	  });
	});
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

function addRecipe(idname){
	if($("#recipeName").val().length <=0){
		$('.FormErrorMessage').text("Please provide a recipe Name");
		return;
	}
	if($("#cookingTime").val().length <=0){
		$('.FormErrorMessage').text("Please provide a cookingTime");
		return;
	}
	if($("#calorieAmount").val().length <=0){
		$('.FormErrorMessage').text("Please provide a calorieAmount");
		return;
	}
	$('input[name="ingredientsList"]').val(getChipData("ingredientsListChips"));
	if($('input[name="ingredientsList"]').val().length <= 0){
		$('.FormErrorMessage').text("Ingredient List can not be empty");
		return;
	}	
	$('input[name="dietLabels"]').val(getChipData("dietLabelsListChips"));
	if($('input[name="dietLabels"]').val().length <= 0){
		$('.FormErrorMessage').text("Diet Labeles can not be empty");
		return;
	}
	$('input[name="healthLabels"]').val(getChipData("healthLabelsListChips"));		
	if($('input[name="healthLabels"]').val().length <= 0){
		$('.FormErrorMessage').text("Health Labeles can not be empty");
		return;
	}
	
	
	var dataToPopulate = $("#"+idname).serialize();
	dataToPopulate = dataToPopulate + '&moreInfoUrl='+$('#stepsToCook').val();
	ajaxJsonUrl($("#"+idname).attr('action'),dataToPopulate,$("#"+idname).attr('method'));
}

function getChipData(chipDivName){
	var dataString = "";
	$("#"+chipDivName+" .chip").each(function(){
		dataString = dataString + this.firstChild.textContent + ","; 		
	});
	dataString = dataString.substring(0, dataString.lastIndexOf(","));
	return dataString;
}

function favouriteUnfavouriteAction(formID){
	var dataToPopulate = $("#"+formID).serialize();
	ajaxJsonUrl($("#"+formID).attr('action'),dataToPopulate,$("#"+formID).attr('method'));
}

function shareThisRecipe(formID){
	var dataToPopulate = $("#"+formID).serialize();
	ajaxJsonUrl($("#"+formID).attr('action'),dataToPopulate,$("#"+formID).attr('method'));
}

function reset(){
	$("input").each(function(){
		$(this).attr('disabled',true);
	});
	$("#saveButton").addClass("hide");
	$("#updateButton").removeClass("hide");
}

function topSearchRecipe(a,b){
	if($("input[name='searchQueries']").val().length <= 0){
		return;
	}else{
		shareThisRecipe(a);
	}	
}