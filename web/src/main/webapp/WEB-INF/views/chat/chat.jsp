<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<h4 class="header">chats</h4>
<div class="row">

	<div class="col s4">
		<ul class="collection">
			<c:forEach var="contact" items="${gridItems}" varStatus="loopCounter">


				<li class="collection-item avatar"><a href=""
					class="collection-item"
					onclick="getMessages('${pageContext.request.contextPath}', '${contact.acceptorId}')"><i
						class="material-icons prefix">${contact.avatar} <!--<img src="${contact.avatar}" alt="" class="circle">-->
					</i> <span class="badge">1</span>
						<p>
							<c:out value="${contact.acceptorFirstname}" />

							<c:out value="${contact.acceptorLastname}" />
						</p> </a></li>



			</c:forEach>
		</ul>
	</div>
	<div class="chatbox">
		<div class="col s8">
			<div class="row">
				<div class="messages col s9">
					<div id="msgAcceptor" class="msg">
						<div class="from">Iva</div>
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
				<form class="col s12">

					<div class="row">
						<div class="input-field col s6">
							<i class="material-icons prefix">mode_edit</i>
							<textarea id="icon_prefix2" class="materialize-textarea"></textarea>
							<label for="icon_prefix2">Message</label>

						</div>
						<div class="input-field col s3">
							<button class="btn waves-effect waves-light"
								onClick="sendMessage()">
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

