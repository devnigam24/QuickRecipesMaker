<ul id="slide-out" class="side-nav">
	<li>
		<div class="userView">
			<img class="background"src="<c:url value="/resources/images/kegs9T.jpg" />" />
			<a href="#!user"><img class="circle" src="<c:url value="/resources/images/userimage.jpg" />" /> </a> 
			<a href="#!name"><span class="white-text name">${userFirstName} ${userLastName}</span></a>
			<a href="#!email"><span class="white-text email">${userEmailID}</span></a>
		</div>
	</li>
	<li><a href="#! "
		onclick="ajaxGeturlForSideNav('editProfile','mainContainer');"><i
			class="material-icons">perm_identity</i>Edit Profile</a></li>
	<li>
		<div class="divider"></div>
	</li>
	<li><a href=""
		onclick="ajaxGeturlForSideNav('addRecipe','mainContainer');"><i
			class="material-icons">note_add</i>Create New Recipe</a></li>
	<li>
		<div class="divider"></div>
	</li>
	<li><a href=""
		onclick="ajaxGeturlForSideNav('recipeSearch','mainContainer');"><i
			class="material-icons">search</i>QuickRecipeFinder</a></li>
	<li>
		<div class="divider"></div>
	</li>
	<li><a href=""
		onclick="ajaxGeturlForSideNav('getMyCreatedRecipes','mainContainer');"><i
			class="material-icons">email</i>My Recipes</a></li>
	<li>
		<div class="divider"></div>
	</li>
	<li><a href=""
		onclick="ajaxGeturlForSideNav('getFollowing','mainContainer');"><i
			class="material-icons">perm_identity</i>Follower</a></li>
	<li>
		<div class="divider"></div>
	</li>
	<li><a href=""
		onclick="ajaxGeturlForSideNav('recipeDetailsFav','mainContainer');">
		<i class="material-icons">note_add</i>Favorites</a></li>
	<li>
		<div class="divider"></div>
	</li>
	<li><a href="logout"><i class="material-icons">settings_power</i>Logout</a>
	</li>
	<li>
		<div class="divider"></div>
	</li>
</ul>