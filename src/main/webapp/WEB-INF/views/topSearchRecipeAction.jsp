<%@ include file="includes/springResources.inc"%>
<div class="row">
	<c:if test="${not empty myCustomMessage}">
		<p>${myCustomMessage}</p>
	</c:if>
	<c:if test="${empty myCustomMessage}">
	<c:if test="${empty searchRecipeResultArrayList}">  
		<p>Please Narrow down your search criteria</p>
	</c:if>
	<c:if test="${not empty searchRecipeResultArrayList}"> 
	<c:forEach items="${searchRecipeResultArrayList}" var="oneRecipe">
		<div class="card left col s4">
			<div class="card-image waves-effect waves-block waves-light">
				<img class="activator" src="${oneRecipe.imageUrl}">
			</div>
			<div class="card-content velo">
				<span class="card-title activator grey-text text-darken-4">
					${oneRecipe.recipeName}<i class="material-icons right" style="padding-top: 10px;">more_vert</i>
				</span>
			</div>
			<div class="card-action velo1">
				<form action="favouriteUnfavouriteAction" id="favouriteUnfavouriteForm">
					<%@ include file="includes/recipeHiddenFields.inc"%>
					<input type="hidden" name="recipeTodelete" value="${oneRecipe._id}"/>
					<input type="hidden" name="userName" value="${userName}"/>
					<input type="hidden" name="action" value="signUp">
					<div class="col s4">
						<a href="#" onclick="favouriteUnfavouriteAction('favouriteUnfavouriteForm')">
							<i  class="material-icons">star</i></a>
					</div>
				</form>
				<div class="right col s5">
					<a href="${oneRecipe.moreInfoUrl}" target="_blank"><i class="material-icons">launch</i></a>
				</div>			
			</div>
			<div class="card-reveal">
				<span class="card-title grey-text text-darken-4">
					${oneRecipe.recipeName}<i class="material-icons right">close</i>
				</span>
				<p>Calories : ${oneRecipe.calorieAmount}</p>
				<p>Time : ${oneRecipe.cookingTime} Mins</p>
				<p> Ingredients :
					<c:forEach items="${oneRecipe.ingredientsList}" var="ingredient">
						<c:out value="${ingredient}" />
					</c:forEach>
				</p>
				<p> Diet Labels :
					<c:forEach items="${oneRecipe.dietLabels}" var="diet">
						<c:out value="${diet}" />
					</c:forEach>
				</p>
				<p> Health Labels :
					<c:forEach items="${oneRecipe.healthLabels}" var="health">
						<c:out value="${health}" />
					</c:forEach>
				</p>
			</div>
		</div>
	</c:forEach>
	</c:if>
	</c:if>
	</div>
