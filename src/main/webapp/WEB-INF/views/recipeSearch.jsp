<%@ include file="includes/springResources.inc"%>
<script type="text/javascript" src="<c:url value="/resources/js/materialize/materialize.js" />" ></script>
<form class="col s12 center" method="POST" action="searchRecipe" id="searchRecipeForm">
	<input type="hidden" name="userName" value="${userInSession.getUserName()}" />
	<div class="section no-pad-bot" id="index-banner">
		<div class="row">
			<div class="input-field col s6">
				<div id="ingredientsListChips" class="chips chips-placeholder"></div>
				<label for="fname" class="left blue-text text-darken-2 largeText">Ingredients</label>
			</div>
		</div>
        <!-- Dropdown Trigger Time -->
		<div class="row">
			<div class="input-field col s12">
               <select class="left blue-text text-darken-2 largeText" name="cookingTime">
                  <option value="" disabled selected>Select Time</option>
                  <option value="1">0-5 Mins</option>
                  <option value="2">5-10 Mins</option>
                  <option value="3">10-15 Mins</option>
                  <option value="4">15-30 Mins</option>
                  <option value="5">30-45 Mins</option>
                  <option value="6">45-60 Mins</option>
                  <option value="7">60-75 Mins</option>
                  <option value="8">More than 90 Mins</option>
               </select>               
            </div>		
		</div>
        
        <!-- Dropdown Trigger Calorie -->
        <div class="row">
			<div class="input-field col s12">
               <select class="left blue-text text-darken-2 largeText" name="calorieAmount">
                  <option value="" disabled selected>Select Calorie</option>
                  <option value="gte 0,lte 250">0-250 Calories</option>
                  <option value="gte 250,lte 500">250-500 Calories</option>
                  <option value="gte 500,lte 750">500-750 Calories</option>
                  <option value="gte 750,lte 1000">750-1000 Calories</option>
                  <option value="gte 1000,lte 1500">1000-1500 Calories</option>
                  <option value="gte 2000,lte 2500">2000-2500 Calories</option>
                  <option value="gte 2500">More than 2500 Calories</option>
               </select>               
            </div>		
		</div>
	</div>
	<div class="row">
		<a class="waves-effect waves-light btn" onclick="reset('updateProfileForm')">Cancel</a>
		<a class="waves-effect waves-light btn" id="saveButton" onclick="searchRecipe('searchRecipeForm')">Submit</a>
	</div>
</form>