package dao;

import model.Shipment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShipmentDAO {
    private Connection connection;

    public ShipmentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addShipment(Shipment shipment) throws SQLException {
        String sql = "INSERT INTO shipments (order_id, shipment_method, shipment_date, shipment_address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, shipment.getOrderId());
            statement.setString(2, shipment.getShipmentMethod());
            statement.setDate(3, new java.sql.Date(shipment.getShipmentDate().getTime()));
            statement.setString(4, shipment.getShipmentAddress());
            statement.executeUpdate();
        }
    }

    public Shipment getShipment(int shipmentId) throws SQLException {
        String sql = "SELECT * FROM shipments WHERE shipment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, shipmentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Shipment shipment = new Shipment();
                shipment.setShipmentId(resultSet.getInt("shipment_id"));
                shipment.setOrderId(resultSet.getInt("order_id"));
                shipment.setShipmentMethod(resultSet.getString("shipment_method"));
                shipment.setShipmentDate(resultSet.getDate("shipment_date"));
                shipment.setShipmentAddress(resultSet.getString("shipment_address"));
                return shipment;
            }
        }
        return null;
    }

    public List<Shipment> getAllShipments() throws SQLException {
        List<Shipment> shipments = new ArrayList<>();
        String sql = "SELECT * FROM shipments";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Shipment shipment = new Shipment();
                shipment.setShipmentId(resultSet.getInt("shipment_id"));
                shipment.setOrderId(resultSet.getInt("order_id"));
                shipment.setShipmentMethod(resultSet.getString("shipment_method"));
                shipment.setShipmentDate(resultSet.getDate("shipment_date"));
                shipment.setShipmentAddress(resultSet.getString("shipment_address"));
                shipments.add(shipment);
            }
        }
        return shipments;
    }

    public void updateShipment(Shipment shipment) throws SQLException {
        String sql = "UPDATE shipments SET order_id = ?, shipment_method = ?, shipment_date = ?, shipment_address = ? WHERE shipment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, shipment.getOrderId());
            statement.setString(2, shipment.getShipmentMethod());
            statement.setDate(3, new java.sql.Date(shipment.getShipmentDate().getTime()));
            statement.setString(4, shipment.getShipmentAddress());
            statement.setInt(5, shipment.getShipmentId());
            statement.executeUpdate();
        }
    }

    public void deleteShipment(int shipmentId) throws SQLException {
        String sql = "DELETE FROM shipments WHERE shipment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, shipmentId);
            statement.executeUpdate();
        }
    }
}
