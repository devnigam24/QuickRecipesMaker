<span class="col-xs-12 serverErrorMsg middle">
	<c:forEach var="serverSideErrors" items="${ErrorList}">
		<spring:message code="${serverSideErrors}" />
	</c:forEach>
</span>	