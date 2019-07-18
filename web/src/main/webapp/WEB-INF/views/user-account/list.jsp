<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h4 class="header">UserAccount</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th>id</th>
			<th>firstname</th>
			<th>lastname</th>
			<th>email</th>
			<th>phone</th>
			<th>role</th>
			<th>avatar</th>
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