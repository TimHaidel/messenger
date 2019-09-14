<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h4 class="header"><spring:message
						code="list.contact.contacts" /></h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link pageUrl="${pagesContact}" column="id"><spring:message
						code="list.contact.id" /></mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesContact}"
					column="acceptorId"><spring:message
						code="list.contact.acceptor" /></mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesContact}"
					column="initiatorId"><spring:message
						code="list.contact.initiator" /></mytaglib:sort-link></th>
		</tr>
		<c:forEach var="contact" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${contact.id}" /></td>
				<td><c:out value="${contact.acceptorId}" /></td>
				<td><c:out value="${contact.initiatorId}" /></td>

				<td class="right"><a class="btn-floating"
					href="${pagesContact}/${contact.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="${pagesContact}/${contact.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesContact}/${contact.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />
<a class="waves-effect waves-light btn right" href="${pagesContact}/add"><i
	class="material-icons">add</i></a>