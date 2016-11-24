<%@ include file="includes/springResources.inc"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean" %>
<% 	
	ArrayList<RecipeBean> recipeArrayList = (ArrayList) request.getAttribute("searchRecipeResultArrayList");
	Iterator<RecipeBean> oneRecipe = recipeArrayList.iterator();
%>

	<%while (oneRecipe.hasNext()) {RecipeBean key = (RecipeBean)oneRecipe.next();%>
			<div class="col s1 m4">
				<div class="card">
					<div class="card-image">
						<img src="<%=key.getImageUrl()%>" /> <span class="card-title"><%=key.getRecipeName()%></span>
					</div>
					<div class="card-content">
						<h6>Calories :<%=key.getCalorieAmount()%></h6>
						<h6>Time : 5 Mins</h6>
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
							<c:forEach items="<%=key.getHealthLabel() %>" var="health">
						        <tr>
						          <td><c:out value="${health}" /><td>
						        </tr>
						      </c:forEach>
						</h6>
					</div>
					<div class="card-action">
			
						<div class="row">
			
							<div class="col s8">
								<a href="#">UnFavourite</a>
							</div>
							<div class="col s4">
								<a href="#">Share</a>
							</div>
							<div class="col s4">
								<a href="<%=key.getMoreInfoUrl()%>">more Info</a>
							</div>
						</div>
			
					</div>
			
				</div>
			</div>
	<%}%>