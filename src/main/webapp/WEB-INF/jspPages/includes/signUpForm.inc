<form class="col s12" method="POST" action="signUpThisUser" id="signUpForm">
	<div id="Register" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>New User ?</h4>
			<%@ include file="errorsAndMessages.inc"%>
			<div class="row">
				<div class="row">
					<div class="input-field col s6">
						<input id="userFirstName" name="userFirstName" type="text" class="active validate"
							required and aria-required="true"> <label
							for="userFirstName" data-error="wrong" data-success="">First
							Name</label>
					</div>
					<div class="input-field col s6">
						<input id="userLastName" name="userLastName" type="text" class="active validate"
							required and aria-required="true"> <label
							for="userLastName" data-error="wrong" data-success="">Last
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
						<input id="userEmailID" name="userEmailID" type="email" class="active validate" required
							and aria-required="true"> <label for="userEmailID"
							data-error="Invalid Email ,Please Enter correct Email"
							data-success="">Email</label>
					</div>
				</div>

			</div>
		</div>
		<div class="modal-footer">
			<button class="modal-action modal-close btn-flat">Cancel</button>
			<button class="btn-flat" type="submit">Register</button>
		</div>
	</div>
</form>