<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>

<h4 class="header">Attachments</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link pageUrl="${pagesAttachment}" column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesAttachment}"
					column="content">content</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesAttachment}"
					column="contentType">content type</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesAttachment}"
					column="created">created</mytaglib:sort-link></th>
		</tr>
		<c:forEach var="attachment" items="${gridItems}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${attachment.id}" /></td>
				<td><c:out value="${attachment.content}" /></td>
				<td><c:out value="${attachment.contentType}" /></td>
				<td><c:out value="${attachment.created}" /></td>

				<td class="right"><a class="btn-floating"
					href="${pagesAttachment}/${attachment.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating"
					href="${pagesAttachment}/${attachment.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesAttachment}/${attachment.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />
<a class="waves-effect waves-light btn right"
	href="${pagesAttachment}/add"><i class="material-icons">add</i></a>