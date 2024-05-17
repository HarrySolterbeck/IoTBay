<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shipment List</title>
</head>
<body>
    <h2>Shipment List</h2>
    <table border="1" width="80%">
        <tr>
            <th>ID</th>
            <th>Order ID</th>
            <th>Method</th>
            <th>Date</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="shipment" items="${listShipment}">
            <tr>
                <td>${shipment.shipmentId}</td>
                <td>${shipment.orderId}</td>
                <td>${shipment.shipmentMethod}</td>
                <td>${shipment.shipmentDate}</td>
                <td>${shipment.shipmentAddress}</td>
                <td>
                    <a href="shipments?action=edit&shipmentId=${shipment.shipmentId}">Edit</a>
                    <a href="shipments?action=delete&shipmentId=${shipment.shipmentId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="shipments?action=new">Add New Shipment</a>
</body>
</html>
