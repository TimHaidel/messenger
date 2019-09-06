<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<div class="row">
	<div class="contact-block col s4">
		<ul id="tabs-swipe-demo" class="tabs">
			<li class="tab col s6"><a href="#test-swipe-1">Contacts</a></li>
			<li class="tab col s6"><a class="active" href="#test-swipe-2">Chats</a></li>
		</ul>
		<div id="test-swipe-1" class="col s12 ">
			<ul class="collection">
				<c:forEach var="contact" items="${contactItems}"
					varStatus="loopCounter">

					<li class="collection-item avatar">
						<!--  <span class="new badge">4</span>--> <img
						src="${contact.avatar}" alt="" class="circle"><a href="#"
						id="contactLink" class="collection-item"
						onclick="toGroup(${contact.id})"> <c:out
								value="${contact.acceptorFirstname}" /> <br> <c:out
								value="${contact.acceptorLastname}" />
					</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div id="test-swipe-2" class="col s12 ">

			<ul class="collection">
				<c:forEach var="group" items="${groupItems}" varStatus="loopCounter">
					<li class="collection-item avatar">
						<!--  <span class="new badge">4</span>--> <a href="#"
						id="contactLink" class="collection-item"
						onclick="getMessages(${group.id})"> <c:out
								value="${group.name}" /></a>
					</li>

				</c:forEach>
			</ul>
		</div>
	</div>

	<div class="col s8">
		<div id="chatbox" class="chatbox" class="col s 9 "></div>
		<div id="message-to-send" class="col s12">
			<form>
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
								<span><img class="smile"
									src="${pageContext.request.contextPath}/resources/smiles/ab.png"
									alt=":ab:"></span>
								<span><img class="smile"
									src="${pageContext.request.contextPath}/resources/smiles/ac.gif"
									alt=":ac:"></span>
								<span><img class="smile"
									src="${pageContext.request.contextPath}/resources/smiles/ae.gif"
									alt=":ae:"></span>
							</ul>
						</div>
					</div>

					<div class="input-field col s3">
						<button class="btn waves-effect waves-light btn-small"
							onClick="sendMessage()" type="button">
							send <i class="material-icons right">send</i>
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