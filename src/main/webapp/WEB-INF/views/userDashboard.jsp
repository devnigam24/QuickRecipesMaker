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
	<%@ include file="includes/leftNavigation.inc"%>
	<%@ include file="includes/errorsAndMessages.inc"%>
	<main class="container center paddinTop3em" >
		<div class="section" id="mainContainer">
		</div>
			<!--   Icon Section   -->
			
			aaa${userName}
		<div class="row">
			<div class="col s12 m4">
				<div class="icon-block">
					<h2 class="center light-blue-text">
						<i class="material-icons">library_books</i>
					</h2>
					<h5 class="center">Recipes : ${createRecipeCount}</h5>
					<p class="light"></p>
				</div>
			</div>
			<div class="col s12 m4">
				<div class="icon-block">
					<h2 class="center light-blue-text">
						<i class="material-icons">group</i>
					</h2>
					<h5 class="center">Followers : ${followersCount}</h5>
					<p class="light"></p>
				</div>
			</div>
			<div class="col s12 m4">
				<div class="icon-block">
					<h2 class="center light-blue-text">
						<i class="material-icons">group</i>
					</h2>
					<h5 class="center">Following : ${followingCount}</h5>
					<p class="light"></p>
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