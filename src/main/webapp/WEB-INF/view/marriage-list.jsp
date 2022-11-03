<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Marriages List</title>
<!-- Bootstrap -->
<!-- style sheet -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/stylesheet2.css">
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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather&family=Montserrat:wght@100;400;900&family=Sacramento&family=Ubuntu&display=swap" rel="stylesheet">

</head>
<body class="padd-color">
<section id="" class="padd-section2 section-color">
      <!-- Nav Bar -->
      <nav class="navbar navbar-expand-md navbar-dark">
          <a class = "navbar-brand" href = "home">WedsPay</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
              <ul class = "navbar-nav ms-auto">
                  <li class = "nav-item">
                      <a class="nav-link"  href = "home">Home</a>
                  </li>
                  <li class = "nav-item">
                      <a class="nav-link"  href = "showForm">Pay Now</a>
                  </li>
                  <li class = "nav-item">
                      <a class="nav-link"  href = "logout">Logout</a>
                  </li>
              </ul>
          </div>
      </nav>
     </section>
     <section class="padd-section3">
		<div class="wrapper">
			<div id="header" class="text-center">
				<h2>Registered Marriages List</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>Girl Name</th>
						<th>Boy Name</th>
						<th>Marriage Id</th>
						<th>Marriage Date</th>
						<th>Action</th>
					</tr>
					<!-- Encode query parameter it is giving problem -->
					<c:forEach var="person" items="${marriages}">
						<!-- Payments List with Marriage Id 
						<c:url  var = "paymentList" value="/user/paymentList">
							<c:param  name="personId" value = "${person.id}" />
						</c:url>
						<c:url var="download" value="/user/pdf">
							<c:param name="personId" value="${person.id}" />
						</c:url>
						-->
						<tr class="tabrow">
							<td>${person.girlName}</td>
							<td>${person.boyName}</td>
							<td>${person.marriageId}</td>
							<td>${person.marriageDate}</td>
							<td>
								<form:form action="${pageContext.request.contextPath}/user/paymentList" method="POST">
								  <button type="submit" name="personId" value="${person.id}" class="link-button">
								    Shagun List
								  </button>
								</form:form>
							|
								<form:form action="${pageContext.request.contextPath}/user/pdf" method="POST">
								  <button type="submit" name="personId" value="${person.id}" class="link-button">
								    Download List
								  </button>
								</form:form>
							
							
							
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</section>
</body>
</html>