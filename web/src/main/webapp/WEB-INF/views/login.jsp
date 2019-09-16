<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Login with Username and Password</h2>
<div class="row">
	<div class="col s3"></div>
	<div class="col s6">
		<ul id="tabs-swipe-demo" class="tabs">
			<li class="tab col s3"><a href="#test-swipe-1">Sign in</a></li>
			<li class="tab col s3"><a href="#test-swipe-2">Sign up</a></li>
		</ul>
		<div id="test-swipe-1" class="col s12">
			<form name='loginForm' action="<c:url value='login' />" method='POST'>
				<div class="row">
					<div class="input-field col s12 center">
						<input type='text' name='username' value=''> <label
							for="username">User:</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 center">
						<input type='password' name='password' /><label for="password">Password:</label>
					</div>
				</div>
				<c:if test="${not empty error}">
					<div class="row">
						<div class="col s12 center">
							<div class="error">${error}</div>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="row">
						<div class="col s12 center">
							<div class="msg">${msg}</div>
						</div>
					</div>
				</c:if>
				<div class="row">
					<div class="col s12 center">
						<button class="btn waves-effect waves-light " type="submit">войти</button>
					</div>
				</div>
			</form>
		</div>
		<div id="test-swipe-2" class="col s12">
			<form name='registrationForm' action="<c:url value='registration' />"
				method='POST'>
				<div class="row">
					<div class="input-field col s6 center">
						<input type='text' name='firstname' value=''> <label
							for="firstname">Firstname:</label>
					</div>
					<div class="input-field col s6 center">
						<input type='text' name='lastname' value=''> <label
							for="lastname">Lastname:</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 center">
						<input type='text' name='email' value=''> <label
							for="email">E-mail:</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 center">
						<input type='password' name='password' /><label for="password">Password:</label>
					</div>
				</div>
				<c:if test="${not empty error}">
					<div class="row">
						<div class="col s12 center">
							<div class="error">${error}</div>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="row">
						<div class="col s12 center">
							<div class="msg">${msg}</div>
						</div>
					</div>
				</c:if>
				<div class="row">
					<div class="col s12 center">
						<button class="btn waves-effect waves-light " type="submit">войти</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="col s3"></div>
</div>