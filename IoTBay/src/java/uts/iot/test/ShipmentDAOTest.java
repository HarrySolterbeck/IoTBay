package uts.iot.test;

import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import model.Shipment;
import dao.ShipmentDAO;

public class ShipmentDAOTest {
    private static Connection connection;
    private static ShipmentDAO shipmentDAO;

    @BeforeAll
    public static void setUp() {
        connection = Database.getConnection(); // Assume this method sets up the database connection
        shipmentDAO = new ShipmentDAO(connection);
    }

    @Test
    public void testAddShipment() throws SQLException {
        Shipment shipment = new Shipment();
        shipment.setOrderId(1);
        shipment.setShipmentMethod("Standard");
        shipment.setShipmentDate(Date.valueOf("2024-05-20"));
        shipment.setShipmentAddress("789 Pine St, City, Country");
        shipmentDAO.addShipment(shipment);
        Shipment result = shipmentDAO.getShipment(shipment.getShipmentId());
        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetAllShipments() throws SQLException {
        List<Shipment> shipments = shipmentDAO.getAllShipments();
        Assertions.assertTrue(shipments.size() > 0);
    }

    @Test
    public void testUpdateShipment() throws SQLException {
        Shipment shipment = shipmentDAO.getShipment(1);
        shipment.setShipmentMethod("Express");
        shipmentDAO.updateShipment(shipment);
        Shipment result = shipmentDAO.getShipment(1);
        Assertions.assertEquals("Express", result.getShipmentMethod());
    }

    @Test
    public void testDeleteShipment() throws SQLException {
        shipmentDAO.deleteShipment(1);
        Shipment result = shipmentDAO.getShipment(1);
        Assertions.assertNull(result);
    }
}
