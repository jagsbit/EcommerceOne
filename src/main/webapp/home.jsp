<%@page import="pack.GetProducts"%>
<%@page import="pack.Products"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>all products here</title>
<%@include file="includes/header.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<%@include file="includes/footer.jsp" %>
<div class="container">
    <div class="row">
        <%
            ArrayList<Products> products = GetProducts.getProducts();
            for (Products p : products) {
        %>
        <div class="card" style="width: 17rem; margin: 10px;">
            <img src="<%= p.getImg() %>" class="card-img-top" alt="Product Image" style="width: 15rem; height: 11rem;">
            <div class="card-body">
                <h6 class="card-title"><%= p.getName() %></h6>
                <h5>Price: ₹<%= p.getPrice() %></h5>
                <h6>Category: <%= p.getCategory() %></h6>
                <!-- Buttons container -->
        <div class="d-flex justify-content-between mt-3">
            <a href="AddToCartServlet?product_id=<%= p.getId() %>" class="btn btn-primary" style="width: 48%; font-size: 0.9rem;">Add to Cart</a>
            <a href="createOrder?product_id=<%= p.getId() %>" class="btn btn-success" style="width: 48%; font-size: 0.9rem;">Buy Now</a>
        </div>
            </div>
        </div>
        <% } %>
    </div>
</div>

 
 
</body>
</html>