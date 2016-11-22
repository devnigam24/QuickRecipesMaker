<form class="col s12" method="post" id="SignUpLoginController" onsubmit="login()">
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