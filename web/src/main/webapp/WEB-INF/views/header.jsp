<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<header>
	<nav>
		<div class="teal accent-4">
			<div class="nav-wrapper container ">
				<ul class="left hide-on-med-and-down ">
					<li><a href="${contextPath}/">home</a></li>
					<li><a href="${pagesChat}">chats</a></li>
					<sec:authorize access="hasRole('admin')">
						<li><a href="${pagesSmile}">smiles</a></li>
						<li><a href="${pagesSmileGroup}">smile's groups</a></li>
						<li><a href="${pagesUserAccount}">user accounts</a></li>
						<li><a href="${pagesAttachment}">attachments</a></li>
						<li><a href="${pagesUserGroup}">user groups</a></li>
						<li><a href="${pagesMessage}">messages</a></li>
					</sec:authorize>
					<sec:authorize access="!isAnonymous()">
						<li><a href="${pagesContact}">contacts</a></li>
					</sec:authorize>
				</ul>
				<ul>
					<sec:authorize access="!isAnonymous()">
						<a class="right">Login: <sec:authentication
								property="principal" /></a>
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
					Logged user is anonymous
				</sec:authorize>
				</ul>
				<sec:authorize access="!isAnonymous()">
					<a class="right" href="${contextPath}/execute_logout"
						title="logout"><i class="material-icons">arrow_forward</i></a>
				</sec:authorize>


			</div>
		</div>
	</nav>

</header>