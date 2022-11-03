<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<style type="text/css">
label {
	font-size: 1.15rem;
}

.padd {
	padding-top: 40px;
}
</style>
</head>
<body class="bg-dark">
	<div class="container padd">
		<div class="row">
			<div class="card col-6 offset-3" style="padding-left: 0px; padding-right: 0px;">
				<div class="card-header text-center ">
					<h3>Login</h3>
				</div>
				<div class="card-body">
					<form:form
						action="${pageContext.request.contextPath}/authenticateTheUser"
						method="post">
						<!-- Login error check -->
						<br>
						<c:if test="${param.error != null}">
							<i class="text-danger">Invalid username/password</i>
							<br>
							<br>
						</c:if>
						<c:if test="${param.logout != null}">
							<i class="text-success">You have been logged out.</i>
							<br>
							<br>
						</c:if>
						<div class="form-group">
							<input class="form-control" type="email" placeholder="username"
								name="username" />
						</div>
						<br>
						<div class="form-group">
							<input class="form-control" type="password"
								placeholder="password" name="password" />
						</div>
						<br>
						<br>
						<div class="text-center">
							<input class="btn btn-success btn-lg btn-block" type="submit"
								value="Login" />
						</div>
						<br>
						<p>
							<a class="text-muted" href="#!">Forgot password?</a>
						</p>
						<p>
							Don't have an account? <a href="${pageContext.request.contextPath}/registerRequest" class="link-info">Register
								here</a>
						</p>
						<p>
							Back to Home <a href="${pageContext.request.contextPath}/" class="link-info">click
								here</a>
						</p>
					</form:form>

				</div>

			</div>

		</div>

	</div>
</body>
</html>