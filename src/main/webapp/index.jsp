<%@page import="pack.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<%@include file="includes/header.jsp" %>
<style>
  .box {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
    height: 100vh;
    margin: 0;
    background: #f8f9fa;
  }
  main {
    background: #ffffff;
    padding: 2rem;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    margin-top: 5rem; /* Added margin to prevent overlap */
    width: 50%;
  }
</style>
</head>

<body>
   <%@include file="includes/navbar.jsp" %>
   <div class="box">
      <main class="form-signin">
    <form action="register" method="post">
      <h1 class="h3 mb-3 fw-normal">Create an account</h1>

      <div class="form-floating mb-3">
        <input type="text" class="form-control" id="floatingName" placeholder="Your Name" name="name" required >
        <label for="floatingName">Full Name</label>
      </div>
      <div class="form-floating mb-3">
        <input type="email" class="form-control" id="floatingEmail" placeholder="name@example.com" name="email" required>
        <label for="floatingEmail">Email address</label>
      </div>
      <div class="form-floating mb-3">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password"  name="pass1" required>
        <label for="floatingPassword">Password</label>
      </div>
      <div class="form-floating mb-3">
        <input type="password" class="form-control" id="floatingConfirmPassword" placeholder="Confirm Password" name="pass2" required>
        <label for="floatingConfirmPassword">Confirm Password</label>
      </div>

      <button class="btn btn-primary w-100 py-2" type="submit">Register</button>
      <p class="mt-3 text-center">
        Already have an account? <a href="login.jsp" class="text-decoration-none" style="color: #007bff;">Sign in</a>
      </p>
      <p class="mt-5 mb-3 text-body-secondary">© 2017–2024</p>
    </form>
  </main>
    </div>
   
  <%@include file="includes/footer.jsp" %>
</body>
</html>
