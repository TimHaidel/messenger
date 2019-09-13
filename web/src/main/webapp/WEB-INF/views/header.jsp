<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="currentLocale"
	value="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}" />
<!--  
<style>
.highlighted-menu-
${
currentLocale
!=
null
?
currentLocale
:

'
ru
'
}
{
text-decoration
:
underline
;
}
</style>
-->
<header>

	<nav>
		<div class="teal accent-4">


			<div class="nav-wrapper container ">

				<div class="col s8">

					<ul class="left hide-on-med-and-down ">


						<!-- <li><a class="highlighted-menu-ru" href="?lang=ru">RU</a></li>
					<li><a class="highlighted-menu-en" href="?lang=en">EN</a></li> -->
						<li><a href="${pagesChat}"><spring:message
									code="page.header.chats"/></a></li>
						<sec:authorize access="hasRole('admin')">
							<li><a href="${pagesSmile}"><spring:message
										code="page.header.smiles" /></a></li>
							<li><a href="${pagesSmileGroup}"><spring:message
										code="page.header.smilesGroup" /></a></li>
							<li><a href="${pagesUserAccount}"><spring:message
										code="page.header.userAccount" /></a></li>
							<li><a href="${pagesAttachment}"><spring:message
										code="page.header.attachments" /></a></li>
							<li><a href="${pagesUserGroup}"><spring:message
										code="page.header.userGroup" /></a></li>
							<li><a href="${pagesMessage}"><spring:message
										code="page.header.messages" /></a></li>
							<li><a href="${pagesContact}"><spring:message
										code="page.header.contacts" /></a></li>
						</sec:authorize>
						<sec:authorize access="!isAnonymous()">

						</sec:authorize>

					</ul>

				</div>

				<div class="col s4 right">
					<a class='dropdown-trigger btn' data-target='dropdown2'><i
						class="material-icons">language</i></a>
					<ul id='dropdown2' class='dropdown-content'>
						<li><a href="?lang=ru">RU</a></li>
						<li><a href="?lang=en">EN</a></li>
					</ul>
					<sec:authorize access="!isAnonymous()">
						<a class=""><spring:message code="page.header.login" /> <sec:authentication
								property="principal" /></a>
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
						<spring:message code="page.header.loggedUser" />
					</sec:authorize>
					<sec:authorize access="!isAnonymous()">
						<a class="right" href="${contextPath}/execute_logout"
							title="logout"><i class="material-icons">arrow_forward</i></a>
					</sec:authorize>

				</div>

			</div>

		</div>
	</nav>
</header>