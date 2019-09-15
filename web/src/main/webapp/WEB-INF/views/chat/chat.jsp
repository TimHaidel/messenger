<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<div class="row">

	<div class="contact-block col s4">
		<ul id="tabs-swipe-demo" class="tabs">
			<li class="tab col s6"><a href="#test-swipe-1"><spring:message
						code="page.chat.contacts" /></a></li>
			<li class="tab col s6"><a class="active" href="#test-swipe-2"><spring:message
						code="page.chat.chats" /></a></li>
		</ul>
		<div>
			<!-- Modal Trigger -->
			<a class="waves-effect waves-light btn modal-trigger" href="#modal1"><i
				class="material-icons prefix">search</i> </a>
			<!-- Modal Structure -->
			<a href="" onclick="getPinedMessages()" data-target="slide-out"
				class="waves-effect waves-light btn sidenav-trigger"
				onclick="getPinedMessages()"><i class="material-icons">message</i>
			</a>
		</div>
		<ul id="slide-out" class="sidenav collection">

		</ul>
		<div id="modal1" class="modal">
			<div class="modal-content">
				<div class="row">
					<div class="col s12">
						<form>
							<div class="row">
								<div class="input-field col s12">
									<i class="material-icons prefix">search</i> <input type="text"
										id="autocomplete-input" name="auto" class="autocomplete">
									<label for="autocomplete-input"><spring:message
											code="page.chat.search" /></label><a class="btn-floating "
										onclick="addContact(document.getElementById('autocomplete-input').value)"><i
										class="material-icons">add</i></a>
									<spring:message code="page.chat.addContact" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<a href="#!" class="modal-close waves-effect waves-green btn-flat">OK</a>
			</div>
		</div>

		<div id="test-swipe-1" class="col s12 ">


			<ul class="collection">
				<c:forEach var="contact" items="${contactItems}"
					varStatus="loopCounter">

					<!--  <img src="${contact.avatar}" alt="" class="circle">-->
					<a href="#" id="contactLink" class="collection-item"
						onclick="toGroup(${contact.id})"> <c:out
							value="${contact.acceptorFirstname}" /> <c:out
							value="${contact.acceptorLastname}" />
					</a>
				</c:forEach>
			</ul>
		</div>
		<div id="test-swipe-2" class="col s12 ">

			<ul class="collection">
				<c:forEach var="group" items="${groupItems}" varStatus="loopCounter">
					<a href="#" id="contactLink" class="collection-item"
						onclick="getMessages(${group.id})"> <c:out
							value="${group.name}" /></a>

				</c:forEach>
			</ul>
		</div>
	</div>

	<div class="col s8">
		<div id="chatbox" class="chatbox" class="col s 9 "></div>
		<div id="message-to-send" class="col s12">
			<form id="messageForm" hidden="true">
				<div class="row">
					<div class="input-field col s6">
						<i class="material-icons prefix">mode_edit</i>
						<textarea id="icon_prefix2" class="materialize-textarea"></textarea>
						<label for="icon_prefix2">Message</label>

						<div class="smiles">
							<a class='dropdown-trigger btn-floating btn-small' href='#'
								data-target='dropdown1'><i class="material-icons">child_care</i></a>

							<!-- Dropdown Structure -->
							<ul id='dropdown1' class='dropdown-content'>
								<!--  <span><img class="smile"
									src="${pageContext.request.contextPath}/resources/smiles/ab.png"
									alt=":ab:"></span>
								<span><img class="smile"
									src="${pageContext.request.contextPath}/resources/smiles/ac.gif"
									alt=":ac:"></span>
								<span><img class="smile"
									src="${pageContext.request.contextPath}/resources/smiles/ae.gif"
									alt=":ae:"></span>-->
								<c:forEach var="smile" items="${smileItems}"
									varStatus="loopCounter">
									<span><img class="smile"
										src="data:image/jpeg;base64, <c:out
											value="${smile.marker}"/>"
										alt="${smile.name}"></span>

								</c:forEach>

							</ul>
						</div>
					</div>

					<div class="input-field col s3">
						<button class="btn waves-effect waves-light btn-small"
							onClick="sendMessage()" type="button">
							<spring:message code="page.chat.send" />
							<i class="material-icons right">send</i>
						</button>
					</div>

				</div>

			</form>


		</div>




	</div>

</div>


<script src="${pageContext.request.contextPath}/resources/js/chat.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/smiles.js"></script>
<script>
    // getMessages('${pageContext.request.contextPath}', '${contact.acceptorId}');
</script>