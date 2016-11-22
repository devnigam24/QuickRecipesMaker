<%@ include file="includes/springResources.inc"%>
<script type="text/javascript" src="<c:url value="/resources/js/materialize/materialize.js" />" ></script>
<form class="col s12" method="post" id="SignUpLoginController"
	onsubmit="signup()">
	<div class="section no-pad-bot" id="index-banner">
		<div class="row">
			<div class="col s6">
				<div class="chips chips-placeholder"></div>
			</div>
		</div>
		<div class="row">
			<div class="row">
               <label>Materialize Select</label>
               <select>
                  <option value="" disabled selected>Select Fruit</option>
                  <option value="1">0-5 Mins</option>
                  <option value="2">5-10 Mins</option>
                  <option value="3">10-15 Mins</option>
                  <option value="4">15-30 Mins</option>
                  <option value="5">30-45 Mins</option>
                  <option value="6">45-60 Mins</option>
                  <option value="7">60-75 Mins</option>
                  <option value="8">More than 90 Mins</option>
               </select>               
            </div>
			<!-- <div class="col s6">
			Dropdown Trigger Time
				<a class='dropdown-button btn blue' id="timeRangeLabel"
					data-activates='dropdowntimer'>Select Time Range</a>
				Dropdown Structure
				<ul id='dropdowntimer' class='dropdown-content col s6'>
					<li><a href="#!">0-5 Mins</a></li>
					<li class="divider"></li>
					<li><a href="#!">5-10 Mins</a></li>
					<li class="divider"></li>
					<li><a href="#!">10-15 Mins</a></li>
					<li class="divider"></li>
					<li><a href="#!">15-30 Mins</a></li>
					<li class="divider"></li>
					<li><a href="#!">30-45 Mins</a></li>
					<li class="divider"></li>
					<li><a href="#!">45-60 Mins</a></li>
					<li class="divider"></li>
					<li><a href="#!">60-75 Mins</a></li>
					<li class="divider"></li>
					<li><a href="#!">75-90 Mins</a></li>
					<li class="divider"></li>
					<li><a href="#!">More than 90 Mins</a></li>
				</ul>
			</div> -->
		</div>
		<!-- Dropdown Trigger Calorie -->
		<div class="row">
			<div class="col s6">
				<a class='dropdown-button btn  blue' id="calorieRangeLabel"
					data-activates='dropdowncalorie'>Select Calorie Range</a>
				<!-- Dropdown Structure -->
				<ul id='dropdowncalorie' class='dropdown-content'>
					<li><a href="#!">0-50 Calories</a></li>
					<li class="divider"></li>
					<li><a href="#!">50-100 Calories</a></li>
					<li class="divider"></li>
					<li><a href="#!">100-150 Calories</a></li>
					<li class="divider"></li>
					<li><a href="#!">150-200 Calories</a></li>
					<li class="divider"></li>
					<li><a href="#!">200-250 Calories</a></li>
					<li class="divider"></li>
					<li><a href="#!">250-300 Calories</a></li>
					<li class="divider"></li>
					<li><a href="#!">300-350 Calories</a></li>
					<li class="divider"></li>
					<li><a href="#!">350-400 Calories</a></li>
					<li class="divider"></li>
					<li><a href="#!">More than 400 Calories</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col s6">
			<button class="waves-effect waves-light btn">Cancel</button>
			<button class="waves-effect waves-light btn" type="submit" name="action">Submit</button>
		</div>
	</div>
</form>
<script type="text/javascript">
	$(document).ready(function() {
    	$('select').material_select();
 	});
</script>