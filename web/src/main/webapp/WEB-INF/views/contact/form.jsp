<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit contact</h4>
<div class="row">

	<form:form class="col s12" method="POST" action="${pagesContact}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="acceptorId" type="text" disabled="${readonly}" />
				<form:errors path="acceptorId" cssClass="red-text" />
				<label for="name">acceptor</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="initiatorId" type="text" disabled="${readonly}" />
				<form:errors path="initiatorId" cssClass="red-text" />
				<label for="name">initiator</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="status" type="text" disabled="${readonly}" />
				<form:errors path="status" cssClass="red-text" />
				<label for="name">status</label>
			</div>
		</div>

		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">сохранить</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="${pagesContact}">к
					списку<i class="material-icons right"></i>
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