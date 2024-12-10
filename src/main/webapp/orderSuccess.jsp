<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Placed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background-color: #ffffff;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .tick {
            font-size: 100px;
            color: #28a745;
            margin-bottom: 20px;
        }
        .message {
            font-size: 20px;
            color: #333;
            margin-bottom: 10px;
        }
        .note {
            font-size: 16px;
            color: #555;
            margin-bottom: 20px;
        }
        .buttons {
            margin-top: 20px;
        }
        .buttons a {
            text-decoration: none;
            font-size: 16px;
            color: #fff;
            background-color: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
            margin: 5px;
            display: inline-block;
        }
        .buttons a:hover {
            background-color: #0056b3;
        }
        .logout-btn {
            background-color: #dc3545;
        }
        .logout-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="tick">&#10004;</div> <!-- Unicode for a checkmark -->
        <div class="message">Your order has been placed successfully!</div>
        <div class="note">It will be delivered in 7 days.</div>
        <div class="buttons">
            <a href="home.jsp">Home</a>
            <a href="logout" class="logout-btn">Logout</a>
        </div>
    </div>
</body>
</html>