<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h4 class="header"><spring:message code="list.userAccount.UserAccounts" /></h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><spring:message code="list.userAccount.id" /></th>
			<th><spring:message code="list.userAccount.firstname" /></th>
			<th><spring:message code="list.userAccount.lastname" /></th>
			<th><spring:message code="list.userAccount.email" /></th>
			<th><spring:message code="list.userAccount.phone" /></th>
			<th><spring:message code="list.userAccount.role" /></th>
			<th><spring:message code="list.userAccount.avatar" /></th>
		</tr>
		<c:forEach var="userAccount" items="${gridItems}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${userAccount.id}" /></td>
				<td><c:out value="${userAccount.firstname}" /></td>
				<td><c:out value="${userAccount.lastname}" /></td>
				<td><c:out value="${userAccount.email}" /></td>
				<td><c:out value="${userAccount.phone}" /></td>
				<td><c:out value="${userAccount.role}" /></td>
				<td><c:out value="${userAccount.avatar}" /></td>

				<td class="right"><a class="btn-floating"
					href="${pagesUserAccount}/${userAccount.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating"
					href="${pagesUserAccount}/${userAccount.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesUserAccount}/${userAccount.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="waves-effect waves-light btn right"
	href="${pagesUserAccount}/add"><i class="material-icons">add</i></a>