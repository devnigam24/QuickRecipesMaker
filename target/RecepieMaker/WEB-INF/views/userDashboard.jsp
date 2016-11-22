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
	<nav class="light-blue lighten-1" role="navigation">
		<div class="nav-wrapper container">
			<!-- <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a> -->
			<a href="#" data-activates="slide-out" class="left menuButton">
				<i class="material-icons">menu</i>
			</a> 
			<a id="logo-container" href="#"	class="brand-logo">QuickRecipeFinder</a>
			<ul class="right hide-on-med-and-down">
				<li><a class="modal-trigger waves-effect waves-light" href="#Register">Register</a></li>
			</ul>
			<ul class="right hide-on-med-and-down">
				<li><a class="modal-trigger waves-effect waves-light" href="#Login">Login</a></li>
			</ul>
			<%@ include file="includes/leftNavigation.inc"%>			
			<form>
				<div class="right hide-on-med-and-down input-field">
					<input id="search" type="search" required> <label
						for="search"><i class="material-icons">search</i> </label> <i
						class="material-icons">close</i>
				</div>
			</form>
		</div>
	</nav>
	<main class="container center paddinTop3em" id="mainContainer">
		<div class="section">
			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">library_books</i>
						</h2>
						<h5 class="center">Recipes : 10</h5>
						<p class="light"></p>
					</div>
				</div>
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">group</i>
						</h2>
						<h5 class="center">Followers : 100</h5>
						<p class="light"></p>
					</div>
				</div>
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">group</i>
						</h2>
						<h5 class="center">Following : 200</h5>
						<p class="light"></p>
					</div>
				</div>
			</div>
		</div>
		<br> <br>
		<div class="section"></div>
	</main>
	<footer class="page-footer orange">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">QuickRecipeMaker</h5>
				<p class="grey-text text-lighten-4">Recipe Maker</p>
			</div>
			<div class="col l3 s12">
				<h5 class="white-text">Recipe</h5>
				<ul>
					<li><a class="white-text" href="#!">Recipe</a></li>

				</ul>
			</div>
			<div class="col l3 s12">
				<h5 class="white-text">Recipe</h5>
				<ul>
					<li><a class="white-text" href="#!">Recipe</a></li>

				</ul>
			</div>
		</div>
	</div>
	<div class="footer-copyright">
		<div class="container">
			Made by <a class="orange-text text-lighten-3" href="#">Materialize</a>
		</div>
	</div>
	</footer>
</body>
</html>