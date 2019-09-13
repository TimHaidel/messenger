<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h4 class="header">
	<spring:message code="list.message.messages" />
</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}" column="id">
					<spring:message code="list.message.id" />
				</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}"
					column="message">text</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}" column="user">
					<spring:message code="list.message.user" />
				</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}"
					column="userGroup">
					<spring:message code="list.message.group" />
				</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}"
					column="created">
					<spring:message code="list.message.created" />
				</mytaglib:sort-link></th>
		</tr>

		<c:forEach var="message" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${message.id}" /></td>
				<td><c:out value="${message.message}" /></td>
				<td><c:out value="${message.userId}" /></td>
				<td><c:out value="${message.userGroupId}" /></td>
				<td><c:out value="${message.created}" /></td>

				<td class="right"><a class="btn-floating"
					href="${pagesMessage}/${message.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="${pagesMessage}/${message.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesMessage}/${message.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />
<a class="waves-effect waves-light btn right" href="${pagesMessage}/add"><i
	class="material-icons">add</i></a>