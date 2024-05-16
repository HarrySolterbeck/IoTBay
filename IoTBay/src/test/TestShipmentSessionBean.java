package test;

import javax.naming.InitialContext;
import ejb.ShipmentSessionBean;
import model.Shipment;
import java.util.Date;

public class TestShipmentSessionBean {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            ShipmentSessionBean shipmentBean = (ShipmentSessionBean) ctx.lookup("java:global/YourAppName/ShipmentSessionBean");

            Shipment shipment = new Shipment();
            shipment.setOrderId(123);
            shipment.setShipmentMethod("Air");
            shipment.setShipmentDate(new Date());
            shipment.setShipmentAddress("123 Main St, Anytown, USA");

            // Add shipment
            shipmentBean.addShipment(shipment);

            // Update shipment
            shipment.setShipmentMethod("Ground");
            shipmentBean.updateShipment(shipment);

            // Find shipment
            Shipment foundShipment = shipmentBean.findShipment(shipment.getShipmentId());
            System.out.println("Found shipment: " + foundShipment.getShipmentMethod());

            // Delete shipment
            shipmentBean.deleteShipment(shipment.getShipmentId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
