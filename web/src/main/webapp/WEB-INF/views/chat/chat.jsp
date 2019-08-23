<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<div class="row">

	<div class="col s3">
		<h4 class="header">Contacts:</h4>
		<ul class="collapsible">
			<c:forEach var="contact" items="${gridItems}" varStatus="loopCounter">
				<li>
					<div class="collapsible-header">
						<form id="contactInfo">
							<input id="id" type="hidden" name="acceptorId"
								value="${contact.id}"> <input id="name" type="hidden"
								name="name" value="${contact.acceptorFirstname}">
						</form>
						<i class="material-icons">${contact.avatar}</i>
						<c:out value="${contact.acceptorFirstname}" />
						<c:out value="${contact.acceptorLastname}" />
						<span class="new badge">4</span>
					</div>
					<div class="collapsible-body">
						<a class="btn-floating" href="${pagesUserAccount}/${contact.id}"><i
							class="material-icons">info</i></a> <a class="btn-floating"
							onclick="getMessages()"><i class="material-icons">message</i></a>
					</div>

				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="chatbox">
		<div class="col s9">
			<div class="row">
				<div class="col s12 m6">
					<div class="card teal darken-3">
						<div id="msgAcceptor" class="card-content white-text">
							<span class="card-title">
								<p>${contact.acceptorFirstname}</p>
							</span>

						</div>
						<div class="card-action">
							<a href="#">This is a link</a> <a href="#">This is a link</a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col s3"></div>
				<div class="messages col s9">
					<div id="msgInitiator" class="msg">
						<div class="from">I</div>
						<div id="requestText" class="text">Hello!</div>
					</div>
				</div>
			</div>

			<div class="row ">

				<form id="messageToSend" class="col s12">

					<div class="row">
						<div class="input-field col s6">
							<i class="material-icons prefix">mode_edit</i>
							<textarea id="icon_prefix2" class="materialize-textarea"></textarea>
							<label for="icon_prefix2">Message</label>

						</div>
						<div class="input-field col s3">
							<button class="btn waves-effect waves-light"
								onClick="sendMessage()" type="button">
								send <i class="material-icons right">send</i>
							</button>
						</div>
					</div>

				</form>

			</div>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/chat.js"></script>
<script>
    // getMessages('${pageContext.request.contextPath}', '${contact.acceptorId}');
</script>

