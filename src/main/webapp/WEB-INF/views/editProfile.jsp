<%@ include file="includes/springResources.inc"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/materialize/materialize.js" />"></script>
<form class="col s12 center" method="POST" action="updateProfile" id="updateProfileForm">
	<div class="row center">
		<div class="row">
			<div class="input-field col s6">
				<input disabled id="fname" type="text" name="userFirstName" class="validate darken-1 xLargerFont"
					value="${userFirstName}"> <label for="fname"
					class="left blue-text text-darken-2 largeText">First Name :</label>
			</div>
			<div class="input-field col s6">
				<input disabled id="lname" type="text" name="userLastName" class="validate darken-1 xLargerFont"
					value="${userLastName}"> <label for="lname"
					class="left blue-text text-darken-2 largeText">Last Name :</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input disabled id="username" type="text" name="userName" class="validate darken-1 xLargerFont"
					value="${userName}"> <label for="username"
					class="left blue-text text-darken-2 largeText">User Name :</label>
			</div>
			<div class="input-field col s6">
				<input disabled id="emailid" type="text" name="userEmailID" class="validate darken-1 xLargerFont"
					value="${userEmailID}"> <label for="emailid"
					class="left blue-text text-darken-2 largeText">Email :</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input id="password" type="password" name="password" class="validate darken-1 xLargerFont"
					value="${password}"> <label for="password"
					class="left blue-text text-darken-2 largeText">Password :</label>
			</div>
			<div class="input-field col s6">
				<input disabled id="aboutme" name="aboutMe" type="text" class="validate darken-1 xLargerFont"
					value="${aboutMe}"> <label for="aboutme"
					class="left blue-text text-darken-2 largeText">About Me :</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input disabled id="recipecreated" type="text" class="validate darken-1 xLargerFont"
					value="${createRecipeCount}"> <label
					for="recipecreated" class="left blue-text text-darken-2 largeText">Recipe Created:</label>
			</div>
			<div class="input-field col s6">
				<input disabled id="favrecipelist" type="text" class="validate darken-1 xLargerFont"
					value="${favouriteRecipeCount}"> <label
					for="favrecipelist" class="left blue-text text-darken-2 largeText">Favorite :</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input disabled id="favrecipelist" type="text" class="validate darken-1 xLargerFont"
					value="${followingCount}"> <label
					for="favrecipelist" class="left blue-text text-darken-2 largeText">Following :</label>
			</div>
			<div class="input-field col s6">
				<input disabled id="favrecipelist" type="text" class="validate darken-1 xLargerFont"
					value="${sharedRecipeCount}"> <label
					for="favrecipelist" class="left blue-text text-darken-2 largeText">Shares :</label>
			</div>
		</div>
	</div>
	<div class="row">
		<a class="waves-effect waves-light btn" onclick="reset('updateProfileForm')">Cancel</a>
		<a class="waves-effect waves-light btn" id="updateButton" onclick="updateProfile()">Update Profile</a>
		<a class="waves-effect waves-light btn hide" id="saveButton" onclick="saveProfile('updateProfileForm')">Save</a>
	</div>
</form>
<script type="text/javascript">

$(document).ready(function() {
	$("#leftFirstNameLastName").text($("#fname").val().trim() + " " + $("#lname").val().trim());
	$("#leftEmail").text($("#emailid").val().trim());
});
	
</script>