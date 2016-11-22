<form class="col s12" method="post" id="SignUpLoginController" onsubmit="signup()">
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