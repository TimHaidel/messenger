<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
					<!-- Dropdown Structure -->

					<ul class="left hide-on-med-and-down ">


						<!-- <li><a class="highlighted-menu-ru" href="?lang=ru">RU</a></li>
					<li><a class="highlighted-menu-en" href="?lang=en">EN</a></li> -->
						<li><a href="${pagesChat}">chats</a></li>
						<sec:authorize access="hasRole('admin')">
							<li><a href="${pagesSmile}">smiles</a></li>
							<li><a href="${pagesSmileGroup}">smile's groups</a></li>
							<li><a href="${pagesUserAccount}">user accounts</a></li>
							<li><a href="${pagesAttachment}">attachments</a></li>
							<li><a href="${pagesUserGroup}">user groups</a></li>
							<li><a href="${pagesMessage}">messages</a></li>
							<li><a href="${pagesContact}">contacts</a></li>
						</sec:authorize>
						<sec:authorize access="!isAnonymous()">

						</sec:authorize>

					</ul>

				</div>
				<div class="col s4 right">
					<div class="left">
						<!--<a class='dropdown-trigger btn left' href=''
						data-target='dropdown1'><i class="material-icons">language</i></a>
					<ul id='dropdown1' class='dropdown-content'>
						<li><a href="?lang=ru">RU</a></li>
						<li><a href="?lang=en">EN</a></li>  
					</ul>-->
					</div>
					<div class="">
						<sec:authorize access="!isAnonymous()">
							<a class="">Login: <sec:authentication property="principal" /></a>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
					Logged user is anonymous
					</sec:authorize>
						<sec:authorize access="!isAnonymous()">
							<a class="right" href="${contextPath}/execute_logout"
								title="logout"><i class="material-icons">arrow_forward</i></a>
						</sec:authorize>
					</div>

				</div>

			</div>

		</div>
	</nav>
</header>