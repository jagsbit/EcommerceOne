<%@page import="pack.GetCarts"%>
<%@page import="pack.Carts"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="includes/header.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<%@include file="includes/footer.jsp" %>
   <div class="container mt-5">
        <h1 class="text-center mb-4">Shopping Cart</h1>

        <!-- Fetch Cart Items -->
        <%
            int user_id=(Integer)session.getAttribute("user_id");
            
            ArrayList<Carts> carts=GetCarts.getCarts(user_id);
            double totalPrice = 0.0;
            for (Carts item : carts) {
                totalPrice += item.getPrice() * item.getQuantity();
            }
        %>

        <!-- Total Price Section -->
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h3>Total Price: ₹<%= totalPrice %></h3>
            <a href="cartCheckOut.jsp" class="btn btn-success btn-lg">CheckOut</a>
        </div>

        <!-- Cart Table -->
        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Sl No.</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int slNo = 1;
                    for (Carts item : carts) {
                %>
                <tr>
                    <td><%= slNo++ %></td>
                    <td><%= item.getName() %></td>
                    <td><%= item.getCategory() %></td>
                    <td>₹<%= item.getPrice() %></td>
                    <td>
                        <form action="updateItem?cart_id=<%= item.getCart_id() %>" method="post" class="d-flex">
                            <input type="hidden" name="itemId" value="<%= item.getId() %>">
                            <input type="number" name="quantity" value="<%= item.getQuantity() %>" class="form-control me-2" min="1" style="width: 80px;">
                            <button type="submit" class="btn btn-primary btn-sm">Update</button>
                        </form>
                    </td>
                    <td>
                        <form action="removeItem?cart_id=<%= item.getCart_id() %>" method="post">
                            <input type="hidden" name="itemId" value="<%= item.getId() %>">
                            <button type="submit" class="btn btn-danger btn-sm" >Remove</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <% if (carts.isEmpty()) { %>
        <div class="alert alert-info text-center">Your cart is empty!</div>
        <% } %>
    </div>
</body>
</html>