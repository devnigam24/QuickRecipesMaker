<form class="col s12" method="post" onsubmit="updateUsrDetails()">

	<div class="row">
		<form class="col s12">
			<div class="row">
				<div class="input-field col s6">
					<input id="email" type="email" class="active validate" required and
						aria-required="true"> <label for="email"
						data-error="Invalid Email ,Please Enter correct Email"
						data-success="">Recipeient Email</label>
				</div>
			</div>
		</form>
	</div>


	<div class="row">
		<button class="waves-effect waves-light btn">Cancel</button>
		<button class="waves-effect waves-light btn" type="submit"
			name="action">Share Recipe</button>
	</div>
</form>