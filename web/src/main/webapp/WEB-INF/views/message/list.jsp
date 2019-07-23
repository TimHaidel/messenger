<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>

<h4 class="header">Messages</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}" column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}"
					column="message">text</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}" column="user">user</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}"
					column="userGroup">group</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesMessage}"
					column="created">created</mytaglib:sort-link></th>
		</tr>

		<c:forEach var="message" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${message.id}" /></td>
				<td><c:out value="${message.message}" /></td>
				<td><c:out value="${message.user}" /></td>
				<td><c:out value="${message.userGroup}" /></td>
				<td><c:out value="${message.created}" /></td>

				<td class="right"><a class="btn-floating"
					href="${pagesMessage}/${message.id}/attach"><i
						class="material-icons">attach</i></a> <a class="btn-floating"
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