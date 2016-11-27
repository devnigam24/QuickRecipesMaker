<%@ include file="includes/springResources.inc"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean" %>
<% 	
	ArrayList<RecipeBean> recipeArrayList = (ArrayList) request.getAttribute("searchRecipeResultArrayList");
	Iterator<RecipeBean> oneRecipe = recipeArrayList.iterator();
%>

	<%while (oneRecipe.hasNext()) {RecipeBean key = (RecipeBean)oneRecipe.next();%>
			<div class="col s12">
				<div class="col s1 m4">
					<div class="card">
						<div class="card-image">
							<img src="<%=key.getImageUrl()%>" /> <span class="card-title"><%=key.getRecipeName()%></span>
						</div>
						<div class="card-content">
							<h6>Calories :<%=key.getCalorieAmount()%></h6>
							<h6>Time : ${cookingTime} Mins</h6>
							<h6>Ingredients : 
								<c:forEach items="<%=key.getIngredientsList() %>" var="ingredient">
							        <tr>
							          <td><c:out value="${ingredient}" /><td>
							        </tr>
							      </c:forEach>
							</h6>
							<h6>Diet Labels : 
								<c:forEach items="<%=key.getDietLabels() %>" var="diet">
							        <tr>
							          <td><c:out value="${diet}" /><td>
							        </tr>
							      </c:forEach>
							</h6>
							<h6>Health Labels : 
								<c:forEach items="<%=key.getHealthLabels() %>" var="health">
							        <tr>
							          <td><c:out value="${health}" /><td>
							        </tr>
							      </c:forEach>
							</h6>
						</div>
						<div class="card-action">
				
							<div class="row">
								<form action="favouriteUnfavouriteAction" id="favouriteUnfavouriteForm">
									<%@ include file="includes/recipeHiddenFields.inc"%>
									<div class="col s8">
										<a onclick="favouriteUnfavouriteAction('favouriteUnfavouriteForm')">Favourite</a>
									</div>
								</form>
								<form action="shareThisRecipe" id="shareForm">
									<%@ include file="includes/recipeHiddenFields.inc"%>
									<div id="share" class="modal modal-fixed-footer">
										<div class="modal-content">
											<h4>Share</h4>
											<div class="row">
												<div class="input-field col s12">
													<input id="emailId" name="shareEmailId" type="email" class="active validate" required
														and aria-required="true"> <label for="emailId">Email Id</label>
												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button class="modal-action modal-close btn-flat">Cancel</button>
											<button class="btn-flat" onclick="shareThisRecipe('shareForm')" type="submit">Share</button>
										</div>
									</div>
									<div class="col s4">
										<a class="modal-trigger waves-effect waves-light" href="#share">Share</a>
									</div>
								</form>
								<div class="col s4">
									<a href="<%=key.getMoreInfoUrl()%>" target="_blank">more Info</a>
								</div>
							</div>
				
						</div>
				
					</div>
				</div>
			</div>
	<%}%>