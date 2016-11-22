<%@ include file="includes/springResources.inc"%>
<form class="col s12" method="post" onsubmit="updateUsrDetails()">
	<div class="row">
		<form class="col s12">
			<div class="row">
				<div class="attributes col s12" style="font-size: 20px">
					<div class="prd_label col s4">
						<label>First Name:</label>
					</div>
					<div class="prd_val col s8">
						<div id="fNameTxt" class="col s6"></div>
						<div id="fNamDiv" class="hide input-field col s6">
							<input id="fName" type="text" class="inputVal">
						</div>
						<div class="edit col s2">
							<a id="editFname">edit</a>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="attributes col s12">
					<div class="prd_label col s4">
						<label>Last Name:</label>
					</div>
					<div class="prd_val col s8">
						<div id="lNameTxt" class="col s6"></div>
						<div id="LNamDiv" class="hide input-field col s6">
							<input id="lName" type="text" class="inputVal">
						</div>
						<div class="edit col s2">
							<a id="editLname">edit</a>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="attributes col s12">
					<div class="prd_label col s4">
						<label>User Name:</label>
					</div>
					<div class="prd_val col s8">
						<div id="uNameTxt" class="col s6"></div>
						<div class="col s2"></div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="attributes col s12">
					<div class="prd_label col s4">
						<label>Email:</label>
					</div>
					<div class="prd_val col s8">
						<div id="eMailTxt" class="col s6"></div>
						<div class="col s2"></div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="attributes col s12">
					<div class="prd_label col s4">
						<label>About me:</label>
					</div>
					<div class="prd_val col s8">
						<div id="abtMeTxt" class="col s6"></div>
						<div id="abtMeDiv" class="hide input-field col s6">
							<textarea id="aboutMe" class="materialize-textarea inputVal"></textarea>
						</div>
						<div class="edit col s2">
							<a id="editAbtMe">edit</a>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="attributes col s12">
					<div class="prd_label col s4">
						<label>Favorite Recipe:</label>
					</div>
					<div class="prd_val col s8">
						<div id="favBokTxt" class="col s6"></div>
						<div id="favBokDiv" class="hide input-field col s6">
							<textarea id="favBok" class="materialize-textarea inputVal"></textarea>
						</div>
						<div class="edit col s2">
							<a id="editFavBok">edit</a>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="attributes col s12">
					<div class="prd_label col s4">
						<label>Created :</label>
					</div>
					<div class="prd_val col s8">
						<div id="showuser_bshelf" class="col s6"></div>
						<div class="col s2"></div>
					</div>
				</div>
			</div>

		</form>
	</div>




	<div class="row">
		<button class="waves-effect waves-light btn">Cancel</button>
		<button class="waves-effect waves-light btn" type="submit"
			name="action">Update Profile</button>
	</div>
</form>