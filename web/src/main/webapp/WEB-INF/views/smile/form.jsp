<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit smile</h4>
<div class="row">

	<form:form class="col s12" method="POST" action="${pagesSmile}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="name" type="text" disabled="${readonly}" />
				<form:errors path="name" cssClass="red-text" />
				<label for="name">name</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="marker" type="text" disabled="${readonly}" />
				<form:errors path="marker" cssClass="red-text" />
				<label for="marker">marker</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:select path="smileGroupId" disabled="${readonly}">
					<form:options items="${smileGroupsChoices}" />
				</form:select>
				<form:errors path="smileGroupId" cssClass="red-text" />
				<label for="smileGroupId">Smile Group</label>
			</div>
		</div>
		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">save</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="${pagesSmile}">to
					list<i class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>


<c:if test='${param["showAlerts"]}'>
	<!-- checks the URL parameter -->


	<script src="${contextPath}/resources/js/sample-alert-with-params.js"></script>
	<script>
		showMessage('${contextPath}'); // execute function defined somewhere above
	</script>

</c:if>