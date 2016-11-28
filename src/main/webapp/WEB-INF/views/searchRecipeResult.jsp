<%@ include file="includes/springResources.inc"%>
<div class="row">
	<c:forEach items="${searchRecipeResultArrayList}" var="oneRecipe">
		<div class="card col s4">
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
					<input type="hidden" name="action" value="searchResults">
					<div class="col s4">
						<a onclick="favouriteUnfavouriteAction('favouriteUnfavouriteForm')">Favourite</a>
					</div>
				</form>	
				<form action="shareThisRecipe" id="shareForm">
					<%@ include file="includes/recipeHiddenFields.inc"%>
					<div class="col s3">
						<a class="modal-trigger waves-effect waves-light" href="#share">Share</a>
					</div>
					<div id="share" class="modal modal-fixed-footer">
						<div class="modal-content">
							<h4>Share</h4>
							<div class="row">
								<div class="input-field col s12">
									<input id="emailId" name="shareEmailId" type="email"
										class="active validate" required and aria-required="true">
									<label for="emailId">Email Id</label>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button class="modal-action modal-close btn-flat">Cancel</button>
							<button class="btn-flat" onclick="shareThisRecipe('shareForm')"
								type="submit">Share</button>
						</div>
					</div>
				</form>
				<div class="col s5">
					<a href="//${oneRecipe.moreInfoUrl}" target="_blank">more Info</a>
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
</div>