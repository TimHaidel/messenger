<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit smile</h4>
<div class="row">

	<form:form class="col s12" method="POST" action="${pagesMessage}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="message" type="text" disabled="${readonly}" />
				<form:errors path="message" cssClass="red-text" />
				<label for="message">text</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="user" type="text" disabled="${readonly}" />
				<form:errors path="user" cssClass="red-text" />
				<label for="user">user</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="userGroup" type="text" disabled="${readonly}" />
				<form:errors path="userGroup" cssClass="red-text" />
				<label for="userGroup">group</label>
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
				<a class="btn waves-effect waves-light right" href="${pagesMessage}">to
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