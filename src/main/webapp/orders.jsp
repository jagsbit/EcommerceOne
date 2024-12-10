<%@page import="pack.GetOrders"%>
<%@page import="pack.Order"%>
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
        <h1 class="text-center mb-4">Your Order</h1>

        <!-- Fetch Cart Items -->
        <%
            int user_id=(Integer)session.getAttribute("user_id");
            
           
            ArrayList<Order> order=GetOrders.getOrder(user_id);
            double totalPrice = 0.0;
            for (Order item : order) {
                totalPrice += item.getPrice() * item.getQuntity();
            }
        %>

        <!-- Total Price Section -->
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h3>Total Price: ₹<%= totalPrice %></h3>
            
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
                    for (Order item : order) {
                %>
                <tr>
                    <td><%= slNo++ %></td>
                    <td><%= item.getName() %></td>
                    <td><%= item.getCategory() %></td>
                    <td>₹<%= item.getPrice() %></td>
                    <td>
                         <input type="text" name="quantity" value="<%= item.getQuntity() %>" class="form-control me-2" min="1" style="width: 80px;">
                    </td>
                    <td>
                        <form action="removeOrder?order_id=<%= item.getOrder_id() %>" method="post">
                            <input type="hidden" name="itemId" value="<%= item.getId() %>">
                            <button type="submit" class="btn btn-danger btn-sm" >Cancel</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <% if (order.isEmpty()) { %>
        <div class="alert alert-info text-center">Your cart is empty!</div>
        <% } %>
    </div>
</body>
</html>