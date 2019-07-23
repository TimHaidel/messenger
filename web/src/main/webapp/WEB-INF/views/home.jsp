<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<h4 class="header">Edit smile</h4>
<div class="row">

	<div class="col s4">
		<c:forEach var="contact" items="${gridItems}" varStatus="loopCounter">
			<ul class="collection">
				<li class="collection-item avatar"><i
					class="material-icons prefix">accessibility <!--<img src="${contact.avatar}" alt="" class="circle">-->
				</i> <span class="title">Title</span>
					<p>
						<c:out value="${contact.firstname}" />
						<br>
						<c:out value="${contact.lastname}" />
					</p> <a href="#!" class="secondary-content"><i
						class="material-icons">grade</i></a></li>



			</ul>
		</c:forEach>
	</div>
	<div class="col s8">
		<div class="row">
			<form class="col s12">

				<div class="row">
					<div class="input-field col s6">
						<i class="material-icons prefix">mode_edit</i>
						<textarea id="icon_prefix2" class="materialize-textarea"></textarea>
						<label for="icon_prefix2">Message</label>

					</div>
					<div class="input-field col s3">
						<button class="btn waves-effect waves-light" type="submit"
							name="action">
							send <i class="material-icons right">send</i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
