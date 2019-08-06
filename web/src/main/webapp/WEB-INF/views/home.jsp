<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<h4 class="header">Home</h4>

<div>
	<spring:message code="page.home.title" />
</div>

<div>${welcomeMessage}</div>