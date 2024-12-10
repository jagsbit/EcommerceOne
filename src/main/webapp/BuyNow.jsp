 
<%@page import="pack.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        body {
            background-color: #f8f9fa;
        }
        .order-form {
            max-width: 500px;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
    </style>
    <%@include file="includes/header.jsp" %>
</head>
<body>
   <%
       Order o=(Order) session.getAttribute("single_order");
       int product_id=o.getId();
       int usert_id=o.getUser_id();
       int quantiy=o.getQuntity();
       String name=o.getName();
       String category=o.getCategory();
       double price=o.getPrice();
   %>
   <div class="order-form">
        <h2 class="text-center mb-4">Place Your Order</h2>
        <form action="addOrder" method="post"> <!-- Replace 'addOrder' with your servlet URL -->
            <div class="mb-3">
                <label for="productName" class="form-label">Product Name</label>
                <input type="text" class="form-control" id="productName" name="productName" value=<%=name %> readonly>
            </div>
            <div class="mb-3">
                <label for="category" class="form-label">Category</label>
                <input type="text" class="form-control" id="category" name="category" value=<%=category %> readonly>
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <input type="text" class="form-control" id="price" name="price" value=<%=price %> readonly>
            </div>
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
            <button type="submit" class="btn btn-success w-100">Place Order</button>
        </form>
    </div>
    <%@include file="includes/footer.jsp" %>
</body>
</html>