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
<style>
        
        .order-form {
            max-width: 1300px;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            ;

        }
    </style>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<%@include file="includes/footer.jsp" %>
   <div class="container mt-5">
        <h1 class="text-center mb-4">Place Your Order</h1>

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
                        
                       <input type="text" name="quantity" value="<%= item.getQuantity() %>" class="form-control me-2" min="1" style="width: 80px;">
                         
                    </td>
                    
                </tr>
                <% } %>
            </tbody>
        </table>

        <% if (carts.isEmpty()) { %>
        <div class="alert alert-info text-center">Your order is empty!</div>
        <% } %>
    </div>
   <div class="order-form">
    <form action="addOrderfromcart" method="post"> <!-- Replace 'addOrder' with your servlet URL -->
        <!-- Address Input -->
        <div class="mb-3">
            <label for="address" class="form-label">Delivery Address</label>
            <textarea class="form-control" id="address" name="address" placeholder="Enter your delivery address" required></textarea>
        </div>

        <!-- Payment Mode Dropdown -->
        <div class="mb-3">
            <label for="paymentMode" class="form-label">Payment Mode</label>
            <select class="form-select" id="paymentMode" name="paymentMode" required>
                <option value="Cash on Delivery" selected>Cash on Delivery</option>
            </select>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-success w-100">Place Order</button>
    </form>
</div>

</body>
</html>