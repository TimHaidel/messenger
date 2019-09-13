<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h4 class="header">
	<spring:message code="form.userAccount.editUserAccount" />
</h4>
<div class="row">

	<form:form class="col s12" method="POST" action="${pagesUserAccount}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="firstname" type="text" disabled="${readonly}" />
				<form:errors path="firstname" cssClass="red-text" />
				<label for="name"><spring:message
						code="form.userAccount.firstname" /></label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="lastname" type="text" disabled="${readonly}" />
				<form:errors path="lastname" cssClass="red-text" />
				<label for="name"><spring:message
						code="form.userAccount.lastname" /></label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="email" type="text" disabled="${readonly}" />
				<form:errors path="email" cssClass="red-text" />
				<label for="name"><spring:message
						code="form.userAccount.email" /></label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="phone" type="text" disabled="${readonly}" />
				<form:errors path="phone" cssClass="red-text" />
				<label for="name"><spring:message
						code="form.userAccount.phone" /></label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:select path="role" type="text" disabled="${readonly}">
					<option value="" disabled>выберите роль</option>
					<form:options items="${roles}" />
				</form:select>
				<form:errors path="role" cssClass="red-text" />
				<label for="name"><spring:message
						code="form.userAccount.role" /></label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="avatar" type="text" disabled="${readonly}" />
				<form:errors path="avatar" cssClass="red-text" />
				<label for="name"><spring:message
						code="form.userAccount.avatar" /></label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="password" type="text" disabled="${readonly}" />
				<form:errors path="password" cssClass="red-text" />
				<label for="name"><spring:message
						code="form.userAccount.password" />
					</entry></label>
			</div>
		</div>
		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">
						<spring:message code="form.userAccount.save" />
						</entry>
					</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right"
					href="${pagesUserAccount}"><spring:message
						code="form.userAccount.toList" /><i class="material-icons right"></i>
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