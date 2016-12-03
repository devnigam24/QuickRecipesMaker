
<form class="col s12" method="POST" action="loginThisUser" id="loginForm">
	<div id="Login" class="modal modal-fixed-footer">
		<div class="modal-content">
			<h4>Login</h4>
			<%@ include file="errorsAndMessages.inc"%>
			<div class="row">
				<div class="input-field col s12">
					<input id="UserName" name="userName" type="text" class="active validate" required
						and aria-required="true"> <label for="UserName">Username</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input id="Password" name="password" type="password" class=" active validate"
						required and aria-required="true"> <label for="password">Password</label>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button class="modal-action modal-close btn-flat">Cancel</button>
			<button class="btn-flat" type="submit">Login</button>
		</div>
	</div>
</form>