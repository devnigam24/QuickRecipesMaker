<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Recipe Maker</title>
<%@ include file="includes/resources.inc"%>
<%@ include file="includes/loginForm.inc"%>
<%@ include file="includes/signUpForm.inc"%>
</head>
<body>
	<%@ include file="includes/topNavBar.inc"%>
	<main class="container center paddinTop3em" id="mainContainer">
		<div class="section">
			<!--   Icon Section   -->
			<div class="row">
				<%@ include file="includes/errorsAndMessages.inc"%>
				<div class="card left col s5">
			<div class="card-image waves-effect waves-block waves-light">
				<img class="activator" src="${searchRecipeResultArrayList.imageUrl}">
			</div>
			<div class="card-content velo">
				<span class="card-title activator grey-text text-darken-4">
					${searchRecipeResultArrayList.recipeName}<i class="material-icons right" style="padding-top: 10px;">more_vert</i>
				</span>
			</div>
			<div class="card-action velo1">
				<form action="favouriteUnfavouriteAction" id="favouriteUnfavouriteForm">
					<%@ include file="includes/recipeHiddenFields.inc"%>
					<input type="hidden" name="recipeTodelete" value="${searchRecipeResultArrayList._id}"/>
					<input type="hidden" name="userName" value="${userName}"/>
					<input type="hidden" name="action" value="signUp">
					<div class="col s4">
						<a href="#" onclick="favouriteUnfavouriteAction('favouriteUnfavouriteForm')">
							<i  class="material-icons">star</i></a>
					</div>
				</form>
				<div class="col right s5">
					<a href="${searchRecipeResultArrayList.moreInfoUrl}" target="_blank"><i class="material-icons">launch</i></a>
				</div>			
			</div>
			<div class="card-reveal">
				<span class="card-title grey-text text-darken-4">
					${searchRecipeResultArrayList.recipeName}<i class="material-icons right">close</i>
				</span>
				<p>Calories : ${searchRecipeResultArrayList.calorieAmount}</p>
				<p>Time : ${searchRecipeResultArrayList.cookingTime} Mins</p>
				<p> Ingredients :
					<c:forEach items="${searchRecipeResultArrayList.ingredientsList}" var="ingredient">
						<c:out value="${ingredient}" />
					</c:forEach>
				</p>
				<p> Diet Labels :
					<c:forEach items="${searchRecipeResultArrayList.dietLabels}" var="diet">
						<c:out value="${diet}" />
					</c:forEach>
				</p>
				<p> Health Labels :
					<c:forEach items="${searchRecipeResultArrayList.healthLabels}" var="health">
						<c:out value="${health}" />
					</c:forEach>
				</p>
			</div>
		</div>
			</div>
		</div>
		<br> <br>
		<div class="section"></div>
	</main>
	<footer class="page-footer orange">
		<div class="footer-copyright">
			<div class="container">
				Made by <a class="orange-text text-lighten-3" href="#">CPSC Fall 2016 Group 2</a>
			</div>
		</div>
	</footer>
</body>
</html>