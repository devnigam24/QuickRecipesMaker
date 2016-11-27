<nav class="light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<!-- <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a> -->
		<c:if test="${userFirstName != null}">
			<a href="#" data-activates="slide-out" class="left menuButton">
				<i class="material-icons">menu</i>
			</a> 
		</c:if>
		<a id="logo-container" href="#"	class="brand-logo">QuickRecipeFinder</a>
		<c:if test="${userFirstName == null}">
			<ul class="right hide-on-med-and-down">
				<li><a class="modal-trigger waves-effect waves-light" href="#Register">Register</a></li>
			</ul>
			<ul class="right hide-on-med-and-down">
				<li><a class="modal-trigger waves-effect waves-light" href="#Login">Login</a></li>
			</ul>	
		</c:if>	
		<form>
			<div class="right hide-on-med-and-down input-field">
				<input id="search" type="search" required> <label
					for="search"><i class="material-icons">search</i> </label> <i
					class="material-icons">close</i>
			</div>
		</form>
	</div>
</nav>