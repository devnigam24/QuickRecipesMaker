<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Recipe Maker</title>
<%@ include file="includes/resources.inc" %>
</head>
<body>
	<nav class="light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<!-- <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a> -->
		<a href="#" data-activates="slide-out" class="left button-collapse"><i
			class="material-icons">menu</i></a> <a id="logo-container" href="#"
			class="brand-logo">Recipe Maker</a>
		<ul class="right hide-on-med-and-down">
			<li><a class="modal-trigger waves-effect waves-light "
				href="#Register">Register</a></li>
		</ul>
		<ul class="right hide-on-med-and-down">
			<li><a class="modal-trigger waves-effect waves-light "
				href="#Login">Login</a></li>
		</ul>
		<ul id="slide-out" class="side-nav">
			<li>
				<div class="userView">
					<img class="background" src="includes/images/kegs9T.jpg"> <a
						href="#!user"><img class="circle" src="includes/images/kegs9T.jpg">
					</a> <a href="#!name"><span class="white-text name">John Doe</span></a>
					<a href="#!email"><span class="white-text email">jdandturk@gmail.com</span></a>
				</div>
			</li>
			<li><a href="#!"><i class="material-icons">perm_identity</i>Edit
					Profile</a></li>
			<li>
				<div class="divider"></div>
			</li>
			<li><a href="#!"><i class="material-icons">mode_edit</i>Update
					Ingredients</a></li>
			<li>
				<div class="divider"></div>
			</li>
			<li><a href="#!"><i class="material-icons">note_add</i>Create
					New Recipe</a></li>
			<li>
				<div class="divider"></div>
			</li>
			<li><a href="#!"><i class="material-icons">search</i>QuickRecipeFinder</a>
			</li>
			<li>
				<div class="divider"></div>
			</li>
			<li><a href="#!"><i class="material-icons">email</i>Share
					New Recipe</a></li>
			<li>
				<div class="divider"></div>
			</li>
			<li><a href="#!"><i class="material-icons">perm_identity</i>Follower</a>
			</li>
			<li>
				<div class="divider"></div>
			</li>
			<li><a href="#!"><i class="material-icons">note_add</i>Favorites</a>
			</li>
			<li>
				<div class="divider"></div>
			</li>
			<li><a href="#!"><i class="material-icons">settings_power</i>Logout</a>
			</li>
			<li>
				<div class="divider"></div>
			</li>
		</ul>
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
	<div id="Login" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>Login</h4>
			<div class="row">
				<div class="input-field col s12">
					<input id="username" type="text" class="validate"> <label
						for="username">Username</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="password" type="password" class="validate"> <label
						for="password">Password</label>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat ">Cancle</a>
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat ">Login</a>
		</div>
	</div>
	<!-- Modal Register -->
	<div id="Register" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>New User ?</h4>
			<div class="row">
				<form class="col s12">
					<div class="row">
						<div class="input-field col s6">
							<input id="first_name" type="text" class="validate"> <label
								for="first_name">First Name</label>
						</div>
						<div class="input-field col s6">
							<input id="last_name" type="text" class="validate"> <label
								for="last_name">Last Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="username" type="text" class="validate"> <label
								for="username">Username</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input id="password" type="password" class="validate"> <label
								for="password">Password</label>
						</div>
						<div class="input-field col s6">
							<input id="confirmpassword" type="password" class="validate">
							<label for="confirmpassword"> Confirm Password</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="email" type="email" class="validate"> <label
								for="email">Email</label>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat ">Cancle</a>
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat ">Register</a>
		</div>
	</div>
	<div class="section no-pad-bot" id="index-banner">


		<div class="row">

			<div class="col s6">
				<div class="chips chips-placeholder" col s4></div>
			</div>

		</div>



		<div class="row">
			<!-- Dropdown Trigger Time -->
			<a class='dropdown-button btn blue' href='#'
				data-activates='dropdowntimer'>Select Time Range</a>
			<!-- Dropdown Structure -->
			<ul id='dropdowntimer' class='dropdown-content'>
				<li><a href="#!">0-5 Mins</a></li>
				<li class="divider"></li>
				<li><a href="#!">5-10 Mins</a></li>
				<li class="divider"></li>
				<li><a href="#!">10-15 Mins</a></li>
				<li class="divider"></li>
				<li><a href="#!">15-30 Mins</a></li>
				<li class="divider"></li>
				<li><a href="#!">30-45 Mins</a></li>
				<li class="divider"></li>
				<li><a href="#!">45-60 Mins</a></li>
				<li class="divider"></li>
				<li><a href="#!">60-75 Mins</a></li>
				<li class="divider"></li>
				<li><a href="#!">75-90 Mins</a></li>
				<li class="divider"></li>
				<li><a href="#!">More than 90 Mins</a></li>
			</ul>
		</div>
		<!-- Dropdown Trigger Calorie -->
		<div class="row">
			<a class='dropdown-button btn  blue' href='#'
				data-activates='dropdowncalorie'>Select Calorie Range</a>
			<!-- Dropdown Structure -->
			<ul id='dropdowncalorie' class='dropdown-content'>
				<li><a href="#!">0-50 Calories</a></li>
				<li class="divider"></li>
				<li><a href="#!">50-100 Calories</a></li>
				<li class="divider"></li>
				<li><a href="#!">100-150 Calories</a></li>
				<li class="divider"></li>
				<li><a href="#!">150-200 Calories</a></li>
				<li class="divider"></li>
				<li><a href="#!">200-250 Calories</a></li>
				<li class="divider"></li>
				<li><a href="#!">250-300 Calories</a></li>
				<li class="divider"></li>
				<li><a href="#!">300-350 Calories</a></li>
				<li class="divider"></li>
				<li><a href="#!">350-400 Calories</a></li>
				<li class="divider"></li>
				<li><a href="#!">More than 400 Calories</a></li>
			</ul>
		</div>
	</div>



	<div class="row">
		<div class="col s1 m3">
			<div class="card">
				<div class="card-image">
					<img src="includes/images/Recipe.jpg"> <span class="card-title">Meat
						Recipe</span>
				</div>
				<div class="card-content">
					<h6>
						Rating : <i class="material-icons">stars</i><i
							class="material-icons">stars</i><i class="material-icons">stars</i><i
							class="material-icons">stars</i><i class="material-icons">stars</i>
					</h6>
					<h6>Calories : 300</h6>
					<h6>Time : 5 Mins</h6>
					<h6>Ingredients : Chicken, Salt, Tomato, Onions</h6>
				</div>

				<div class="card-action">

					<div class="row">

						<div class="col s8">
							<a href="#">Favourites</a>
						</div>
						<div class="col s4">
							<a href="#">Share</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="container">
		<div class="section">
			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">flash_on</i>
						</h2>
						<h5 class="center">Speeds up development</h5>
						<p class="light">We did most of the heavy lifting for you to
							provide a default stylings that incorporate our custom
							components. Additionally, we refined animations and transitions
							to provide a smoother experience for developers.</p>
					</div>
				</div>
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">group</i>
						</h2>
						<h5 class="center">User Experience Focused</h5>
						<p class="light">By utilizing elements and principles of
							Material Design, we were able to create a framework that
							incorporates components and animations that provide more feedback
							to users. Additionally, a single underlying responsive system
							across all platforms allow for a more unified user experience.</p>
					</div>
				</div>
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">settings</i>
						</h2>
						<h5 class="center">Easy to work with</h5>
						<p class="light">We have provided detailed documentation as
							well as specific code examples to help new users get started. We
							are also always open to feedback and can answer any questions a
							user may have about Materialize.</p>
					</div>
				</div>
			</div>
		</div>
		<br> <br>
		<div class="section"></div>
	</div>
	<footer class="page-footer orange">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">Company Bio</h5>
				<p class="grey-text text-lighten-4">We are a team of college
					students working on this project like it's our full time job. Any
					amount would help support and continue development on this project
					and is greatly appreciated.</p>
			</div>
			<div class="col l3 s12">
				<h5 class="white-text">Settings</h5>
				<ul>
					<li><a class="white-text" href="#!">Link 1</a></li>
					<li><a class="white-text" href="#!">Link 2</a></li>
					<li><a class="white-text" href="#!">Link 3</a></li>
					<li><a class="white-text" href="#!">Link 4</a></li>
				</ul>
			</div>
			<div class="col l3 s12">
				<h5 class="white-text">Connect</h5>
				<ul>
					<li><a class="white-text" href="#!">Link 1</a></li>
					<li><a class="white-text" href="#!">Link 2</a></li>
					<li><a class="white-text" href="#!">Link 3</a></li>
					<li><a class="white-text" href="#!">Link 4</a></li>
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