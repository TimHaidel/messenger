<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit user account</h4>
<div class="row">

	<form:form class="col s12" method="POST" action="${pagesUserAccount}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="firstname" type="text" disabled="${readonly}" />
				<form:errors path="firstname" cssClass="red-text" />
				<label for="name">firstname</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="lastname" type="text" disabled="${readonly}" />
				<form:errors path="lastname" cssClass="red-text" />
				<label for="name">lastname</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="email" type="text" disabled="${readonly}" />
				<form:errors path="email" cssClass="red-text" />
				<label for="name">e-mail</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="phone" type="text" disabled="${readonly}" />
				<form:errors path="phone" cssClass="red-text" />
				<label for="name">phone</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="role" type="text" disabled="${readonly}" />
				<form:errors path="role" cssClass="red-text" />
				<label for="name">role</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="avatar" type="text" disabled="${readonly}" />
				<form:errors path="avatar" cssClass="red-text" />
				<label for="name">avatar</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="password" type="text" disabled="${readonly}" />
				<form:errors path="password" cssClass="red-text" />
				<label for="name">password</label>
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
				<a class="btn waves-effect waves-light right"
					href="${pagesUserAccount}">list<i class="material-icons right"></i>
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