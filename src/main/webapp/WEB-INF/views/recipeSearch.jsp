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
        <!-- Dropdown Trigger Time -->
		<div class="row">
			<div class="row">
               <label>Materialize Select</label>
               <select>
                  <option value="" disabled selected>Select Time</option>
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
		</div>
        
        <!-- Dropdown Trigger Calorie -->
        <div class="row">
			<div class="row">
               <label>Materialize Select</label>
               <select>
                  <option value="" disabled selected>Select Calorie</option>
                  <option value="1">0-50 Calories</option>
                  <option value="2">50-100 Calories</option>
                  <option value="3">100-150 Calories</option>
                  <option value="4">150-200 Calories</option>
                  <option value="5">200-250 Calories</option>
                  <option value="6">250-300 Calories</option>
                  <option value="7">300-350 Calories</option>
                  <option value="8">350-400 Calories</option>
                  <option value="8">More than 400 Calories</option>
               </select>               
            </div>		
		</div>
	</div>
	<div class="row">
		<div class="col s6">
			<button class="waves-effect  btn">Cancel</button>
			<button class="waves-effect  btn" type="submit" name="action">Submit</button>
		</div>
	</div>
</form>
<script type="text/javascript">
	$(document).ready(function() {
    	$('select').material_select();
 	});
</script>
