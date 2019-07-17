<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h4 class="header">SmileGroups</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th>id</th>
			<th>name</th>
			<th></th>
		</tr>
		<c:forEach var="smileGroup" items="${gridItems}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${smileGroup.id}" /></td>
				<td><c:out value="${smileGroup.name}" /></td>

				<td class="right"><a class="btn-floating"
					href="${pagesSmileGroup}/${smileGroup.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating"
					href="${pagesSmileGroup}/${smileGroup.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesSmileGroup}/${smileGroup.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="waves-effect waves-light btn right"
	href="${pagesSmileGroup}/add"><i class="material-icons">add</i></a>