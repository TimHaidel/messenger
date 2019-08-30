<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<div class="row">
	<div class="col s4">
		<ul id="tabs-swipe-demo" class="tabs">
			<li class="tab col s6"><a href="#test-swipe-1">Contacts</a></li>
			<li class="tab col s6"><a class="active" href="#test-swipe-2">Chats</a></li>
		</ul>
		<div id="test-swipe-1" class="col s12 ">
			<ul class="collection">
				<c:forEach var="contact" items="${contactItems}"
					varStatus="loopCounter">

					<li class="collection-item avatar"><span class="new badge">4</span><img
						src="images/yuna.jpg" alt="" class="circle"><a href="#"
						id="contactLink" class="collection-item"
						onclick="toGroup(${contact.id})"> <c:out
								value="${contact.acceptorFirstname}" /> <br> <c:out
								value="${contact.acceptorLastname}" />
					</a></li>
				</c:forEach>
			</ul>
		</div>
		<div id="test-swipe-2" class="col s12 ">



			<!--  
			<c:forEach var="userId" items="${loggedUserId}"
				varStatus="loopCounter">
				<input type="hidden" id="loggedUserId" value="${userId}">
			</c:forEach>
-->




			<ul class="collection">
				<c:forEach var="group" items="${groupItems}" varStatus="loopCounter">
					<li class="collection-item avatar"><span class="new badge">4</span><a
						href="#" id="contactLink" class="collection-item"
						onclick="getMessages(${group.id})"> <c:out
								value="${group.name}" /></a></li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<div class="col s8">
		<div class="chatbox" class="col s 9 ">
			<!-- 
			<div id="messageBlue" class="message-blue">
				<p class="message-content">This is an awesome message!</p>
				<div class="message-timestamp-left">SMS 13:37</div>
			</div>

			<div class="message-orange">
				<p class="message-content">I agree that your message is awesome!</p>
				<div class="message-timestamp-right">SMS 13:37</div>
			</div>	 -->
		</div>
		<form id="messageToSend" class="col s12">
			<div class="row">
				<div class="input-field col s6">
					<i class="material-icons prefix">mode_edit</i>
					<textarea id="icon_prefix2" class="materialize-textarea"></textarea>
					<label for="icon_prefix2">Message</label>

					<div class="smiles">
						<a class='dropdown-trigger btn' href='#' data-target='dropdown1'>Smiles</a>

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
					<button class="btn waves-effect waves-light"
						onClick="sendMessage()" type="button">
						send <i class="material-icons right">send</i>
					</button>
				</div>


			</div>
		</form>


	</div>
</div>


<script src="${pageContext.request.contextPath}/resources/js/chat.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/smiles.js"></script>
<script>
    // getMessages('${pageContext.request.contextPath}', '${contact.acceptorId}');
</script>