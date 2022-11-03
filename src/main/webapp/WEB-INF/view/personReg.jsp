<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Shagun Collection Registration</title>
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
.size {
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
			<div class="card col-6 offset-3">
				<br>
				<div class="text-center">
					<h2>Shagun Collection Registration</h2>
				</div>
				<br>
				<div class="container">
					<form:form class="form-group" action="saveDetails"
						modelAttribute="person" method="post">
						<c:if test="${error != null}">
							<i class="text-danger">This marriage exist!!</i>
							<br>
							<br>
						</c:if>
						<form:hidden path="id" />
						<div class="form-group">
							<label class="size">First Name <span class="text-danger">*</span></label>
							<form:input class="form-control" path="firstName" />
							<form:errors path="firstName" cssClass="error"/>
						</div>
						<div>
							<label class="size">Last Name <span class="text-danger">*</span></label>
							<form:input class="form-control" path="lastName" />
							<form:errors path="lastName" cssClass="error"/>
						</div>
						<div>
							<label class="size">Address <span class="text-danger">*</span></label>
							<form:input class="form-control" path="address" />
							<form:errors path="address" cssClass="error"/>
						</div>
						<div>
							<label class="size">UPI Id <span class="text-danger">*</span></label>
							<form:input class="form-control" path="upiId" />
							<form:errors path="upiId" cssClass="error"/>
						</div>
						<div>
							<label class="size">Girl Name <span class="text-danger">*</span></label>
							<form:input class="form-control" path="girlName" />
							<form:errors path="girlName" cssClass="error"/>
						</div>
						<div>
							<label class="size">Boy Name <span class="text-danger">*</span></label>
							<form:input class="form-control" path="boyName" />
							<form:errors path="boyName" cssClass="error"/>
						</div>
						<div>
							<label class="size">Marriage Date <span
								class="text-danger">*</span></label>
							<form:input class="form-control" type="date" path="marriageDate" />
							<form:errors path="marriageDate" cssClass="error"/>
						</div>
						<br>
						<div class="text-center">
							<input class="btn btn-dark btn-lg" type="submit" value="Register" />
						</div>
						<div>
							<label class="size"><span class="text-danger">*</span>
								Required field</label>
						</div>
					</form:form>
					<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
