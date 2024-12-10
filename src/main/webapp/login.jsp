<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
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
    <form action="login" method="post">
      <h1 class="h3 mb-3 fw-bold text-center">Welcome Back!</h1>
      <p class="text-center mb-4">Sign in to continue</p>

      <div class="form-floating mb-3">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="email" required>
        <label for="floatingInput">Email address</label>
      </div>
      <div class="form-floating mb-3">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pass" required>
        <label for="floatingPassword">Password</label>
      </div>

      <button class="btn btn-primary w-100 py-2" type="submit">Sign In</button>
      <p class="mt-5 mb-3 text-body-secondary text-center">© 2017–2024</p>
    </form>
  </main>
   </div>
   <%@include file="includes/footer.jsp" %>
</body>
</html>
