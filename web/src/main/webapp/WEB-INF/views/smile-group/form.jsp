<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h4 class="header">
	<spring:message code="form.smileGroup.editSmileGroup" />
</h4>
<div class="row">

	<form:form class="col s12" method="POST" action="${pagesSmileGroup}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="name" type="text" disabled="${readonly}" />
				<form:errors path="name" cssClass="red-text" />
				<label for="name"><spring:message
						code="form.smileGroup.name" /></label>
			</div>
		</div>
		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">
						<spring:message code="form.smileGroup.save" />
						
					</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right"
					href="${pagesSmileGroup}"><spring:message
						code="form.smileGroup.toList" /><i class="material-icons right"></i>
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