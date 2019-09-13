<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<footer class="teal accent-4 page-footer">
	<div class="container ">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">Links:</h5>
				<a target="_blank" class="white-text"
					href="${contextPath}/resources/footer/messenger-dbdesigner.pdf"><spring:message code="page.footer.dataModel" /></a> <br> <a target="_blank" class="white-text"
					href="${contextPath}/resources/footer/map.pdf"><spring:message code="page.footer.mindMap" /></a> <br>
				<a target="_blank" class="white-text"
					href="${contextPath}/resources/footer/accounts.txt"><spring:message code="page.footer.list"/></a>
			</div>
			<div class="col l4 offset-l2 s12">
				<h5 class="white-text">Info:</h5>
				<span><spring:message code="page.footer.name" /></span> <br> <span>tsimur.haidel@gmail.com</span>
				<br> <span>+375 29 7863159</span><br> <a target="_blank"
					class="white-text"
					href="https://www.linkedin.com/in/tsimur-haidel-623645192/">linkedIn</a>

			</div>
		</div>
	</div>
	<div class="footer-copyright">
		<div class="container">2019 Copyright Text</div>
	</div>
</footer>