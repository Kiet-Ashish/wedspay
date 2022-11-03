<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Payment process</title>
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
	.size{
		font-size: 1.15rem;
	}
	.padd{
		padding-top: 60px;
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
					<h2 >Payment Process Form</h2>
				</div>
				<br>
				<div class="container">
					<form:form class="form-group" action="savePayment" modelAttribute="payment"
						method="post">
						<form:hidden path="id" />
						<c:if test="${error != null}" >
							<i class="text-danger">${error}</i>
							<br>
							<br>
						</c:if>
						<div >
							<label class="size">Name <span class="text-danger">*</span></label>
							<form:input class="form-control" path="name" />
							<form:errors path="name" cssClass="error"/>
						</div>
						<div >
							<label class="size">Address <span class="text-danger">*</span></label>
							<form:input class="form-control" path="address" />
							<form:errors path="address" cssClass="error"/>
						</div>
						<div>
							<label class="size">Amount <span class="text-danger">*</span></label>
							<form:input class="form-control" path="amount" />
							<form:errors path="amount" cssClass="error"/>
						</div>
						<div >
							<label class="size">Marriage Id (<span class="text-danger">Girl name + Mobile
									No.</span>) <span class="text-danger">*</span>
							</label>
							<form:input class="form-control" path="marriageId" />
							<form:errors path="marriageId" cssClass="error"/>
						</div>
						<br>
						<div class="text-center">
							<input class="btn btn-dark btn-lg" type="submit"
								value="Proceed" />
						</div>
						<div class="form-group">
							<label class="size"><span class="text-danger">*</span> Required field</label>
						</div>
					</form:form>
					<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>