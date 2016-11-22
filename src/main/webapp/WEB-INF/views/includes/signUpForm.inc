<form class="col s12" method="post" id="SignUpLoginController" onsubmit="signup()">
	<div id="Register" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>New User ?</h4>
			<div class="row">
				<div class="row">
					<div class="input-field col s6">
						<input id="firstName" name="firstName" type="text" class="active validate"
							required and aria-required="true"> <label
							for="firstName" data-error="wrong" data-success="">First
							Name</label>
					</div>
					<div class="input-field col s6">
						<input id="lastName" name="lastName" type="text" class="active validate"
							required and aria-required="true"> <label
							for="lastName" data-error="wrong" data-success="">Last
							Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="userName" name="userName" type="text" class="active validate" required
							and aria-required="true"> <label for="userName"
							data-error="wrong" data-success="">Username</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input id="password" name="password" type="password" class="active validate"
							required and aria-required="true"> <label for="password"
							data-error="wrong" data-success="">Password</label>
					</div>
					<div class="input-field col s6">
						<input id="confirmPassword" name="confirmPassword" type="password"
							class="active validate" required and aria-required="true">
						<label for="confirmpassword" data-error="wrong" data-success="">
							Confirm Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="email" name="email" type="email" class="active validate" required
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