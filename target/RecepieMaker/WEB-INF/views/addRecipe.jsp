<%@ include file="includes/springResources.inc"%>
<form class="col s12" method="post" onsubmit="">
	<div class="row">
		<form class="col s12">
			<div class="row">
				<div class="input-field col s4">
					<input id="recipename" type="text" class="validate"> <label
						for="first_name">Recipe Name</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s4">
					<input id="time" type="number" class="validate"> <label
						for="last_name">Time</label>
				</div>
			</div>

			<div class="row">
				<div class="input-field col s4">
					<input id="calorie" type="number" class="validate"> <label
						for="password">Calorie</label>
				</div>
			</div>

			<div class="row">
				<div class="col s6">
					<div class="chips chips-placeholder" col s4></div>
				</div>
			</div>
		</form>
	</div>

	<div class="row">
		<button class="waves-effect waves-light btn">Cancel</button>
		<button class="waves-effect waves-light btn" type="submit"
			name="action">Add New Recipe</button>
	</div>
</form>