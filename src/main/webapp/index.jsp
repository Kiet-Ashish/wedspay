<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>WedsPay</title>
  <!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
  <!-- style sheet -->
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
  <link rel="icon" href="${pageContext.request.contextPath}/resources/images/wedpay-icon.png">
  <!-- Font Awesome -->
 <script src="https://kit.fontawesome.com/69d727b4a3.js" crossorigin="anonymous"></script>
  <!-- google font -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Merriweather&family=Montserrat:wght@100;400;900&family=Sacramento&family=Ubuntu&display=swap" rel="stylesheet">
</head>

<body>

  <section id="title" class="padd-section">
    <div class="container-fluid">
      <!-- Nav Bar -->
      <nav class="navbar navbar-expand-md navbar-dark">
          <a class = "navbar-brand" href = "#title">WedsPay</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
              <ul class = "navbar-nav ms-auto">
                  <li class = "nav-item">
                      <a class="nav-link"  href = "#footer">Contact</a>
                  </li>
                  <li class = "nav-item">
                      <a class="nav-link"  href = "#pricing">Pricing</a>
                  </li>
                  <li class = "nav-item">
                      <a class="nav-link"  href = "#cta">Download</a>
                  </li>
              </ul>
          </div>
      </nav>



      <!-- Title -->
    <div class="row">
      <div class="col-lg-6">
        <h1 class="big-heading">Why to wait ??<br />Pay wedding Shagun online now.</h1>
        <!-- <button type="button" onclick="window.location.href='showForm'; return false;" class="btn btn-dark btn-lg butn"></i> Pay now</button> -->
        <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/registerRequest'; return false;" class="btn btn-dark btn-lg download-button">Register</button>
        <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/user/showMyLoginPage'; return false;" class="btn btn-outline-light btn-lg download-button">Login</button>
      </div>
      <div class="col-lg-6">
        <img class="first-image" src="${pageContext.request.contextPath}/resources/images/iphone6.png" alt="iphone-mockup">
      </div>
    </div>
    </div>

  </section>


  <!-- Features -->

  <section id="features" class="padd-section">
    <div class="container-fluid">
      <div class="row txt">
      <div class="col-lg-4">
        <h3 class="auto"><i class="fa-solid fa-circle-check fa-2x icon-color"></i></br>Easy to use.</h3>
        <p class=auto-para>So easy to use, even your child could do it.</p>
      </div>
      <div class="col-lg-4">
        <h3 class="auto"><i class="fa-solid fa-bullseye fa-2x icon-color"></i></br>Elite Clientele</h3>
        <p class="auto-para">We have 3 layer of security, your data is safe.</p>
      </div>
      <div class="col-lg-4">
        <h3 class="auto"><i class="fa-solid fa-heart fa-2x icon-color"></i></br>Guaranteed to work.</h3>
        <p class="auto-para">Make your work easy or take your money back.</p>
      </div>
      </div>
    </div>

  </section>


  <!-- Testimonials -->

  <section id="testimonials" >
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner container-fluid">
      <div class="carousel-item active padd-section">
        <h2>With so many things to do, WedsPay really helps me to made my responsibilities easy.</h2>
        <img class ="testimonials-image" src="${pageContext.request.contextPath}/resources/images/photo.png" alt="Sushant-profile">
        <em>Sushant singh, Delhi</em>
      </div>
      <div class="carousel-item padd-section">
        <h2>Great service, Great work and Great responsibility. Makes the shagun collection a lot easier.</h2>
        <img class="testimonials-image" src="${pageContext.request.contextPath}/resources/images/deepak-image-2.jpg" alt="deepak-profile">
        <em>Deepak Chaudhary, Noida</em>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>




  </section>


  <!-- Press -->

  <section id="press">
    <img class="press-images" src="${pageContext.request.contextPath}/resources/images/TechCrunch.png" alt="tc-logo">
    <img class="press-images" src="${pageContext.request.contextPath}/resources/images/tnw.png" alt="tnw-logo">
    <img class="press-images" src="${pageContext.request.contextPath}/resources/images/bizinsider.png" alt="biz-insider-logo">
    <img class="press-images" src="${pageContext.request.contextPath}/resources/images/mashable.png" alt="mashable-logo">

  </section>


  <!-- Pricing -->

  <section id="pricing" class="padd-section">

  <h2>A Plan for Every Person's Needs</h2>
  <p>Simple and affordable price plans for your.</p>

  <div class="container-fluid">
    <div class="row">
      <div class="col-md-4 col-sm-6 space">
        <div class="card">
          <div class="card-header">
            <h3 class="d-name">Normal</h3>
          </div>
          <div class="card-body">
            <h2>Free</h2>
            <p>1 Time Access For Pro</p>
            <p>Unlimited Payment Per Day</p>
            <p>1 Time Payment Collection</p>
            <p>Unlimited App Usage</p>
            <div class="d-grid">
              <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/registerRequest'; return false;" class="btn btn-outline-dark">Sign Up</button>
            </div>

          </div>
        </div>
      </div>

      <div class="col-md-4 col-sm-6  space">
        <div class="card">
          <div class="card-header">
            <h3 class="d-name">Pro</h3>
          </div>
          <div class="card-body">
            <h2><span>&#8377;</span>999</h2>
            <p>1 Time Team Provided</p>
            <p>Unlimited Payment Per Day</p>
            <p>Unlimited Payment Collection</p>
            <p>Unlimited App Usage</p>
            <div class="d-grid">
              <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/registerRequest'; return false;" class="btn btn-dark">Sign Up</button>
            </div>
          </div>
        </div>
      </div>

      <div class="col-md-4 col-12 space">
        <div class="card">
          <div class="card-header">
            <h3 class="d-name">Ultra</h3>
          </div>
          <div class="card-body">
            <h2><span>&#8377;</span>1599</h2>
            <p>Unlimited Time Team Provided</p>
            <p>Unlimited Payment Per Day</p>
            <p>Unlimited Payment Collection</p>
            <p>Unlimited App Usage</p>
            <div class="d-grid">
              <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/registerRequest'; return false;" class="btn btn-dark">Sign Up</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


  </div>

</section>


  <!-- Call to Action -->

  <section id="cta" class="padd-section">
    <div class="section-cta container-fluid">
      <h3>To explore more Features Download our App.</h3>
      <button type="button" class="btn btn-dark btn-lg butn"><i class="fa-brands fa-apple"></i> Download</button>
      <button type="button" class="btn btn-outline-light btn-lg butn"><i class="fa-brands fa-google-play"></i> Download</button>
    </div>
  </section>


  <!-- Footer -->

  <footer id="footer" class="padd-section">
    <div class="footer-last container-fluid">
      <a href="https://www.linkedin.com/in/ashish-kumar-2267a116a" target="_blank"><i class="footer-pad fa-brands fa-twitter"></i></a>
      <a href="https://www.linkedin.com/in/ashish-kumar-2267a116a" target="_blank"><i class="footer-pad fa-brands fa-linkedin-in"></i></a>
      <a href="https://www.linkedin.com/in/ashish-kumar-2267a116a" target="_blank"><i class="footer-pad fa-brands fa-instagram"></i></a>
      <a href="https://www.linkedin.com/in/ashish-kumar-2267a116a" target="_blank"><i class="footer-pad fa-solid fa-envelope"></i></a>
      <p>&#169; Copyright 2022 WedsPay</p>
    </div>


  </footer>


</body>

</html>
