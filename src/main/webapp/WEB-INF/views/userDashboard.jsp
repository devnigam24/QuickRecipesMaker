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
<link href="<c:url value="/resources/css/materialize.css" />" type="text/css" rel="stylesheet" media="screen,projection">
<link href="<c:url value="/resources/css/style.css" />" type="text/css" rel="stylesheet" media="screen,projection">
</head>
<body>
	<nav class="light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<!-- <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a> -->
		<a href="#" data-activates="slide-out" class="left menuButton"><i
			class="material-icons">menu</i></a> <a id="logo-container" href="#"
			class="brand-logo">QuickRecipeFinder</a>
		<ul class="right hide-on-med-and-down">
			<li><a class="modal-trigger waves-effect waves-light "
				href="#Register">Register</a></li>
		</ul>
		<ul class="right hide-on-med-and-down">
			<li><a class="modal-trigger waves-effect waves-light "
				href="#Login">Login</a></li>
		</ul>
		<%@ include file="includes/leftNavigation.jsp"%>
		<form>
			<div class="right hide-on-med-and-down input-field">
				<input id="search" type="search" required> <label
					for="search"><i class="material-icons">search</i> </label> <i
					class="material-icons">close</i>
			</div>
		</form>
		<!-- 
               <ul id="nav-mobile" class="side-nav">
                   <li><a href="#">Mobile Link</a></li>
               </ul> -->
	</div>
	</nav>

	<!-- Modal Login -->
	<form class="col s12" method="post" id="SignUpLoginController"
		onsubmit="login()">
		<div id="Login" class="modal modal-fixed-footer">
			<div class="modal-content">
				<h4>Login</h4>
				<div class="row">
					<div class="input-field col s12">
						<input id="Username" type="text" class="active validate" required
							and aria-required="true"> <label for="username">Username</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="Password" type="password" class=" active validate"
							required and aria-required="true"> <label for="password">Password</label>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="modal-action modal-close btn-flat">Cancel</button>
				<button class="btn-flat" type="submit" name="action">Login</button>
			</div>
		</div>
	</form>
	<!-- Modal Register -->
	<form class="col s12" method="post" id="SignUpLoginController"
		onsubmit="signup()">
		<div id="Register" class="modal modal-fixed-footer">
			<div class="modal-content">
				<h4>New User ?</h4>
				<div class="row">
					<div class="row">
						<div class="input-field col s6">
							<input id="first_name" type="text" class="active validate"
								required and aria-required="true"> <label
								for="first_name" data-error="wrong" data-success="">First
								Name</label>
						</div>
						<div class="input-field col s6">
							<input id="last_name" type="text" class="active validate"
								required and aria-required="true"> <label
								for="last_name" data-error="wrong" data-success="">Last
								Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="username" type="text" class="active validate" required
								and aria-required="true"> <label for="username"
								data-error="wrong" data-success="">Username</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input id="password" type="password" class="active validate"
								required and aria-required="true"> <label for="password"
								data-error="wrong" data-success="">Password</label>
						</div>
						<div class="input-field col s6">
							<input id="confirmpassword" type="password"
								class="active validate" required and aria-required="true">
							<label for="confirmpassword" data-error="wrong" data-success="">
								Confirm Password</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="email" type="email" class="active validate" required
								and aria-required="true"> <label for="email"
								data-error="Invalid Email ,Please Enter correct Email"
								data-success="">Email</label>
						</div>
					</div>

				</div>
			</div>
			<div class="modal-footer">
				<button class="modal-action modal-close btn-flat">Cancel</button>
				<button class="btn-flat" type="submit" name="action">Register</button>
			</div>
		</div>
	</form>



	<main>
	<div class="container" id="mainContainer">
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
	</div>
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