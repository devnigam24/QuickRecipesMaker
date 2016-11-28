<%@ include file="includes/springResources.inc"%>
<form class="col s12" id="addRecipeForm" action="addThisRecipe" method="POST">
	<input type="hidden" name="ingredientsList" value=""/>
	<input type="hidden" name="imageUrl" value="http://www.weightwatchers.ca/images/4105/dynamic/foodandrecipes/2013/06/us_img_recipe_default_600x600.jpg"/>
	<input type="hidden" name="moreInfoUrl" value=""/>
	<input type="hidden" name="dietLabels" value=""/>
	<input type="hidden" name="healthLabels" value=""/>
	<input type="hidden" name="createdBy" value="${userName}"/>
	<%@ include file="includes/springResources.inc"%>
	<div class="row">
		<div class="section"><span class="FormErrorMessage"></span></div>
		<div class="row">
			<div class="input-field col s4">
				<input id="recipeName" name="recipeName" type="text" class="validate"> 
				<label for="recipeName">Recipe Name</label>
			</div>
			<div class="input-field col s4">
				<input id="cookingTime" name="cookingTime" type="number" class="validate"> <label
					for="cookingTime">Time (mins)</label>
			</div>
			<div class="input-field col s4">
				<input id="calorieAmount" name="calorieAmount" type="number" class="validate"> <label
					for="calorieAmount">Calorie</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<textarea id="stepsToCook" required class="materialize-textarea"></textarea>
				<label for="textarea1">Steps To Cook</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s4">
				<div id="ingredientsListChips" class="chips chips-placeholder"></div>
				<label for="ingredientsListChips" class="left blue-text text-darken-2 largeText">Ingredients List</label>
			</div>
			<div class="input-field col s4">
				<div id="dietLabelsListChips" class="chips chips-placeholder"></div>
				<label for="dietLabelsListChips" class="left blue-text text-darken-2 largeText">Diet labels</label>
			</div>
			<div class="input-field col s4">
				<div id="healthLabelsListChips" class="chips chips-placeholder"></div>
				<label for="healthLabelsListChips" class="left blue-text text-darken-2 largeText">health labels</label>
			</div>
		</div>
	</div>
	<div class="row">
		<a class="waves-effect waves-light btn" onclick="reset('updateProfileForm')">Cancel</a>
		<a class="waves-effect waves-light btn" id="saveButton" onclick="addRecipe('addRecipeForm')">Submit</a>
	</div>
</form>