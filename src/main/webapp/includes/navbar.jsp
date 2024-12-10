<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand fw-bold" href="#">E-Commerce</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mx-auto mb-2 mb-lg-0 justify-content-center">
        <li class="nav-item me-4">
          <a class="nav-link active" aria-current="page" href="home.jsp">
            <i class="bi bi-house-door-fill"></i> Home
          </a>
        </li>
        <%
           Boolean isLoggedin=(Boolean) session.getAttribute("isLoggedIn");
           if(isLoggedin!=null){%>
        	  
             <li class="nav-item me-4">
               <a class="nav-link" href="carts.jsp">
                 <i class="bi bi-cart-fill"></i> Carts
               </a>
             </li>
              <li class="nav-item me-4">
               <a class="nav-link" href="orders.jsp">
                 <i class="bi bi-basket-fill"></i> Orders
               </a>
             </li>
             <li class="nav-item me-4">
               <a class="nav-link" href="logout">
                 <i class="bi bi-box-arrow-right"></i> Logout
               </a>
             </li>
        	   
           <%}
           else{ %>
        	   <li class="nav-item">
               <a class="nav-link" href="login.jsp">
                 <i class="bi bi-box-arrow-in-right"></i> Login
               </a>
             </li>
        	   
           <%}
         %>
       
      </ul>
    </div>
  </div>
</nav>
