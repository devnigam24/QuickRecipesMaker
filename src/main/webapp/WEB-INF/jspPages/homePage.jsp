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
<style>
body {
    background-image: url("<c:url value="/resources/images/homepage.jpg"/>");
    background-size: 100%;
    background-position-x: center;
    background-position-y: center;
}
</style>
<body>
	<%@ include file="includes/topNavBar.inc"%>
	<main class="container center paddinTop3em" id="mainContainer">
		<div class="section">
			<!--   Icon Section   -->
			<div class="row">
				<%@ include file="includes/errorsAndMessages.inc"%>
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