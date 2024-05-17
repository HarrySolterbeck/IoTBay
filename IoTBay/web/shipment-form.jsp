<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shipment Form</title>
</head>
<body>
    <h2>${shipment == null ? 'Add' : 'Edit'} Shipment</h2>
    <form action="shipments?action=${shipment == null ? 'insert' : 'update'}" method="post">
        <input type="hidden" name="shipmentId" value="${shipment.shipmentId}" />
        <label>Order ID:</label>
        <input type="text" name="orderId" value="${shipment.orderId}" required /><br>
        <label>Shipment Method:</label>
        <input type="text" name="shipmentMethod" value="${shipment.shipmentMethod}" required /><br>
        <label>Shipment Date:</label>
        <input type="date" name="shipmentDate" value="${shipment.shipmentDate}" required /><br>
        <label>Shipment Address:</label>
        <input type="text" name="shipmentAddress" value="${shipment.shipmentAddress}" required /><br>
        <input type="submit" value="Save" />
    </form>
</body>
</html>
