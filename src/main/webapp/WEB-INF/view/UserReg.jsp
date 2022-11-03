<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User Registration</title>
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
.error{
 		color: red;
}
</style>
</head>
<body class="bg-dark">
	<div class="container padd">
		<div class="row">
			<div class="card col-6 offset-3" style="padding-left: 0px; padding-right: 0px;">
				<div class="card-header text-center ">
					<h3>User Register</h3>
				</div>
				<div class="card-body">
					<form:form action="userRegister" modelAttribute="user" method="post" >
						<!-- Login error check -->
						
						<div class="form-group">
							<form:input class="form-control" placeholder="Enter Name"
								path="name" />
							<form:errors path="name" cssClass="error" />
						</div>
						<br>
						<div class="form-group">
							<form:input class="form-control" placeholder="Enter Mobile No."
								path="mobile" />
							<form:errors path="mobile" cssClass="error" />
						</div>
						<br>
						<div class="form-group">
							<form:input class="form-control" placeholder="Enter email"
								path="email" />
							<form:errors path="email" cssClass="error" />
						</div>
						<br>
						<div class="form-group">
							<form:input class="form-control" type="password"
								placeholder="Enter password" path="password" />
							<form:errors path="password" cssClass="error" />
						</div>
						<br>
						<div class="form-group form-check">
							<input name="agg" type="checkbox" class="form-check-input" id="agg" />
							<label for="agg">Accept terms and conditions.</label>
						</div>
						<br>
						<div class="text-center">
							<input class="btn btn-success btn-lg btn-block" type="submit"
								value="Register" />
						</div>
						<br>
						<p>
							Have an account? <a href="${pageContext.request.contextPath}/user/showMyLoginPage" class="link-info">Login
								here</a>
						</p>
					</form:form>

				</div>

			</div>

		</div>

	</div>
</body>
</html>