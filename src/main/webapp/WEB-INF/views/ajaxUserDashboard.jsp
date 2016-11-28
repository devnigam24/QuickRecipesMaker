<%@ include file="includes/springResources.inc"%>
<div class="section"><span class="myMessages">Good Evening ${userFirstName}</span></div>
<div class="section"><span class="myMessages1">Are you ready for your new Recipe?</span></div>
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