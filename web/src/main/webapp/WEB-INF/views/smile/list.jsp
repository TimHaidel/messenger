<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>

<h4 class="header">Smiles</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link pageUrl="${pagesSmile}" column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesSmile}" column="name">name</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesSmile}" column="marker">marker</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${pagesSmile}"
					column="smileGroup">group</mytaglib:sort-link></th>
		</tr>
		<c:forEach var="smile" items="${gridItems}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${smile.id}" /></td>
				<td><c:out value="${smile.name}" /></td>
				<td><c:out value="${smile.marker}" /></td>
				<td><c:out value="${smile.smileGroup}" /></td>

				<td class="right"><a class="btn-floating"
					href="${pagesSmile}/${smile.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="${pagesSmile}/${smile.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${pagesSmile}/${smile.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />
<a class="waves-effect waves-light btn right" href="${pagesSmile}/add"><i
	class="material-icons">add</i></a>