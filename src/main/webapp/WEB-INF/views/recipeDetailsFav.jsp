<%@ include file="includes/springResources.inc"%>
<div class="row">
	<c:if test="${empty createdRecipesList}">  
		<p>You have no Recipes associated to your account at this time!! Please use 'create New Recipe' functionality to create some</p>
	</c:if>
	<c:if test="${not empty createdRecipesList}"> 
	<c:forEach items="${createdRecipesList}" var="oneRecipe">
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
				<form action="favouriteUnfavouriteAction" id="favForm${oneRecipe._id}">
					<%@ include file="includes/recipeHiddenFields.inc"%>
					<input type="hidden" name="recipeTodelete" value="${oneRecipe._id}"/>
					<input type="hidden" name="userName" value="${userName}"/>
					<input type="hidden" name="action" value="unfavourite">
					<div class="col s4">
						<a href="#" onclick="favouriteUnfavouriteAction('favForm${oneRecipe._id}')">
							<i  class="material-icons">star</i></a>
					</div>
				</form>	
				<form action="shareThisRecipe" id="shareForm${oneRecipe._id}">
					<%@ include file="includes/recipeHiddenFields.inc"%>
					<div class="col s3">
						<a class="modal-trigger waves-effect waves-light" href="#share${oneRecipe._id}"><i class="material-icons">email</i></a>
					</div>
					<div id="share${oneRecipe._id}" class="modal modal-fixed-footer">
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
							<button class="btn-flat" onclick="shareThisRecipe('shareForm${oneRecipe._id}')"
								type="submit">Share</button>
						</div>
					</div>
				</form>
				<div class="col s5">
					<a href="#moreInfo${oneRecipe._id}" class="modal-trigger waves-effect waves-light">
						<i class="material-icons">launch</i></a>
					<div id="moreInfo${oneRecipe._id}" class="modal modal-fixed-footer">
						<div class="modal-content">
							<h4>Steps To create</h4>
							<div class="row">
								<div class="input-field col s12">
									<p>${oneRecipe.moreInfoUrl}</p>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button class="modal-action modal-close btn-flat">Cancel</button>
						</div>
					</div>
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
				</p><br>
				<p>
					<form action="deleteThisRecipe" id="deleteRecipeForm" method="POST">
						<input type="hidden" name="recipeTodelete" value="${oneRecipe._id}"/>
						<input type="hidden" name="userName" value="${userName}"/>
						<a href="#" onclick="shareThisRecipe('deleteRecipeForm')">
						<i  class="material-icons">delete</i></a>
					</form>					
				</p>
			</div>
		</div>
	</c:forEach>
	</c:if>
</div>